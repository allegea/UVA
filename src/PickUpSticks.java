/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */

public class PickUpSticks{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> sticks;
		ArrayList<Integer>[] nodes;
		int[] inDegree;
		boolean[] visited;
		int[] print;
		
		while(true)
		{
			String[] read = in.readLine().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			
			if(n == 0 && m == 0)break;
			inDegree = new int[n+1];
			print = new int[n+1];
			visited = new boolean[n+1];
			nodes = new ArrayList[n+1];
			sticks = new LinkedList<Integer>();
			
			for(int i=0;i<=n;i++)
			nodes[i] = new ArrayList<Integer>();
			
			for(int i=0;i<m;i++)
			{
				read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				nodes[u].add(v);
				inDegree[v]++;
			}
			
			for(int i=1;i<=n;i++)
				if(inDegree[i] == 0)
				{
					sticks.offer(i);
					visited[i] = true;
				}
			
			int pos = 0;
			while(!sticks.isEmpty())
			{
				int u = sticks.poll();
				print[pos++] = u;

				for(int v:nodes[u])
				{
					inDegree[v]--;
					if(inDegree[v] == 0)
					{
						sticks.offer(v);
						visited[v] = true;
					}
				}
			}
			
			if(pos == n)
			for(int i=0;i<n;i++)
				System.out.println(print[i]);
			else System.out.println("IMPOSSIBLE");
		}
		
		in.close();
		System.exit(0);
	}
}

