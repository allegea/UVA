/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class Risk {

        
	static int INF = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		String line = "";
		int t = 1;
		int[][] paths;
		int n = 20;
		while((line = in.readLine())!=null && line.length() > 0)
		{
			paths = new int[n+1][n+1];
			for(int i=1;i<=n;i++)
			Arrays.fill(paths[i], INF);
			
			for(int i=1;i<20;i++)
			{
				read = new StringTokenizer(line);
				int m = Integer.parseInt(read.nextToken());
				for(int j=0;j<m;j++)
				{
					int u = Integer.parseInt(read.nextToken());
					paths[i][u] = paths[u][i] = 1;
				}
				line = in.readLine();
			}
                        //System.out.println(line+" --");
			for(int k=1;k<=n;k++)
				for(int i=1;i<=n;i++)
					for(int j=1;j<=n;j++)
					paths[i][j] = Math.min(paths[i][j], paths[i][k] + paths[k][j]);
					
			System.out.println("Test Set #"+t);
			t++;
			int m = Integer.parseInt(line);
			for(int i=0;i<m;i++)
			{
                                read = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(read.nextToken());
                                String uu = (u>=10)?""+u:" "+u;
                                
				int v = Integer.parseInt(read.nextToken());
                                String vv = (v>=10)?""+v:" "+v;
				//System.out.printf("%2d to %2d: %d\n",u,v,BFS(u, v));
                                System.out.println(uu+" to "+vv+": "+paths[u][v]);

			}
                        System.out.println();
		}
		in.close();
		System.exit(0);
        }
		
}
