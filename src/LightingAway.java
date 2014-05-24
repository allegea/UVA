/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Alejandro E. Garces
 */

public class LightingAway{
	static int[] SCC;
	static int posSCC;
	static ArrayList<Integer>[] nodes;
	static boolean[] visited;

	public static void DFS_SCC(int u)
	{
		if(visited[u])return;
		visited[u] = true;
		for(int v:nodes[u])
			DFS_SCC(v);
			
		SCC[posSCC++] = u;
	}
	public static void DFS(int u)
	{
		if(visited[u])return;
		visited[u] = true;
		for(int v:nodes[u])
			DFS(v);

	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int tests = Integer.parseInt(in.readLine());
		int current = 0;
                boolean first = true;
		while(current++<tests)
		{
                        if(!first)in.readLine();
                        first = false;
			String[] read = in.readLine().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
                        
			posSCC = 0;
			SCC = new int[n+1];
			visited = new boolean[n+1];
			nodes = new ArrayList[n+1];
			for(int i=0;i<=n;i++)
				nodes[i] = new ArrayList<Integer>();
				
			for(int i=0;i<m;i++)
			{
				read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				nodes[u].add(v);
			}
			
			for(int i=1;i<=n;i++)
				if(!visited[i])
					DFS_SCC(i);
					
			visited = new boolean[n+1];
			int answer = 0;
			for(int i=posSCC-1;i>=0;i--)
				if(!visited[SCC[i]])
				{	answer++;
					DFS(SCC[i]);
				}
				
			System.out.println("Case "+current+": "+answer);
                        
			
		}
		
		in.close();
		System.exit(0);
		
	}
}