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

public class Wormholes{//Floyd-Warshal
	
	static int INF = Integer.MAX_VALUE/2;
        static class Edge{
            
            int v;
            int w;
            Edge(int vv, int ww)
            {
                v = vv;
                w = ww;
            }
            
        }

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
                ArrayList<Edge>[] nodes;
		int t = Integer.parseInt(in.readLine());
		int[] dist;
		int n, m;
		while(t-->0)
		{
			read = new StringTokenizer(in.readLine());
			n = Integer.parseInt(read.nextToken());
			m = Integer.parseInt(read.nextToken());
			dist = new int[n];
                        nodes = new ArrayList[n];
                        for(int i=0;i<n;i++)nodes[i] = new ArrayList<Edge>();
                        
			Arrays.fill(dist, INF);
                       // dist[0] = 0;
			
			for(int i=0;i<m;i++)
			{
				read = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(read.nextToken());
				int v = Integer.parseInt(read.nextToken());
				int w = Integer.parseInt(read.nextToken());
				nodes[u].add( new Edge(v, w));
			}
			
			for(int i=0;i<n-1;i++)
                            for(int u=0;u<n;u++)
                                for(Edge x:nodes[u])
                                    dist[x.v] = Math.min(dist[x.v], dist[u]+x.w);
			
                        boolean answer = true;
                        for(int u=0;u<n && answer;u++)
                                for(Edge x:nodes[u])
                                {
                                    if(dist[x.v] > dist[u]+x.w)
                                    {
                                        answer = false;
                                        break;
                                    }
                                }
			System.out.println(!answer?"possible":"not possible");
		}
		in.close();
		System.exit(0);
	}
}

/*public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		int t = Integer.parseInt(in.readLine());
		int[][] dist;
		int n, m;
		while(t-->0)
		{
			read = new StringTokenizer(in.readLine());
			n = Integer.parseInt(read.nextToken());
			m = Integer.parseInt(read.nextToken());
			dist = new int[n][n];
			for(int i=0;i<n;i++)Arrays.fill(dist[i], INF);
			
			for(int i=0;i<m;i++)
			{
				read = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(read.nextToken());
				int v = Integer.parseInt(read.nextToken());
				int w = Integer.parseInt(read.nextToken());
				dist[u][v] = w;
			}
			
			for(int k=0;k<n;k++)
				for(int i=0;i<n;i++)
					for(int j=0;j<n;j++)
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					
			boolean possi = false;
			for(int i=0;i<n;i++)
				if(dist[i][i] < 0)
				{
					possi = true;
					break;
				}
				
			System.out.println(possi?"possible":"not possible");
		}
		in.close();
		System.exit(0);
	}*/