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
public class Ordering{

	public static ArrayList<Integer>[] nodes;
	public static boolean[] visited;
	public static final int m = 27;
	public static boolean Cycle;
	public static int[] indegr;
	public static int[] color;
	public static TreeSet<String> solutions;
        public static TreeSet<Character> letters;
        public static int size;
	public static void TopDFS(int u)
	{
                //System.out.println(u + " - "+Cycle + " - "+color[u]);
		if(Cycle || color[u] == 2)return;
		if(color[u] == 1)
		{
			Cycle = true;
			return;
		}
		if(color[u] == 2)return;
		color[u] = 1;
		for(int v:nodes[u])
			TopDFS(v);
		
		color[u] = 2;
	}
	
	public static void TopBFS(String answer, int n)
	{
                //System.out.println(answer+" - "+n+" - "+m);
		if(n == size)
		{
			solutions.add(answer);
		}else{
			for(char c:letters)
			{
				int u = c - 'A';
				if(indegr[u] == 0 && !visited[u])
				{
					visited[u] = true;
					for(int v:nodes[u])
						indegr[v]--;
						
					TopBFS(answer + (c) + " ", n + 1);
					
					for(int v:nodes[u])
						indegr[v]++;
				
					visited[u] = false;
				}
			
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		boolean noFirst = false;
		
		StringTokenizer st;
		while(n-->0)
		{
			if(noFirst)System.out.println();
			noFirst = true;
			in.readLine();
			letters = new TreeSet<Character>();
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens())
				letters.add(st.nextToken().charAt(0));
				
			//m = letters.size();
                        size = letters.size();
                        //System.out.println(letters);
			nodes = new ArrayList[m];
			visited = new boolean[m];
			indegr = new int[m];
			color = new int[m];
			solutions = new TreeSet<String>();
			for(char c:letters)
				nodes[c - 'A'] = new ArrayList<Integer>();
			
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens())
			{
				String cons = st.nextToken();
				int u = cons.charAt(0) - 'A';
				int v = cons.charAt(2) - 'A';
				nodes[u].add(v);
				indegr[v]++;
			}
                        //System.out.println(Arrays.toString(nodes));
			for(char c:letters)
			{	if(Cycle)break;
				int u = c - 'A';
				if(color[u] == 2)continue;
				TopDFS(u);
			}
			//System.out.println(Cycle);
			if(Cycle)System.out.println("NO");
			else{
				TopBFS("", 0);
				for(String x:solutions)
					System.out.println(x.trim());
			}
		}
		in.close();
		System.exit(0);
	
	}
}