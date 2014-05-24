/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Alejandro E. Garces
 */

public class ANodeTooFar {

	static int[][] paths;
	static int n;
	static int INF = Integer.MAX_VALUE/2;
	static HashMap<Integer, Integer> map;
        static int pos;
        
	static void query(int u, int ttl, int curr, int ori)
	{
		int answer = 0;
		for(int i=0;i<n;i++)
                        if(i == u)continue;
                        else if(paths[u][i] > ttl)
				answer++;
		System.out.println("Case "+curr+": "+answer+" nodes not reachable from node "+ori+" with TTL = "+ttl+".");
	}
        
        static int position(int u)
        {
            if(map.containsKey(u))
                return map.get(u);
            else {
		map.put(u, pos);
		return (pos++);
            }
        }

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int u, v, uu, vv;
		int curr = 1;
		while( true)
		{
			n = in.nextInt();
			if(n == 0)break;
			
			paths = new int[30][30];
			pos = 0;
			map = new HashMap<Integer, Integer>();
			for(int i=0;i<30;i++)
			Arrays.fill(paths[i], INF);
			
			for(int i=0;i<n;i++)
			{
				u = in.nextInt();
				v = in.nextInt();
				uu = position(u);
				vv = position(v);
                                paths[uu][vv] = paths[vv][uu] = 1;
			}
			n = pos;
			for(int k =0;k<n;k++)
				for(int i=0;i<n;i++)
					for(int j=0;j<n;j++)
						paths[i][j] = Math.min(paths[i][j], paths[i][k] + paths[k][j]);
			
			while(true)
			{
				u = in.nextInt();
				v = in.nextInt();
				if(u == 0 && v == 0)break;
				query(map.get(u), v, curr++, u);
			}
			
		}
		in.close();
		System.exit(0);
	}
}
