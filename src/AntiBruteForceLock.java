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

public class AntiBruteForceLock{
	static int N;
	static int[] ids;
	static int[] sizes;
	static int sets;
	
	static int count(String x, String y)
	{
		int count = 0;
		for(int i=0;i<x.length();i++)
		{
			int u = x.charAt(i)-'0';
			int v = y.charAt(i)-'0';
			//int w = Math.min(Math.abs(u-v), Math.min(u+(10-v), 10-u+v));//  s += min(abs(ai-bi), min(ai+(10-bi), 10-ai+bi));
                        int w = Math.abs(u-v);
			if(w>5)w=10-w;
			count+=w;
		}
                //System.out.println(x+" - "+y+" - "+count);
                return count;
	}

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
                @Override
                public String toString(){
                    return u+" - "+v+" - "+w;
                }
	}
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		String line = "";
		String[] read; 
		ArrayList<Edge> edges;
		int tests = Integer.parseInt(in.readLine().trim());
		int curr = 1;
		while(tests-->0)
		{
			read = in.readLine().trim().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			init(n+1);
                        int answer = 10000;
			edges = new ArrayList<Edge>();
			for(int i=0;i<n;i++)
			{
				answer = Math.min(count("0000", read[i+1]), answer);
                                //edges.add(new Edge(0, i+1, w));
				for(int j=i+1;j<n;j++)
				{
					int w = count(read[j+1], read[i+1]);
					edges.add(new Edge(j+1, i+1, w));
				}
			}
			
			Collections.sort(edges);
			
                      //  System.out.println(edges);
			for(Edge x:edges)
			{
				if(!inSame(x.u, x.v))
				{
					answer+=x.w;
					union(x.u, x.v);
					if(sets<=1)break;
				}
			}
			System.out.println(answer);
		
		}
		in.close();
		System.exit(0);
		
	}
}
