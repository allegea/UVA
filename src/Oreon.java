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

/**
 *
 * @author Alejandro E. Garces
 */

public class Oreon{
	static int N;
	static int[] ids;
	static int[] sizes;
	static int sets;
	
	static int root(int i)
	{
		return ids[i] == i?i:(ids[i] = (root(ids[i])));
	}
	
	static boolean inSame(int i, int j)
	{
		return root(i) == root(j);
	}
	
	static void init(int n)
	{
		N = n;
		sets = n;
		sizes = new int[n+1];
		ids = new int[n+1];
		for(int i=0;i<=n;i++)
		{
			ids[i] = i;
			sizes[i] = 1;
		}
	}
	
	static void union(int i, int j)
	{
		int u = root(i);
		int v = root(j);
		if(u == v)return;
		if(sizes[u] > sizes[v])
		{
			sizes[u]+=sizes[v];
			ids[v] = u;
		}else{
			sizes[v]+=sizes[u];
			ids[u] = v;
		}
		sets--;
	}
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
			return this.w-((Edge)o).w;
		}
	}
	
	public static class EdgeOutPut implements Comparable{
	
		int u;
		int v;
		int w;
		EdgeOutPut(int uu, int vv, int ww)
		{
			u = Math.min(uu, vv);
			v = Math.max(uu, vv);
			w = ww;
		}
		@Override
		public int compareTo(Object o){
			if(this.w != ((EdgeOutPut)o).w)return this.w-((EdgeOutPut)o).w;
			else if(this.u != ((EdgeOutPut)o).u)return this.u-((EdgeOutPut)o).u;
			else return this.v-((EdgeOutPut)o).v;
			
		}
		@Override
		public String toString(){
			return (char)(u+65)+"-"+(char)(v+65)+" "+w;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		
		String[] read; 
		ArrayList<Edge> edges;
		ArrayList<EdgeOutPut> answer;
		int tests = Integer.parseInt(in.readLine().trim());
		int curr = 1;
		while(tests-->0)
		{
			int n = Integer.parseInt(in.readLine().trim());
			init(n);
			edges = new ArrayList<Edge>();
			answer = new ArrayList<EdgeOutPut>();
			for(int i=0;i<n;i++)
			{
				read = in.readLine().trim().split("[, ]+");
                                //System.out.println(Arrays.toString(read));
				for(int j=0;j<read.length;j++)
				{
					int w = Integer.parseInt(read[j]);
					if(w > 0)
					edges.add(new Edge(i, j, w));
				}
				
			}
			
			Collections.sort(edges);
			for(Edge x:edges)
			{
				if(!inSame(x.u, x.v))
				{
					answer.add(new EdgeOutPut(x.u, x.v, x.w));
					union(x.u, x.v);
					if(sets<=1)break;
				}
			}
			Collections.sort(answer);
			System.out.println("Case "+(curr++)+":");
			for(EdgeOutPut x:answer)
				System.out.println(x.toString());
			
		
		}
		in.close();
		System.exit(0);
		
	}
}
