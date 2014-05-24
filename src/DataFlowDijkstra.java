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

public class DataFlowDijkstra {

	static  ArrayList<Edge>[] nodes;
	static boolean[] visited;
	static int[] prev;
	static long[][] capacity;
        static long[][] flow;
	static long[][] propagation;
        static long[] dist;
	static long linkCap;
	static long data;
	static long answer;
	static long sended;
        static long count;
        static long INF = Long.MAX_VALUE/2;
	
        static class Edge implements Comparable {
		int v;
		long w;
		Edge(int vv, long ww){
			v = vv;
			w = ww;
		}
		
		@Override
		public int compareTo(Object o){
                    if(this.w == ((Edge)o).w) return 0;
                    else if(this.w < ((Edge)o).w) return -1;
                    else return 1;
			
		}
                @Override
                public String toString(){
                    return v+" - "+w;
                }
	}
        f
	static long DijkstraResidualPath(int source, int sink){
		
		Arrays.fill(prev, -1);
		Arrays.fill(visited, false);
                Arrays.fill(dist, INF);
		Queue<Edge> queue = new PriorityQueue<Edge>();
		//visited[source] = true;
		queue.offer(new Edge(source, 0));
                dist[source] = 0;
		boolean found = false;
		while(!queue.isEmpty())
		{
			Edge u = queue.poll();
			if(u.v == sink){
				found = true;
				break;
			}
                        if(!visited[u.v])
                        {
                            visited[u.v] = true;
			for(Edge v:nodes[u.v])
				if((capacity[u.v][v.v] > flow[u.v][v.v]) && (dist[v.v] > dist[u.v] + u.w))
				{
					
					prev[v.v] = u.v;
                                        dist[v.v] = dist[u.v] + u.w;
					queue.offer(new Edge(v.v, dist[v.v]));
				}
                        }
		}
		if(!found) return 0;
		int to = sink;
		count = 0;
		long min = Long.MAX_VALUE;
		while(prev[to] != -1){
			
			//min = Math.min(min, capacity[prev[to]][to]);
                        min = Math.min(min, capacity[prev[to]][to]-flow[prev[to]][to]);
			to = prev[to];
		}
		
		to = sink;
                sended += min;
                String path = sink+"";
		while(prev[to] != -1){
			
			/*capacity[prev[to]][to]-=sended;
			capacity[to][prev[to]]+=sended;*/
                        flow[prev[to]][to]+=sended;
			flow[to][prev[to]]-=sended;
			count+= propagation[prev[to]][to];
			to = prev[to];
                        path = to+"-"+path;
		}
                System.out.println(path);
		System.out.println(count+" - "+min+" - "+sended);
		return count*min;
		
	
	}
	static boolean maxFlow(int source, int sink){
		answer = 0;
		long fromBFS = 0;
		sended = 0;
		
		while((fromBFS = DijkstraResidualPath(source, sink)) > 0){
			answer += fromBFS;
                        //System.out.println("* "+sended+" - "+data+" - "+answer);
			if(sended >= data){
                            //answer *=data;
                            long min = fromBFS/count;
                            answer -= (sended-data)*count;
                            return true;
                        }
		}
		return false;
	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] read;
		int source = 1;
		int sink = 1;
		String line = "";
		int n = 0;
		int m = 0;
		ArrayList<String> links;
		while((line = in.readLine()) != null){
			read = line.trim().split("[ ]+");
			n = Integer.parseInt(read[0]);
			m = Integer.parseInt(read[1]);
			sink = n;
			nodes = new ArrayList[n+1];
			visited = new boolean[n+1];
			prev = new int[n+1];
                        dist = new long[n+1];
			capacity = new long[n+1][n+1];
                        flow = new long[n+1][n+1];
			propagation = new long[n+1][n+1];
			for(int i=0;i<=n;i++) nodes[i] = new ArrayList<Edge>();
			links = new ArrayList<String>();
			for(int i=0;i<m;i++)
			links.add(in.readLine().trim());
			read = in.readLine().trim().split("[ ]+");
			data = Integer.parseInt(read[0]);
			linkCap = Integer.parseInt(read[1]);
			for(String x:links)
			{
				read = x.split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				long c = Long.parseLong(read[2]);
				nodes[u].add(new Edge(v, c));
				nodes[v].add(new Edge(u, c));
				capacity[u][v] = capacity[v][u] = linkCap;
				propagation[u][v] = propagation[v][u] = c; 
			}
                        
			System.out.println(maxFlow(source, sink)? answer:"Impossible.");
		
		}
		in.close();
		System.exit(0);
	}
}

