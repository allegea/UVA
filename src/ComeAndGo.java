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

public class ComeAndGo {
	static int posSCC;
	static int[] SCC;
	static ArrayList<Integer>[] nodes;
	static ArrayList<Integer>[] nodesR;
	static boolean[] visited;
	
	public static void DFS_SCC(int u)
	{
		for(int v:nodesR[u])
		{
			if(!visited[v])
			{
				visited[v] = true;
				DFS_SCC(v);
			}
		}
		
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
		
		while(true)
		{
			String[] read = in.readLine().trim().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			if(n == m && n == 0)break;
			nodes = new ArrayList[n+1];
                        nodesR = new ArrayList[n+1];
			SCC = new int[n+1];
			posSCC = 0;
			visited = new boolean[n+1];
			for(int i=0;i<=n; i++)
			{
				nodes[i] = new ArrayList<Integer>();
				nodesR[i] = new ArrayList<Integer>();
			}
			
			for(int i=0;i<m;i++)
			{
				read = in.readLine().trim().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]); 
				nodes[u].add(v);
				nodesR[v].add(u);
				if(read[2].compareTo("2") == 0){
				nodes[v].add(u);
				nodesR[u].add(v);
				}
			}
			
			for(int i=1;i<=n;i++)
				if(!visited[i])
				{
					visited[i] = true;
					DFS_SCC(i);
				}
			
			visited = new boolean[n+1];
			int count = 0;
                        //System.out.println(Arrays.toString(SCC));
			for(int i=posSCC-1;i>=0 && count < 2;i--)
				if(!visited[SCC[i]])
				{   
                                    //System.out.println(count+" - "+i);
					count++;
					DFS(SCC[i]);
				}
				
			System.out.println((count == 1)?1:0);
			
		}
		in.close();
		System.exit(0);
	}
	
}