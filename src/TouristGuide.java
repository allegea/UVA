/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class TouristGuide {

	static ArrayList<Integer>[] nodes;
	static int[] parent;
	static int[] low;
	static int[] num;
	static int childrens;
	static boolean[] visited;
	static boolean[] arti;
	static int count;
	static int root;

	static void DFS_articulations(int u){
		low[u] = num[u] = count++;
		visited[u] = true;
		
		for(int v:nodes[u])
		{
			if(!visited[v]){
				if(root == u) childrens++;
				parent[v] = u;
				DFS_articulations(v);
				if(low[v] >= num[u])
					arti[u] = true;
				low[u] = Math.min(low[u], low[v]);
			}
			else if(parent[u] != v)
				low[u] = Math.min(low[u], num[v]);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> mapNames;
		String[] names;
		TreeSet<String> toShow;
		int test = 1;
		boolean first = true;
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			if(!first)System.out.println();
			first = false;
			int pos = 0;
			count = 0;
			mapNames = new HashMap<String, Integer>();
			toShow = new TreeSet<String>();
			nodes = new ArrayList[n];
			parent = new int[n];
			low =  new int[n];
			num = new int[n];
			visited = new boolean[n];
			arti = new boolean[n];
			names = new String[n];
			
			for(int i=0;i<n;i++)
			{
				nodes[i] = new ArrayList<Integer>();
				names[i] = in.readLine();
				mapNames.put(names[i], i);
			}
			
			int m = Integer.parseInt(in.readLine());
			for(int j = 0;j<m;j++)
			{
				String[] read = in.readLine().trim().split("[ ]+");
				int u = mapNames.get(read[0]);
				int v = mapNames.get(read[1]);
				nodes[u].add(v);
				nodes[v].add(u);
			}
			
			for(int i=0;i<n;i++)
			{
				if(!visited[i])
				{	
					root = i;
					childrens = 0;
					DFS_articulations(i);
					arti[i] = (childrens>1);
				}
				
				if(arti[i])
				toShow.add(names[i]);
			}
			
			System.out.println("City map #"+(test++)+": "+toShow.size()+" camera(s) found");
			for(String x:toShow)
			System.out.println(x);

		}
		in.close();
		System.exit(0);
	}
} 	