/*
 * 10 16
1 9 8
6 9 7
7 9 83
10 9 6
8 9 64
3 9 62
4 9 59
2 4 29
4 8 29
8 5 64
3 5 40
6 5 2
10 5 76
5 7 70
4 7 7
7 1 21
805 22349
10 18
2 1 13
10 1 54
8 1 28
3 1 88
5 1 8
7 1 86
6 1 32
4 1 75
9 1 60
4 5 8
9 5 17
6 5 55
5 3 52
2 3 50
4 3 41
3 9 66
6 9 44
10 9 35
20235 21705
10 40
4 9 13
7 9 90
9 2 76
3 2 63
2 5 83
6 5 27
5 4 21
7 4 25
1 4 74
9 1 58
7 1 64
10 1 53
5 1 80
3 1 66
6 1 5
10 4 51
6 4 86
2 4 55
8 4 40
8 1 19
2 1 92
8 10 37
5 8 26
2 8 76
6 8 23
8 3 11
4 3 12
6 3 43
7 3 10
9 3 75
5 3 33
7 6 53
10 5 59
5 7 100
7 10 52
9 10 96
3 10 44
2 10 46
5 9 73
6 9 87
9750 13344
10 38
4 9 83
5 9 52
9 7 63
1 7 30
6 7 6
2 7 48
8 7 85
10 7 4
4 7 56
3 7 21
6 1 68
2 1 98
9 1 3
3 1 12
10 1 88
4 1 31
5 1 82
8 1 15
9 2 27
8 2 67
3 2 46
4 2 95
6 2 81
5 2 14
10 2 3
3 4 39
6 4 18
10 4 89
8 4 86
5 4 67
5 3 64
8 3 7
9 3 29
5 7 50
5 8 65
10 8 20
10 3 87
6 3 54
24639 8190
10 11
6 3 53
9 3 4
5 3 44
3 4 55
8 4 71
6 4 43
1 4 86
2 4 89
9 4 8
5 4 89
10 4 96
4972 23026
10 0
26969 1206
10 39
9 4 13
10 4 98
1 4 68
5 4 95
8 4 92
2 1 3
9 1 47
8 1 7
6 1 72
7 1 10
1 10 48
5 10 90
3 5 78
8 5 54
7 5 8
9 5 72
2 5 12
1 5 78
6 5 87
2 3 95
10 2 60
8 2 16
2 6 25
7 6 45
6 10 36
7 10 8
3 1 39
4 2 1
9 2 61
7 2 49
6 8 42
10 8 13
3 7 70
9 10 81
3 10 23
3 8 27
7 8 18
9 8 78
3 9 40
32702 15084
10 9
9 5 49
2 5 1
5 6 75
2 6 5
10 6 6
9 6 23
7 6 25
1 6 45
3 6 40
4124 28230
10 37
2 6 44
6 7 4
5 7 12
3 7 36
10 7 47
8 7 61
2 7 43
5 6 72
3 6 27
6 10 61
5 10 9
4 10 75
10 8 56
6 8 83
4 8 13
5 8 93
2 8 82
3 8 26
1 3 57
4 3 96
9 3 66
5 3 57
2 3 93
10 3 19
9 7 69
1 7 8
4 7 64
9 5 66
5 2 49
1 2 12
4 2 1
9 2 48
2 10 24
9 10 7
6 9 57
1 9 13
8 9 50
22137 19596
10 11
4 9 66
2 9 36
3 9 97
7 9 41
5 9 88
1 9 49
6 9 94
8 9 14
10 9 80
5 4 78
7 5 7
19920 24127
8 11
1 2 0
1 3 0
1 4 0
5 8 0
6 8 0
7 8 0
2 6 1
3 7 1
2 5 2
3 6 2
4 7 2
3 1
* 
11270
1092690
516750
841452
904904
Impossible.
694824
210324
465609
2569680

 */