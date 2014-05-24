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

public class Dominos2 {

	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	static int answer;
	
	static void DFS(int u)
	{
		if(visited[u])return;
		answer++;
		visited[u] = true;
		for(int v:nodes[u])
		DFS(v);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(in.readLine());
		int u=0;
		int v=0;
		while(tests-->0)
		{
			String[] read = in.readLine().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			int l = Integer.parseInt(read[2]);
			nodes = new ArrayList[n+1];
			visited = new boolean[n+1];
			for(int i=0;i<=n;i++)nodes[i] = new ArrayList<Integer>();
			for(int i=0;i<m;i++)
			{
				read = in.readLine().split("[ ]+");
				u = Integer.parseInt(read[0]);
				v = Integer.parseInt(read[1]);
				nodes[u].add(v);
			}
			answer = 0;
			for(int i=0;i<l;i++)
			{
				u = Integer.parseInt(in.readLine());
				DFS(u);
			}
			System.out.println(answer);
		}
		in.close();
		System.exit(0);
	}

}