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
public class PowerTransmission {
	static int[] prev;
	static int[][] capacity;
	static boolean[] visited;
	static ArrayList<Integer>[] nodes;
	static int N;
	static int sum = 200;
	
	static int BFSResidualGraph(int source, int sink){
		
		Arrays.fill(prev, -1);
		Arrays.fill(visited, false);
		Queue<Integer> q = new LinkedList<Integer>();
		visited[source] = true;
		q.offer(source);
		boolean found = false;
		while(!q.isEmpty())
		{
			int u = q.poll();
			if(u == sink)
			{
				found = true;
				break;
			}
			
			for(int v:nodes[u])
			{
				if(!visited[v] && capacity[u][v] > 0)
				{
					prev[v] = u;
					visited[v] = true;
					q.offer(v);
				}
			}
		}
		
		if(!found)return-1;
		int to = sink;
		int min = Integer.MAX_VALUE;
		while(prev[to] != -1)
		{
			min = Math.min(min, capacity[prev[to]][to]);
			to = prev[to];
		}
		
		//to = prev[sink];
                to  = sink;
		while(prev[to] != -1 /*&& prev[to] != source*/)
		{
                        if(to != sink && prev[to] != source)
			capacity[prev[to]][to]-=min;
			capacity[to][prev[to]]+=min;
                        
			to = prev[to];
		}
		
		return min;
	}
	static int maxFlow(int source, int sink){
		int answer = 0;
		int fromBFS = 0;
		while(( fromBFS = BFSResidualGraph(source, sink)) > 0)
			answer+=fromBFS;
		return answer;
	
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		String[] read;
		int source = 0;
		int sink = 0;
                boolean first = true;
		while((line = in.readLine()) != null)
		{
			N = Integer.parseInt(line);
			sink = N+1;
                        if(!first) System.out.println();
                        first = false;
			capacity = new int[N+sum+1][N+sum+1];
			prev = new int[N+sum+1];
			nodes = new ArrayList[N+sum+1];
			visited = new boolean[N+sum+1];
			for(int i=0;i<=N+sum;i++) nodes[i] = new ArrayList<Integer>();
			read = in.readLine().trim().split("[ ]+");
			for(int i=0;i<read.length;i++){
				nodes[i+1].add(sum+i+1);
				capacity[i+1][sum+i+1] = Integer.parseInt(read[i]);
			}
			
			int m = Integer.parseInt(in.readLine());
			for(int i=0;i<m;i++)
			{
				read = in.readLine().trim().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				int c = Integer.parseInt(read[2]);
				nodes[u+sum].add(v);
				capacity[u+sum][v] = c;
			}
			
			read = in.readLine().trim().split("[ ]+");
			int nn = Integer.parseInt(read[0]);
			int mm = Integer.parseInt(read[1]);
			read = in.readLine().trim().split("[ ]+");
			for(int i=0;i<nn;i++)
			{
				int v = Integer.parseInt(read[i]);
				nodes[source].add(v);
				capacity[source][v] = Integer.MAX_VALUE;
			}
			
			for(int i=0;i<mm;i++)
			{
				int v = Integer.parseInt(read[i+nn]);
				nodes[v+sum].add(sink);
				capacity[v+sum][sink] = Integer.MAX_VALUE;
			}
			
			System.out.print(maxFlow(source, sink));
		}
		in.close();
		System.exit(0);
	}
	
}
789
/*
4
10 20 30 40
6
1 2 5
1 3 10
1 4 13
2 3 5
2 4 7
3 4 20
3 1
1 2 3 4
2
50 100
1
1 2 100
1 1
1 2
8
100 100 100 100 100 100 100 100
12
1 2 5
1 3 7
1 4 6
2 5 4
2 6 3
3 6 4
3 7 1
4 7 5
5 8 3
6 8 7
7 6 4
7 8 6
1 1
1 8
6
100 100 100 100 100 100
10
1 2 4
1 3 3
2 3 2
2 4 2
2 5 2
3 4 4
3 5 3
4 6 6
5 4 5
5 6 10
1 1
1 6
6
100 100 100 100 100 100
10
1 2 3
1 4 4
2 3 4
2 4 5
2 5 1
3 6 2
4 3 1
4 5 2
5 3 3
5 6 6
1 1
1 6
7
100 100 100 100 100 100 100
13
1 2 10
1 3 20
1 4 10
2 1 30
2 5 20
3 5 15
3 6 20
4 6 20
5 2 30
5 7 15
6 4 30
6 7 30
7 6 10
1 1
1 7
100
100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100
2
1 50 30
23 33 30
2 2
34 33 50 1
9
100 100 100 100 100 100 100 100 100
18
1 2 15
1 3 10
2 1 10
2 4 12
2 5 10
3 6 9
4 5 15
5 4 8
5 6 12
5 7 9
5 8 10
6 3 5
6 8 15
7 4 7
7 9 10
8 6 1
8 9 18
9 6 8
1 1
1 9
8
100 100 100 100 100 100 100 100
12
1 2 5
1 3 7
1 4 6
2 5 4
2 6 3
3 6 4
3 7 1
4 7 5
5 8 3
6 8 7
7 8 6
7 6 4
1 1
1 8
4
100 100 100 100
4
1 2 5
1 3 2
2 4 2
3 4 5
1 1
1 4
10
30 10 14 10 5 10 14 20 10 20
10
1 4 10
1 5 10
2 6 5
3 7 20
4 8 10
5 8 13
6 9 5
6 7 5
7 9 15
7 10 20
3 1
1 2 3 9
10
30 10 14 10 5 10 14 20 10 20
10
1 4 10
1 5 10
2 6 5
3 7 20
4 8 10
5 8 13
6 9 5
6 7 5
7 9 15
7 10 20
3 3
1 2 3 8 9 10
4
20 20 20 20
4
1 2 6
1 3 10
2 4 6
3 4 1
1 1
1 4
8
20 15 17 5 10 25 20 50
10
1 4 15
1 5 5
2 5 10
2 6 10
3 6 25
6 5 10
4 7 10
5 7 15
5 8 10
6 8 15
3 2
1 2 3 7 8 
* 
* 
37
50
15
7
5
40
0
24
15
4
10
34
7
30
 */