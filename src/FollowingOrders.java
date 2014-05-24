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

public class FollowingOrders{

	public static int n;
	public static ArrayList<Integer>[] nodes;
	public static TreeSet<String> solutions;
	public static  int[] indegrees;
	public static final int M = 27;
        public static TreeSet<Character> letters;
        public static boolean[] visited;
	//public static  q;
	
	/*public static void BT(Queue<Integer> q, String sol)
	{
		if(sol.length() == n)
			solutions.add(sol);
		else{
			while(!q.isEmpty())
			{
				int u = q.poll();
				for(int v:nodes[u])
				{
					indegrees[v]--;
					if(indegrees[v] == 0)
					{
						q.offer(v);
						BT(q, sol + (u + 'a'));
						indegrees[v]++;
					}
				}
				q.offer(u);
			}
		
		}
			
	}*/
        
        public static void BT(String sol)
	{
		if(sol.length() == n)
                {
                        //System.out.println(sol);
			solutions.add(sol);
                }
		else{
			for(char c: letters)
			{
				int u = c - 'a';
                                //System.out.println(c + " - "+sol + " - "+indegrees[u]+" - "+visited[u]);
                                if(indegrees[u] == 0 && !visited[u])
                                {
                                    visited[u] = true;
                                    for(int v:nodes[u])
                                            indegrees[v]--;
                  
                                     BT(sol + (char)(u + 'a'));
                                     for(int v:nodes[u])
                                            indegrees[v]++;
                                    visited[u] = false;
                                }
				//q.offer(u);
			}
		
		}
			
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringTokenizer st;
		boolean noFirst = false;
		while((line = in.readLine()) != null)
		{
                        if(noFirst)System.out.println();
                        noFirst = true;
                        solutions = new TreeSet<String>();
			Queue<Integer> q = new LinkedList<Integer>();
			st = new StringTokenizer(line);
			letters = new TreeSet<Character>();
			nodes = new ArrayList[M];
			indegrees = new int[M];
                        visited = new boolean[M];
			while(st.hasMoreTokens())
				letters.add(st.nextToken().charAt(0));
			
			n = letters.size();
                        //System.out.println(letters);
			for(char c:letters)
				nodes[c-'a'] = new ArrayList<Integer>();
			
			line = in.readLine();
			st = new StringTokenizer(line);
			while(st.hasMoreTokens())
			{
				int u = st.nextToken().charAt(0) - 'a';
				int v = st.nextToken().charAt(0) - 'a';
				nodes[u].add(v);
				indegrees[v]++;
			}
			
			for(char c:letters)
				if(indegrees[c - 'a'] == 0)
					q.offer(c - 'a');
			
			BT("");
			
			for(String x:solutions)
				System.out.println(x);
                        
                       // System.out.println();
			
		}
		in.close();
		System.exit(0);
	}
}