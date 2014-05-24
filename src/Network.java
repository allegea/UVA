/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */
public class Network{

	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	static int N;
	static boolean[] articulation;
        static int count;
        static int[] num;
        static int[] low;
        static int[] parent;
        static int root;
        static int childs;
	
	static void DFS(int u)
	{
		if(visited[u])return;
		visited[u] = true;
		count++;
		for(int v:nodes[u])
			DFS(v);
	}
        
        static void articulations(int u)
        {
            num[u] = low[u] = count++;
            visited[u] = true;
            for(int v:nodes[u])
            {
                if(!visited[v])
                {
                    if(root == u) childs++;
                    parent[v] = u;
                    articulations(v);
                    low[u] = Math.min(low[v], low[u]);
                    if(low[v] >= num[u] )
                        articulation[u] = true;
                    
                    
                }else if(parent[u] != v)
                    low[u] = Math.min(low[u], num[v]);
            }
        }
        
        
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			N = Integer.parseInt(in.readLine());
			if(N == 0)break;
			visited = new boolean[N+1];
			count = 0;
                        articulation = new boolean[N+1];
			int answer = 0;
			nodes = new ArrayList[N+1];
                        num = new int[N+1];
                        low = new int[N+1];
                        parent = new int[N+1];
                       // Arrays.fill(low, Integer.MAX_VALUE);
                        //Arrays.fill(num, Integer.MAX_VALUE);
                        
			for(int i=0;i<=N;i++)nodes[i] = new ArrayList<Integer>();
			
			while(true)
			{
				String[] read = in.readLine().split("[ ]+");
				int m = Integer.parseInt(read[0]);
				if(m == 0)break;
				for(int i=1;i<read.length;i++)
				{
					int v = Integer.parseInt(read[i]);
					nodes[m].add(v);
					nodes[v].add(m);
				}
			}
                        
			for(int i=1;i<=N;i++)
                            if(!visited[i]){
                                root = i;
                                childs = 0;
                                articulations(i);
                                articulation[i] = (childs>1); 
                            }
			
                        for(int i=1;i<=N;i++)
                            if(articulation[i])
                                answer++;
			/*int conected = N;			
			
			for(int i=1;i<=N;i++)
			{
				visited = new boolean[N+1];
				count = 0;
                                int inAux = 0;
				ArrayList<Integer> aux = new ArrayList<Integer>(nodes[i]);
				nodes[i] = new ArrayList<Integer>();
                                //System.out.println(i+" - "+aux+" - "+nodes[i]);
				for(int j=1;j<=N;j++)
                                {
                                    visited = new boolean[N+1];
                                    count = 0;
					DFS(j);
                                    inAux = Math.max(inAux, count);    
                                        
                                }
                                
				//System.out.println(inAux + " - "+conected);
				if(inAux < conected)
				answer++;
				nodes[i] = new ArrayList<Integer>(aux);
			}
			System.out.println(answer);
                        */
                       /* System.out.println(Arrays.toString(nodes));
                        System.out.println(Arrays.toString(parent));
                        System.out.println(Arrays.toString(num));
                        System.out.println(Arrays.toString(low));*/
                        System.out.println(answer);
		}
		in.close();
		System.exit(0);
	}
}