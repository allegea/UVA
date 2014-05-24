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
public class Vertex{

	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	
	static void DFS(int u)
	{
		for(int v:nodes[u])
		{
			if(!visited[v])
			{
				visited[v] = true;
				DFS(v);
			}
		}
	}
	
	static String output()
	{
		String out = "";
		int count = 0;
		for(int i=1;i<visited.length;i++)
			if(!visited[i])
			{
				count++;
				out+=i+" ";
			}
		out = count+" "+out;
		return out.trim();
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(in.readLine().trim());
			if(n == 0)break;
			nodes = new ArrayList[n+1];
			//visited = new boolean[n+1];
                        String[] read;
			for(int i=0;i<=n;i++)
				nodes[i] = new ArrayList<Integer>();
				
			while(true)
			{
				read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				if(u == 0)break;
				for(int i=1;i<read.length-1;i++)
				nodes[u].add(Integer.parseInt(read[i]));
			}	
			
			read = in.readLine().split("[ ]+");
			int m = Integer.parseInt(read[0]);
			for(int i=0;i<m;i++)
			{
				int u = Integer.parseInt(read[i+1]);
				visited = new boolean[n+1];
				DFS(u);
				System.out.println(output());
				
			}
			
		}
		in.close();
		System.exit(0);
	}
}