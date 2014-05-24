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
public class StreetDirections {

	static ArrayList<Integer>[] nodes;
        static boolean[][] noPrint;
	static int[] parent;
	static int[] low;
	static int[] num;
	static int childrens;
	static boolean[] visited;
	static boolean[] arti;
	static int count;
	static int root;

	static void DFS_articulations(int u){
		low[u] = num[u] = count++;
		visited[u] = true;
		
		for(int v:nodes[u])
		{
			if(!visited[v]){
				if(root == u) childrens++;
				parent[v] = u;
				DFS_articulations(v);
                                System.out.println(u+" "+v);
                                noPrint[u][v] = noPrint[v][u] = true;
				if(low[v] > num[u]){
					arti[u] = true;
                                       // System.out.println(u+" - "+v);
                                        
                                        System.out.println(v+" "+u);
                                       
                                }
				low[u] = Math.min(low[u], low[v]);
			}
			else if(parent[u] != v)
                        {
                            low[u] = Math.min(low[u], num[v]);
                            if(!noPrint[u][v]){
                            System.out.println(u+" "+v);
                            noPrint[u][v] = noPrint[v][u] = true;
                            }
                        }
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test = 1;
		//boolean first = true;
                String line = "";
		while( (line = in.readLine()) != null)
		{
                        String[] read = line.trim().split("[ ]+");
                        //System.out.println(line+"===");
			int n = Integer.parseInt(read[0]);
                        int m = Integer.parseInt(read[1]);
			if(n == 0 && m == 0)break;
			//if(!first)System.out.println();
			//first = false;
                       // System.out.println();
			int pos = 0;
			count = 0;
			nodes = new ArrayList[n+1];
                        noPrint = new boolean[n+1][n+1];
			parent = new int[n+1];
			low =  new int[n+1];
			num = new int[n+1];
			visited = new boolean[n+1];
			arti = new boolean[n+1];
			
			for(int i=0;i<=n;i++)
			{
				nodes[i] = new ArrayList<Integer>();
                                
			}
			
			
			for(int j = 0;j<m;j++)
			{
				read = in.readLine().trim().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				nodes[u].add(v);
				nodes[v].add(u);
                               
			}
			
                       
                        System.out.println((test++)+"\n");
			for(int i=1;i<=n;i++)
			{
				if(!visited[i])
				{	
					root = i;
					childrens = 0;
					DFS_articulations(i);
					arti[i] = (childrens>1);
				}
				

			}
			
                        System.out.println("#");

		}
		in.close();
		System.exit(0);
	}
} 	