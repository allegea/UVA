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

public class OceanCurrents
{
	static int N, M;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int INF = Integer.MAX_VALUE;
	static char[][] grid;
	static int[][] dist;
        static boolean[][] visited;
	
	static boolean canGo(int i, int j)
	{
		return i>=0 && i<N && j>=0 && j<M && !visited[i][j];
	}
	static class Edge implements Comparable<Edge>{
	
		int u;
		int v;
		int w;
		Edge(int uu, int vv, int ww)
		{
			u = uu;
			v = vv;
			w = ww;
		}
		@Override
		public int compareTo(Edge o)
		{
			return this.w - o.w;
		}
                
                @Override
                public String toString()
                {
                    return u+" - "+v+" - "+w;
                }
	}
	
	static int Dijkstra(int x1, int y1, int x2, int y2)
	{
                
		for(int i=0;i<N;i++)
                {
                    Arrays.fill(dist[i], INF);
                    Arrays.fill(visited[i], false);
                }
		Queue<Edge> q = new PriorityQueue<Edge>();
		q.offer(new Edge(x1, y1, 0));
                dist[x1][y1] = 0;
		while(!q.isEmpty())
		{
			Edge aux = q.poll();
                         //System.out.println(aux.toString());
			if(aux.u == x2 && aux.v == y2)
			return dist[x2][y2];
			
			if(visited[aux.u][aux.v])continue;
			visited[aux.u][aux.v] = true;
			for(int i=0;i<dx.length;i++)
			{
				int u = aux.u+dx[i];
				int v = aux.v+dy[i];
				if(canGo(u, v))
				{
					int cost = (i == (grid[aux.u][aux.v]-'0'))?0:1;
                                       // System.out.println(aux.toString()+" - "+cost+" - "+dist[u][v]);
					if(dist[u][v] > aux.w+cost)
					{
						dist[u][v] = aux.w+cost;
						q.offer(new Edge(u, v, dist[u][v]));
					}
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		int x1, x2, y1, y2;
		read = new StringTokenizer(in.readLine());
		N = Integer.parseInt(read.nextToken());
		M = Integer.parseInt(read.nextToken());
		grid = new char[N][M];
		dist = new int[N][M];
                visited = new boolean[N][M];
		for(int i=0;i<N;i++)
		grid[i] = in.readLine().toCharArray();
			
		int k = Integer.parseInt(in.readLine());
		for(int i=0;i<k;i++)
		{
			read = new StringTokenizer(in.readLine());
			x1 = Integer.parseInt(read.nextToken())-1;
			y1 = Integer.parseInt(read.nextToken())-1;
			x2 = Integer.parseInt(read.nextToken())-1;
			y2 = Integer.parseInt(read.nextToken())-1;
			System.out.println(Dijkstra(x1, y1, x2, y2));
		}

		
		in.close();
		System.exit(0);
	}

}