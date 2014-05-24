/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 *
 * @author Alejandro E. Garces
 */

public class HeavyCycleEdges{

	public static class Edge implements Comparable{
	
		int u;
		int v;
		int w;
		Edge(int uu, int vv, int ww)
		{
			u = uu;
			v = vv;
			w = ww;
		}
		
		@Override
		public int compareTo(Object o){
			return this.w - ((Edge)o).w;
		}
	}
	
	static int[] id;
	static int[] size;
	static int N;
	static int sets;
	static void init(int n)
	{
		N = n;
		sets = N;
		id = new int[N];
		size = new int[N];
		for(int i=0;i<N;i++)
		{
			size[i] = 1;
			id[i] = i;
		}
	}
	
	static int root(int i)
	{
		return id[i] == i? i :(id[i] = root(id[i]));
	}
	
	static boolean isSame(int i, int j)
	{
		return root(i) == root(j);
	}
	
	static void union(int i, int j)
	{
		int u = root(i);
		int v = root(j);
		if(u == v)return;
		
		if(size[u] > size[v])
		{
			id[v] = u;
			size[u] += size[v];
		}else{
			id[u] = v;
			size[v] += size[u];
		}
		sets--;
	}
	
	 public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 ArrayList<Edge> edges;
		 ArrayList<Integer> answer;
                 
                 Point2D.Float x;
                 x.d
		 while(true)
		 {
			String[] read = in.readLine().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			if(n == 0 && m == 0)break;
			edges = new ArrayList<Edge>();
			answer = new ArrayList<Integer>();
			
			init(n);
			for(int i=0;i<m;i++)
			{	read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				int w = Integer.parseInt(read[2]);
				edges.add(new Edge(u, v, w));
			}
			
			Collections.sort(edges);
			for(Edge x:edges)
			{
				if(isSame(x.u, x.v))answer.add(x.w);
				else union(x.u, x.v);
			}
			
			if(answer.isEmpty())System.out.println("forest");
			else {
				String toPrint = "";
				for(int num:answer)
					toPrint+=num+" ";
				System.out.println(toPrint.trim());
			}
			
			
		 }
		 
		 in.close();
		 System.exit(0);
		}

}
