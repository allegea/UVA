/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */

public class Sabotage {

	static int N;
	static long[][] capacity;
	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
        static boolean[] visited2;
	static int[] prev;
	static ArrayList<String> answer;
        
        static void DFS2(int u)
        {
            if(visited[u])return;
            visited[u] = true;
           // System.out.println(u);
            for(int v:nodes[u])
                if(capacity[v][u] > 0)
                    DFS2(v);
        }
        static void DFS(int u)
        {
            if(visited2[u])return;
            visited2[u] = true;
            for(int v:nodes[u]){
                if(capacity[u][v] == 0 && visited[v])
                    System.out.println(u+" "+v);
                else DFS(v);
            }
            
        }
        
	static long BFSResidualPaths(int source, int sink)
	{
		Arrays.fill(visited, false);
		Arrays.fill(prev, -1);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(source);
                visited[source] = true;
		boolean found = false;
		
		while(!queue.isEmpty())
		{
			int u = queue.poll();
			if(u == sink)
			{
				found = true;
				break;
			}
			
			for(int v:nodes[u])
				if(!visited[v] && capacity[u][v] > 0)
				{
					visited[v] = true;
					prev[v] = u;
					queue.offer(v);
				}
		}
		
		if(!found)return 0;
		long maxflow = Long.MAX_VALUE;
		int to = sink;
		while(prev[to] != -1)
		{
			maxflow = Math.min(maxflow, capacity[prev[to]][to]);
			to = prev[to];
		}
		
		to = sink;
                boolean added = false;
		while(prev[to] != -1)
		{
			capacity[prev[to]][to]-=maxflow;
			capacity[to][prev[to]]+=maxflow;
                        if(!added && capacity[prev[to]][to] == 0)
                        {
                            answer.add(prev[to]+" "+to);
                            added = true;
                        }
			to = prev[to];
		}
		//System.out.println(Arrays.toString(prev));
		//System.out.println(maxflow);
		return maxflow;
	
	}
	static long MaxFlow(int source, int sink)
	{
		long max = 0;
		long currFlow = 0;
		while((currFlow = BFSResidualPaths(source, sink)) > 0){
		max+=currFlow;
                //System.out.println(currFlow);
                }
		return max;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] read;
		int source = 1;
		int sink = 2;
		while(true){
			read = in.readLine().trim().split("[ ]+");
			N = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			if(N == 0 && m == 0)break;
			
			nodes = new ArrayList[N+1];
			visited = new boolean[N+1];
                        visited2 = new boolean[N+1];
                        
			prev = new int[N+1];
			answer = new ArrayList<String>();
			capacity = new long[N+1][N+1];
			for(int i=0;i<=N;i++)nodes[i] = new ArrayList<Integer>();
			
			for(int i=0;i<m;i++)
			{	read = in.readLine().trim().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				long c = Long.parseLong(read[2]);
				nodes[u].add(v);
				nodes[v].add(u);
				capacity[u][v] = capacity[v][u] = c;
			}
			
			MaxFlow(source, sink);
			Arrays.fill(visited, false);
			DFS2(sink);
			DFS(source);
			/*for(String x:answer)
			System.out.println(x);*/
			System.out.println();
		}
		in.close();
		System.exit(0);
	}
}