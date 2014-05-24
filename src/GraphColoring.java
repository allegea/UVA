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

public class GraphColoring
{
	static TreeSet<Integer> blacksNodes;
	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	static int[] color;
	static int maxColor;
	static int[] amount;
	static void DFS(int u)
	{
		if(visited[u])return;
		visited[u] = true;
		if(color[u] == maxColor) blacksNodes.add(u);
		for(int v:nodes[u])
			DFS(v);
	}
	
	static void coloring(int u)
	{
		for(int v:nodes[u])
			if(!visited[v])
			{
                                System.out.println(u+" - "+v);
				color[v] = 1-color[u];
                                System.out.println(color[u]+" - "+color[v]);
				amount[color[v]]++;
				visited[v] = true;
				coloring(v);
			}
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer r;
		while(n-->0)
		{
			r = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(r.nextToken());
			int k = Integer.parseInt(r.nextToken());
			nodes  = new ArrayList[m+1];
			color = new int[m+1];
			visited = new boolean[m+1];
			amount = new int[2];
			blacksNodes = new TreeSet<Integer>();
			for(int i=0;i<=m;i++)nodes[i] = new ArrayList<Integer>();
			
			for(int i=0;i<k;i++)
			{
				r = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(r.nextToken());
				int v = Integer.parseInt(r.nextToken());
				nodes[u].add(v);
				nodes[v].add(u);
			}
			visited[1] = true;
                        amount[0]++;
			coloring(1);
			maxColor = 1;
                        System.out.println(Arrays.toString(amount));
                        System.out.println(Arrays.toString(color));
			if(amount[0] >= amount[1])maxColor = 0;
			visited = new boolean[m+1];
			DFS(1);
			System.out.println(amount[maxColor]);
			String answer = "";
			for(int x:blacksNodes)
			answer+=x+" ";
			System.out.println(answer.trim());
			
			
			
		}
		in.close();
		System.exit(0);
	}
}