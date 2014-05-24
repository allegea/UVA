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

public class WordTransformationF {

	public static ArrayList<Integer>[] nodes;
	public static ArrayList<String> dictionary;
	public static int M;
	
	public static boolean addEdge(String x, String y)
	{
		int n = x.length();
		int m = y.length();
		int min = Math.min(n, m);
		int dist = 0;
		for(int i = 0; i < min; i++)
			if(x.charAt(i) != y.charAt(i))
				dist++;
		dist+=Math.abs(n - m);
		return dist <= 1;
	}
	
	public static int BFS(int u, int v)
	{
             //System.out.println(u + " - " + v);
		int[] dist = new int[M];
		boolean[] visited = new boolean[M];
		visited[u] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(u);
		while(!q.isEmpty())
		{
			int uu = q.poll();
			if(uu == v)return dist[v];
			for(int vv:nodes[uu])
			{
				if(!visited[vv])
				{
					visited[vv] = true;
					dist[vv] = dist[uu] + 1;
					q.offer(vv);
				}
			}
		}
		
		return 0;
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		in.readLine();
		int cases = 0;
		HashMap<String, Integer> map;
		boolean noFirst = false;
		int pos = 0;
		String line = "";
		while(cases++ < N)
		{
                    pos = 0;
			if(noFirst) System.out.println();
			noFirst = true;
			map = new HashMap<String, Integer>();
			dictionary = new ArrayList<String>();
			while((line = in.readLine()) != null && line.compareTo("*") != 0)
			{
				map.put(line, pos++);
				dictionary.add(line);
			}
				
			M = map.size();
                        //System.out.println("M = "+M);
                       // System.out.println(map);
			nodes = new ArrayList[M];
			for(int i = 0; i < M; i++)
				nodes[i] = new ArrayList<Integer>();
			
			for(int i = 0; i < M; i++)			
				for(int j = i + 1; j < M; j++)
					if(addEdge(dictionary.get(i), dictionary.get(j)))
					{
						nodes[i].add(j);
						nodes[j].add(i);
					}
			
			while((line = in.readLine()) != null && line.length() > 0)
                        {
                            String[] input = line.split("[ ]+");
                            //System.out.println(Arrays.toString(input));
                            System.out.println(input[0] + " " + input[1] + " " + BFS(map.get(input[0]), map.get(input[1])));
                        }
		}
		in.close();
		System.exit(0);
	}
}