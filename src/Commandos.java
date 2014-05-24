/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */

public class Commandos{

	static int INF = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		int c = 0;
		int[][] paths;
		String[] read;
		while(c++<t)
		{
			int n = Integer.parseInt(in.readLine());
			paths = new int[n][n];
			for(int i=0;i<n;i++)
			Arrays.fill(paths[i], INF);
			int edges = Integer.parseInt(in.readLine());
			for(int i=0;i<edges;i++)
			{
				read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				paths[u][v] = paths[v][u] = 1;
			}
			read = in.readLine().split("[ ]+");
			int u = Integer.parseInt(read[0]);
			int v = Integer.parseInt(read[1]);
                        
			paths[u][u] = paths[v][v] = 0;
                        
			for(int k=0;k<n;k++)
				for(int i=0;i<n;i++)
					for(int j=0;j<n;j++)
						paths[i][j] = Math.min(paths[i][j], paths[i][k]+paths[k][j]);
						
                        
			int answer = 0;
			for(int i=0;i<n;i++)
                            answer=Math.max(answer, paths[u][i]+paths[i][v]);
			
			System.out.println("Case "+c+": "+answer);
		}
		in.close();
		System.exit(0);
	}
}