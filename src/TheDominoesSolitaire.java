/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */

public class TheDominoesSolitaire {

	static Pair[] domi;
	static boolean answer;
	static boolean[] visited;
	static Pair start;
	static Pair end;
	static int n;
	static int m;
	
	static class Pair{
		int u;
		int v;
		Pair(int uu, int vv)
		{
			u = uu;
			v = vv;
		}
	}
	
	static void backtracking(int prev, int count)
	{
		if(answer) return;
		if(count == m && prev == end.u)
		{
			answer = true;
			return;
		}
		for(int i=0;i<n;i++)
		if(!visited[i])
		{
			int aux = -1;
			if(domi[i].u == prev)
			aux = domi[i].v;
			else if(domi[i].v == prev)
			aux = domi[i].u;
			else continue;
			visited[i] = true;
			backtracking(aux, count+1);
			visited[i] = false;
		}
	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while(true)
		{
			m = Integer.parseInt(in.readLine().trim());
			if(m == 0)break;
			n = Integer.parseInt(in.readLine().trim());
			String[] read = in.readLine().trim().split("[ ]+");
			int u = Integer.parseInt(read[0]);
			int v = Integer.parseInt(read[1]);
			start = new Pair(u, v);
			read = in.readLine().trim().split("[ ]+");
			u = Integer.parseInt(read[0]);
			v = Integer.parseInt(read[1]);
			end = new Pair(u, v);
			domi = new Pair[n];
			visited = new boolean[n];
			answer = false;
			for(int i=0;i<n;i++)
			{
				read = in.readLine().trim().split("[ ]+");
				u = Integer.parseInt(read[0]);
				v = Integer.parseInt(read[1]);
				domi[i] = new Pair(u, v);
			}
			
			backtracking(start.v, 0);
			
			System.out.println(answer?"YES":"NO");
		}
		in.close();
		System.exit(0);
	}
}