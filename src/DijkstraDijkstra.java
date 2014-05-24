/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */

public class DijkstraDijkstra {

	static ArrayList<Edge>[] nodes;
	static boolean[] visited;
	static boolean[][] disjointEdge;
	static int INF = Integer.MAX_VALUE;
	
	static class Edge implements Comparable {
		int v;
		int w;
		Edge(int vv, int ww){
			v = vv;
			w = ww;
		}
		
		@Override
		public int compareTo(Object o){
			return this.w - ((Edge)o).w;
		}
                @Override
                public String toString(){
                    return v+" - "+w;
                }
	}
	
	static int Dijkstra(int source, int sink)
	{
		Queue<Edge> queue = new PriorityQueue<Edge>();
		int[] prev = new int[sink+1];
		int[] dist = new int[sink+1];
		boolean found = false;
		Arrays.fill(prev, -1);
		Arrays.fill(dist, INF);
		Arrays.fill(visited, false);
		dist[source] = 0;
		//visited[source] = true;
		queue.offer(new Edge(source, 0));
		while(!queue.isEmpty())
		{
                        //System.out.println(queue);
			Edge u = queue.poll();
			
			if(u.v == sink)
			{
				found = true;
				break;
			}
			if(!visited[u.v]){
			visited[u.v] = true;
			for(Edge v:nodes[u.v])
			{
				if(!disjointEdge[u.v][v.v] && dist[v.v] > dist[u.v] + v.w)
				{
					dist[v.v] = dist[u.v] + v.w;
					prev[v.v] = u.v;
					queue.offer(new Edge(v.v, dist[v.v]));
				}
			}
			}
		}
		dsa
		if(!found) return -1;
		
		int to = sink;
		String path = to+"";
                //System.out.println("PATHS");
		while(prev[to] != -1)
		{
                        //System.out.println(prev[to]+" - "+to);
			disjointEdge[prev[to]][to] = true;
                        //disjointEdge[to][prev[to]] = true;
			to = prev[to];
                         path = to+" - "+path;
                        
		}
                System.out.println("Path "+path);
		System.out.println(dist[sink]);
                        
		return dist[sink];
	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			disjointEdge = new boolean[n+1][n+1];
			visited = new boolean[n+1];
			nodes = new ArrayList[n+1];
			for(int i=0;i<=n;i++)nodes[i] = new ArrayList<Edge>();
			int m = Integer.parseInt(in.readLine());
			
			for(int i=0;i<m;i++)
			{
				String[] read = in.readLine().trim().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				int w = Integer.parseInt(read[2]);
				nodes[u].add(new Edge(v, w));
				nodes[v].add(new Edge(u, w));
			}
			
			int answer = 0;
			int dijk = 0;
			dijk = Dijkstra(1, n);
			if(dijk != -1){
				answer += dijk;
				dijk = Dijkstra(1, n);
				if(dijk != -1)
				answer += dijk;
				else{
					System.out.println("Back to jail");
					continue;
				}
			}else{
					System.out.println("Back to jail");
					continue;
				}
			System.out.println(answer);
			
		}
		in.close();
		System.exit(0);
	}

}