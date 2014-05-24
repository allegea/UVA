/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 *
 * @author Alejandro E. Garces
 */

public class SubDictionary{
	static int[] SCC;
	static int posSCC;
	static LinkedHashSet<Integer>[] nodes;
	static LinkedHashSet<Integer>[] nodesR;
	static boolean[] visited;
	static ArrayList<Integer> numbers;
	static HashMap<String, Integer> mapNames;
	static int current;
	
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
		numbers.add(u);
		for(int v:nodes[u])
			DFS(v);

	}
	
	public static int getPosition(String word)
	{
		int u = -1;
		if(mapNames.containsKey(word))
		u = mapNames.get(word);
		else {
		u = current;
		mapNames.put(word, current++);
		}
		return u;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<String> orderNames;
		String[] words;
		while(true)
		{
			int n = Integer.parseInt(in.readLine().trim());
			if(n == 0)break;
			posSCC = 0;
			SCC = new int[n];
			visited = new boolean[n];
			nodes = new LinkedHashSet[n];
			nodesR = new LinkedHashSet[n];
			current = 0;
			mapNames = new HashMap<String, Integer>();
			words = new String[n];
			orderNames = new TreeSet<String>();
			
			for(int i=0;i<n;i++)
			{
				nodes[i] = new LinkedHashSet<Integer>();
				nodesR[i] = new LinkedHashSet<Integer>();
			
			}
			
			for(int i=0;i<n;i++)
			{
				String[] read = in.readLine().trim().split("[ ]+");
				int u = getPosition(read[0]);
				words[u] = read[0];
				for(int j=1;j<read.length;j++)
				{
					int v = getPosition(read[j]);
					words[v] = read[j];
					nodes[u].add(v);
					nodesR[v].add(u);
				}
			}
			
			for(int i=0;i<n;i++)
				if(!visited[i])
					DFS_SCC(i);
					
			visited = new boolean[n];
			
			for(int i=posSCC-1;i>=0;i--)
				if(!visited[SCC[i]])
				{	
					numbers =  new ArrayList<Integer>();
					DFS(SCC[i]);
					if(numbers.size() > 1)
					for(int x:numbers)
					orderNames.add(words[x]);
				}
				
			System.out.println(orderNames.size());
                        if(orderNames.size() > 0){
			String output = "";
			for(String x:orderNames)
			output += x + " ";
			System.out.println(output.trim());
                        }

		}
		
		in.close();
		System.exit(0);
		
	}
}