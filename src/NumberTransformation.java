/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class NumberTransformation{

	static int n = 1000;
	static boolean[] noPrimes = new boolean[n+1];
	static ArrayList<Integer>[] factors = new ArrayList[n+1];
	static boolean[] visited;
	static int[] dist;
	static int BFS(int s, int t)
	{
                if(!noPrimes[s] || !noPrimes[t])return -1;
		Queue<Integer> q = new LinkedList<Integer>();
		visited = new boolean[n+1];
		dist = new int[n+1];
		q.add(s);
		while(!q.isEmpty())
		{
                   
			int x = q.poll();
			int d = dist[x];
                         //System.out.println("***" + x+" - "+d);
			if(x == t)
			return d;
			//System.out.println(factors[x]);
			for(int f:factors[x])
			{
				int y = x+f;
				if(y>t)break;
                                if(visited[y])continue;
				visited[y] = true;
				dist[y] = d+1;
                               // System.out.println(x+" - "+f+" - "+y);
				q.offer(y);
			}
		}
                return -1;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test = 1;
		for(int i=0;i<=n;i++)
		factors[i] = new ArrayList<Integer>();
		
		for(int i=3;2*i<=n;i+=2)
			if(!noPrimes[i])
			for(int j=2*i;j<=n;j+=i)
			{
				noPrimes[j] = true;
				factors[j].add(i);
			}
			
		for(int i=4;i<=n;i+=2)
			factors[i].add(0, 2);
				
		while(true)
		{
			String[] read = in.readLine().split("[ ]+");
			int s = Integer.parseInt(read[0]);
			int t = Integer.parseInt(read[1]);
                        if(s==0 && t == 0)break;
			
			System.out.println("Case "+test+": "+BFS(s, t));
			test++;
		}
                in.close();
                System.exit(0);
	}
}
	