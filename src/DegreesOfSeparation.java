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
public class DegreesOfSeparation{
	static ArrayList<Integer>[] nodes;
	static HashMap<String, Integer> map;
	static int max;
	static int n;
	static int position(String x)
	{
		int n = map.size();
		if(map.containsKey(x))
			return map.get(x);
		map.put(x, n++);
		return n-1;
	}
	
	static boolean BFS(int x)
	{
		boolean[] visited = new boolean[n];
		int[] dist = new int[n];
		Queue<Integer> q = new LinkedList<Integer>();
		max = 0;
		int visit = 0;
		q.offer(x);
		visited[x] = true;
		visit++;
		while(!q.isEmpty())
		{
			int u = q.poll();
			for(int v:nodes[u])
			{
				if(!visited[v])
				{
					visited[v] = true;
					visit++;
					dist[v] = dist[u] +1;
					max = Math.max(max, dist[v]);
					q.offer(v);
				}
			}
		}
                //System.out.println(Arrays.toString(dist));
		//System.out.println(max+" - "+visit);
		return visit == n;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		boolean first = true;
		int curr = 1;
		while(true)
		{
			n = Integer.parseInt(in.next());
			int m = Integer.parseInt(in.next());
			if(n == 0 && m == 0)break;
			
			first = false;
			nodes = new ArrayList[n];
			map = new HashMap<String, Integer>();
			for(int i=0;i<n;i++) nodes[i] = new ArrayList<Integer>();
			
			for(int i=0;i<m;i++)
			{
				int u = position(in.next());
				int v = position(in.next());
				nodes[u].add(v);
				nodes[v].add(u);
			}
			//System.out.println(map);
			boolean conected = true;
			int degree = 0;
			for(int i=0;i<n && conected;i++)
			{
				conected = BFS(i);
				degree = Math.max(degree, max);
			}
			System.out.println("Network "+curr+": "+(conected?degree:"DISCONNECTED"));
			curr++;
                        System.out.println();
			
		}
		in.close();
		System.exit(0);
	}
	
}