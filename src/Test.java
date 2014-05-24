/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 *
 * @author Alejandro E. Garces
 */

public class Test{
    
    public static class Order implements Comparable{
        
        TreeSet<Integer> x;
        Order(TreeSet<Integer> xx)
        {
            x = new TreeSet<Integer>(xx);
        }
        
        @Override
        public int compareTo(Object o)
        {
            return x.first()-((Order)o).x.first(); 
        }
        
        @Override
        public String toString(){
            String output = "";
		for(int s:this.x)
			output+=" "+((char)(s+65));
            return output.trim();
        }
    }
	static int[] SCC;
	static int posSCC;
	static ArrayList<Integer>[] nodes;
	static ArrayList<Integer>[] nodesR;
	static boolean[] visited;
	static TreeSet<Integer> answer;

	public static void DFS_SCC(int u)
	{
		if(visited[u])return;
		visited[u] = true;
               // System.out.println(u);
		for(int v:nodesR[u])
			DFS_SCC(v);
		
		SCC[posSCC++] = u;
	}
	
	public static void DFS(int u)
	{
		if(visited[u])return;
                answer.add(u);
		visited[u] = true;
		for(int v:nodes[u])
			DFS(v);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[] used;
                ArrayList<Order> salida;
                boolean first = true;
		while(true)
		{
			
			int m = Integer.parseInt(in.readLine());

			if( m == 0 )break;
                        if(!first)System.out.println();
                        first = false;
			int n = 27;
			nodes = new ArrayList[n];
			nodesR = new ArrayList[n];
			visited = new boolean[n];
			used = new boolean[n];
			SCC = new int[n];
                        salida = new ArrayList<Order>();
			posSCC = 0;
			int currPos = 0;
			for(int i=0;i<n;i++)
			{
				nodes[i] = new ArrayList<Integer>();
				nodesR[i] = new ArrayList<Integer>();
			}
			
			for(int i=0;i<m;i++)
			{
				String[] read = in.readLine().split("[ ]+");
				int u = read[5].charAt(0)-65;
				used[u] = true;
				for(int j=0;j<6;j++)
				{
					int v = read[j].charAt(0)-65;
					if(v == u)continue;
					used[v] = true;
					nodes[u].add(v);
					nodesR[v].add(u);
				}
			}
			
			for(int i=0;i<n;i++)
				if(!visited[i] && used[i])
					DFS_SCC(i);
			
			/*System.out.println(Arrays.toString(nodes));
                        System.out.println(Arrays.toString(nodesR));
                        System.out.println(Arrays.toString(SCC));
                        System.out.println(Arrays.toString(used));
                        System.out.println(posSCC);*/
                                
			visited = new boolean[n];
                        
			for(int i=posSCC-1;i>=0;i--)
				if(!visited[SCC[i]] && used[SCC[i]])
				{
					answer = new TreeSet<Integer>();
					DFS(SCC[i]);
					salida.add(new Order(answer));
				}
                        
                        Collections.sort(salida);
                        for(Order x:salida)
                           System.out.println(x.toString());
			
		}
		
		in.close();
		System.exit(0);
		
	}
}