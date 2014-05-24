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

public class InternetBandwidth {
	static int N;
	static int[][] capacity;
	static int[][] flow;
        
	//static boolean[] visited;
	//static int[] paths;
	static ArrayList<Integer>[] nodes;
	
	static int BFSAugPaths(int source, int sink){
	
		//Arrays.fill(visited, false);
		//Arrays.fill(paths, -1);
                boolean[] visited = new boolean[N+1];
                int[] paths = new int[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(source);
		visited[source] = true;
		paths[source]--;
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
			{
				if(!visited[v] && (capacity[u][v]-flow[u][v] > 0))
				{
					visited[v] = true;
					paths[v] = u;
					queue.offer(v);
				}
			}
		
		}
		
		if(!found)return -1;
		
		int incre = Integer.MAX_VALUE;
		int to = sink;
                int from = 0;
		while(paths[to] > 0)
		{
                        from = paths[to];
			incre = Math.min(incre, capacity[from][to]-flow[from][to]);
			to = from;
		}
		to = sink;
		while(paths[to] > 0)
		{
                        from = paths[to];
			flow[from][to]+=incre;
			flow[to][from]-=incre;
			to = from;
		}
              //  System.out.println(Arrays.toString(paths));
               // System.out.println(Arrays.deepToString(flow));
		
		return incre;
		
	}
	
	static int MaxFlow(int source, int sink){
		int answer = 0;
		int fromBFS = 0;
		while( ( fromBFS = BFSAugPaths(source, sink)) > 0 )
		answer+=fromBFS;
                //System.out.println(fromBFS);
		return answer;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int curr = 1;
		while(true)
		{
			N = Integer.parseInt(in.readLine());
			if(N == 0)break;
                       // if(curr > 1)System.out.println();
			nodes = new ArrayList[N+1];
			for(int i=0;i<=N;i++)nodes[i] = new ArrayList<Integer>();
			capacity = new int[N+1][N+1];
			//visited = new boolean[N+1];
			//paths = new int[N+1];
			flow = new int[N+1][N+1];
			String[] read = in.readLine().split("[ ]+");
			int s = Integer.parseInt(read[0]);
			int t = Integer.parseInt(read[1]);
			int m = Integer.parseInt(read[2]);
			
			for(int i=0;i<m;i++)
			{
				read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				int c = Integer.parseInt(read[2]);
				nodes[u].add(v);
				nodes[v].add(u);
				capacity[u][v] += c;
				capacity[v][u] += c;
			}
			
			System.out.println("Network "+(curr++));
			System.out.println("The bandwidth is "+MaxFlow(s, t)+".");
                        System.out.println();
			
		}
		in.close();
		System.exit(0);
	}

}
