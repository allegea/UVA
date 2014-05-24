/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class MaceAndMaze2{

	public static class Edge implements Comparable<Edge>{
	
		int x;
		int d;
		Edge(int xx, int dd)
		{
			x = xx;
			d = dd;
		}
			
		public int compareTo(Edge o)
		{
			return this.d - o.d;
		}
	}
	public static ArrayList<Edge>[] nodes;
	
	public static int dijkstra(int exit, int time, int size)
	{
	
		Queue<Edge> q = new PriorityQueue<Edge>();
		int[] dist = new int[size + 1];
		Arrays.fill(dist, INF);
		dist[exit] = 0;
		q.offer(new Edge(exit, 0));
		while(!q.isEmpty())
		{
		
			Edge x = q.poll();
			if(x.d > dist[x.x])
				continue;
			
			for(Edge y:nodes[x.x])
				if(dist[y.x] > dist[x.x] + y.d)
				{
					dist[y.x] = dist[x.x] + y.d;
					q.offer(new Edge(y.x, dist[y.x]));
				}
		}
		
		int answer = 0;
               // System.out.println(Arrays.toString(dist));
		for(int i = 0; i <= size; i++)
			if(dist[i] <= time)
				answer++;
		return answer;
	}
	
	public static final int INF = Integer.MAX_VALUE >> 1;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
                boolean noFirst = false;
		while(cases-- > 0)
		{
                        if(noFirst)System.out.println();
                        noFirst = true;
			in.readLine();
			int M = Integer.parseInt(in.readLine());
			int exit = Integer.parseInt(in.readLine());
			int time = Integer.parseInt(in.readLine());
			int  N = Integer.parseInt(in.readLine());
			nodes = new ArrayList[M + 1];
			
			for(int i = 0 ; i <= M; i++)
				nodes[i] = new ArrayList<Edge>();
                            
			StringTokenizer st;
			
			for(int i = 0; i < N; i ++)
			{
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				nodes[v].add(new Edge(u, t));
			}
			
			System.out.println(dijkstra(exit, time, M));
			
		}
		in.close();
		System.exit(0);
	}
}