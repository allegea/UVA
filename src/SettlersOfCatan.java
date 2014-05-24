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

public class SettlersOfCatan{
	static ArrayList<Integer>[] nodes;
	static boolean[][] edges;
	static int answer;
	
	static int backtracking(int u, int count)
	{
		int answ = 0;
		for(int v:nodes[u])
			if(!edges[u][v])
			{
				edges[u][v] = edges[v][u] = true;
				answ = Math.max(answ, backtracking(v, count + 1));
				edges[u][v] = edges[v][u] = false;
			}
		answ = Math.max(count, answ);
		return answ;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] read = in.readLine().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			if(n == 0 && m == 0)break;
			edges = new boolean[n][n];
			nodes = new ArrayList[n];
			for(int i=0;i<n;i++)nodes[i] = new ArrayList<Integer>();
			for(int i=0;i<m;i++)
			{
				read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				nodes[u].add(v);
				nodes[v].add(u);
			}
			
			int answer = 0;
			for(int i=0;i<n;i++)
			{
				edges = new boolean[n][n];
				answer = Math.max(answer, backtracking(i, 0));
                                //System.out.println(answer+" - "+i);
			}
			System.out.println(answer);
		
		}
		in.close();
		System.exit(0);
	}

}