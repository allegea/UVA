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

public class TheTouristGuide
{
	static int N;
	static long INF = Long.MAX_VALUE;
	static ArrayList<Edge>[] nodes;
	
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
                        if(this.w > o.w)return -1;
                        return 1;
			//return o.w - this.w;
		}
	}
	static long inMaxPath(int u, int v)
	{
            //System.out.println(u+" - "+v);
		Queue<Edge> q = new PriorityQueue<Edge>();
		long[] dist = new long[N+1];
		boolean[] visited = new boolean[N+1];
		dist[u] = INF;
		q.offer(new Edge(u, INF));
		
		while(!q.isEmpty())
		{
			Edge x = q.poll();
			if(visited[x.u])continue;
			visited[x.u] = true;
			for(Edge y:nodes[x.u])
			{
				long dis = Math.min(x.w, y.w);
                               // System.out.println(x.u+" - "+x.w+" - "+y.u+" - "+y.w+" - "+dist[y.u]);
				if(dis > dist[y.u])
				{
					
					dist[y.u] = dis;
					q.offer(new Edge(y.u, dis));
				}
			}
		}
		//System.out.println(Arrays.toString(dist));
		return dist[v];
	
	}
	
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                Scanner in = new Scanner(System.in);
		int u, v, w;
		int curr = 1;
		while(true)
		{
                        N = Integer.parseInt(in.next());
			int m = Integer.parseInt(in.next());
			if(N == 0 && m == 0)break;
			nodes = new ArrayList[N+1];
			for(int i=0;i<=N;i++)nodes[i] = new ArrayList<Edge>();
			
			for(int i=0;i<m;i++)
			{
				u = Integer.parseInt(in.next());
				v = Integer.parseInt(in.next());
				w = Integer.parseInt(in.next());
				nodes[u].add(new Edge(v, w));
				nodes[v].add(new Edge(u, w));
			}
			
			u = Integer.parseInt(in.next());
			v = Integer.parseInt(in.next());
			w = Integer.parseInt(in.next());
			

			System.out.println("Scenario #"+curr);
                        if(u != v)
                        {
                            long maxValue = inMaxPath(u, v)-1;
                            System.out.println("Minimum Number of Trips = "+(int)Math.ceil(w/(float)maxValue));
                        }else System.out.println("Minimum Number of Trips = 0");
			
			System.out.println();
			curr++;

		}
		in.close();
		System.exit(0);
	}

}