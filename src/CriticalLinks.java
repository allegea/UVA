/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class CriticalLinks {

       public static class Articulation implements Comparable{
           
           int u;
           int v;
           Articulation(int uu, int vv){
               u = uu;
               v = vv;
           }
           
           @Override
           public int compareTo(Object o){
               
               if(this.u - ((Articulation)o).u != 0)
               return this.u - ((Articulation)o).u;
               return this.v - ((Articulation)o).v;
           }
           
           @Override
           public String toString(){
               return u+" - "+v;
           }
       }
	static ArrayList<Integer>[] nodes;
        static ArrayList<Articulation> answer;
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
				if(low[v] > num[u]){
					arti[u] = true;
                                       // System.out.println(u+" - "+v);
                                        answer.add(new Articulation(Math.min(u,v), Math.max(u,v)));
                                }
				low[u] = Math.min(low[u], low[v]);
			}
			else if(parent[u] != v)
				low[u] = Math.min(low[u], num[v]);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test = 1;
		//boolean first = true;
                String line = "";
		while( (line = in.readLine()) != null)
		{
			int n = Integer.parseInt(line);
			//if(n == 0)break;
			//if(!first)System.out.println();
			//first = false;
			int pos = 0;
			count = 0;
			nodes = new ArrayList[n];
			parent = new int[n];
			low =  new int[n];
			num = new int[n];
			visited = new boolean[n];
			arti = new boolean[n];
                        answer = new ArrayList<Articulation>();
			
			for(int i=0;i<n;i++)
			{
				nodes[i] = new ArrayList<Integer>();
			}
			
			
			for(int j = 0;j<n;j++)
			{
				String[] read = in.readLine().trim().split("[ ]+");
				int u = Integer.parseInt(read[0]);
                                for(int i = 2; i<read.length;i++){
				int v = Integer.parseInt(read[i]);
				nodes[u].add(v);
				nodes[v].add(u);
                                }
			}
			
			for(int i=0;i<n;i++)
			{
				if(!visited[i])
				{	
					root = i;
					childrens = 0;
					DFS_articulations(i);
					arti[i] = (childrens>1);
				}
				

			}
			
                        Collections.sort(answer);
                        System.out.println(answer.size()+" critical links");
                        for(Articulation x:answer)
                            System.out.println(x.toString());
                        System.out.println();
                        in.readLine();

		}
		in.close();
		System.exit(0);
	}
} 	