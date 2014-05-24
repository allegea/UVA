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

public class RouteRedundancy {
	static int[][] capacity;
	static int N;
	static ArrayList<Edge>[] nodes;
	static int INF = Integer.MAX_VALUE/2;
	
	static int BFS(int i, int j)
	{
		boolean[] visited = new boolean[N];
		int[] paths = new int[N];
		paths[i] = -1;
		visited[i] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean found = false;
		q.offer(i);
		while(!q.isEmpty())
		{
			int u = q.poll();
			if(u == j){
                            found = true;
                            break;
                        }
			
			for(Edge v:nodes[u])
			{
				if(!visited[v.u] && capacity[u][v.u] > 0)
				{
					visited[v.u] = true;
					paths[v.u] = u;
					q.offer(v.u);
				}
			}
			
		
		}
		if(!found)return 0;
		
		int min = Integer.MAX_VALUE;
		int prev = j;
                
		while(paths[prev] != -1)
		{
                       // System.out.print(paths[prev] + " - "+prev+"  ");
			min = Math.min(min, capacity[paths[prev]][prev]);
			prev = paths[prev];
		}
		
		prev = j;
		while(paths[prev] != -1)
		{
		
			capacity[paths[prev]][prev]-=min;
			capacity[prev][paths[prev]]+=min;
			prev = paths[prev];
		}
                //System.out.println("\n"+Arrays.toString(paths));
		//System.out.println(min+" - B");
		return min;
	}
	static long FordFulkerson(int i, int j)
	{
		long sum = 0;
		int aux = 0;
		while(true)
		{
			aux = BFS(i, j);
			sum+= aux;
			if(aux == 0)break;
			//System.out.println(sum+" - F");
		}
		
		return sum;
	}
	
	static class Edge implements Comparable<Edge>{
	
		int u;
		long w;
		Edge(int uu, long ww)
		{
			u = uu;
			w = ww;
		}
		
		@Override
		public int compareTo(Edge o)
		{
			if(this.w >= o.w)return -1;
			else return 1;
		}
		
		@Override
		public String toString()
		{
			return u+" - "+w;
		}
	}
	static long LargestCapacity(int i, int j)
	{
		long[] dist = new long[N];
		dist[i] = INF;
		boolean[] visited = new boolean[N];
		Queue<Edge> q = new PriorityQueue<Edge>();
		q.offer(new Edge(i, INF));
		
		while(!q.isEmpty())
		{
			Edge aux = q.poll();
			//if(aux.u == j)break;
			
			if(visited[aux.u])continue;
			visited[aux.u] = true;
			for(Edge x:nodes[aux.u])
			{
				long min = Math.min(aux.w, x.w);
				if(dist[x.u] < min)
				{
					dist[x.u] = min;
					q.offer(new Edge(x.u, min));
				}
			}
		}
		//System.out.println(dist[j]+" - PP");
               // System.out.println(Arrays.toString(dist));
		return dist[j];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		int u, v, d, m, x, y, w;
		StringTokenizer read;
		while(t-->0)
		{
			read = new StringTokenizer(in.readLine());
			d = Integer.parseInt(read.nextToken());
			N = Integer.parseInt(read.nextToken());
			m = Integer.parseInt(read.nextToken());
			u = Integer.parseInt(read.nextToken());
			v = Integer.parseInt(read.nextToken());
			capacity = new int[N][N];
			nodes = new ArrayList[N];
			for(int i=0;i<N;i++)nodes[i] = new ArrayList<Edge>();
			
			for(int i=0;i<m;i++)
			{
				read = new StringTokenizer(in.readLine());
				x = Integer.parseInt(read.nextToken());
				y = Integer.parseInt(read.nextToken());
				w = Integer.parseInt(read.nextToken());
				nodes[x].add(new Edge(y, w));
                                nodes[y].add(new Edge(x, w ));
				capacity[x][y] =   w;
			}
			
			long F = FordFulkerson(u, v);
			long L = LargestCapacity(u, v);
			System.out.printf("%d %.3f\n", d, F/(float)L);
			
		
		}
	}
	
}