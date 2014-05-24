/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */
public class Dominos{

	static int[] SCC;
	static boolean[] visited;
	static ArrayList<Integer>[] nodes;
	static int posSCC;

	static void DFS_SCC(int u)
	{
		for(int v:nodes[u])
		{
			if(!visited[v])
			{
				visited[v] = true;
				DFS_SCC(v);
			}
		}
		SCC[posSCC++] = u;
	}
	
	static void DFS(int u)
	{
		if(visited[u])return;
		visited[u] = true;
		for(int v:nodes[u])
			DFS(v);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//ArrayList<Integer> inDegree;
		
		int test = Integer.parseInt(in.readLine());
		while(test-->0)
		{
			String[] read = in.readLine().trim().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			SCC = new int[n+1];
			visited = new boolean[n+1];
			nodes = new ArrayList[n+1];
			posSCC = 0;
                        for(int i=0;i<=n;nodes[i++] = new ArrayList<Integer>());
			for(int i=0;i<m;i++)
			{
				read = in.readLine().trim().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				nodes[u].add(v);
			}
			
			for(int i=1;i<=n;i++)
				if(!visited[i])
				{
					visited[i] = true;
					DFS_SCC(i);
				}
			
			visited = new boolean[n+1];
			int answer = 0;
                       // System.out.println(Arrays.toString(SCC));
			for(int i=n-1;i>=0;i--)
				if(!visited[SCC[i]])
				{
					answer++;
					
					DFS(SCC[i]);
				}
			System.out.println(answer);
					
		}
		in.close();
		System.exit(0);
		
	}
}