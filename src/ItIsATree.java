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

public class ItIsATree{

	static ArrayList<Integer>[] nodes;
	static HashSet<Integer> visited;
	static int m;
	static int N = 1000001;
	static boolean cycle;
	static void DFS(int u)
	{
		if(cycle)return;
		if(!visited.add(u)){
			cycle = true;
			return;
		}
                m++;
		for(int v:nodes[u])
			DFS(v);
		
	}
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int cases = 1;
		boolean end = false;
		HashSet<Integer> values;
		int[] indigree;
		while(true)
		{
			nodes = new ArrayList[N];
			values = new HashSet<Integer>();
			visited = new HashSet<Integer>();
			indigree = new int[N];
			
			while(true)
			{
				int u = in.nextInt();
				int v = in.nextInt();
				if(u == -1 && v == -1){
					end = true;
					break;
				}
				
				if(u == 0 && v == 0)break;
                                if(nodes[u] == null)nodes[u] = new ArrayList<Integer>();
                                if(nodes[v] == null)nodes[v] = new ArrayList<Integer>();
				nodes[u].add(v);
				indigree[v]++;
				values.add(u);
				values.add(v);
			}
			if(end)break;
			m = 0;
			cycle = false;
			for(int i:values)
				if(indigree[i] == 0)
				{
					DFS(i);
					break;
				}
			
			System.out.println("Case "+cases+" is "+(m == values.size() && cycle == false?"":"not ")+"a tree.");
			cases++;
		}
		
		in.close();
		System.exit(0);
	}
}