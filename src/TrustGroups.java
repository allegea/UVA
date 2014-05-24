/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Alejandro E. Garces
 */

public class TrustGroups{
	static int[] SCC;
	static int posSCC;
	static ArrayList<Integer>[] nodes;
	static ArrayList<Integer>[] nodesR;
	static boolean[] visited;

	public static void DFS_SCC(int u)
	{
		if(visited[u])return;
		visited[u] = true;
		for(int v:nodesR[u])
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
		HashMap<String, Integer> mapNames;
		while(true)
		{
			String[] read = in.readLine().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			
			if(n == 0 && m == 0)break;
			nodes = new ArrayList[n];
			nodesR = new ArrayList[n];
			visited = new boolean[n];
			SCC = new int[n];
			posSCC = 0;
			int currPos = 0;
			mapNames = new HashMap<String, Integer>();
			for(int i=0;i<n;i++)
			{
				nodes[i] = new ArrayList<Integer>();
				nodesR[i] = new ArrayList<Integer>();
				mapNames.put(in.readLine().trim(), currPos++);
			}
			
			for(int i=0;i<m;i++)
			{
				int u = mapNames.get(in.readLine().trim());
				int v = mapNames.get(in.readLine().trim());
				nodes[u].add(v);
				nodesR[v].add(u);
			}
			
                        //System.out.println(mapNames);
                        //System.out.println(Arrays.toString(nodes));
                        //System.out.println(Arrays.toString(nodesR));
                        
			for(int i=0;i<n;i++)
				if(!visited[i])
					DFS_SCC(i);
			
			int answer = 0;
			visited = new boolean[n];
                       // System.out.println(Arrays.toString(SCC));
			for(int i=posSCC-1;i>=0;i--)
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