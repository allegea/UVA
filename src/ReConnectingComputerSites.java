/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Alejandro E. Garces
 */

public class ReConnectingComputerSites{
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
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		String line = "";
		long oriCost;
		String[] read; 
		ArrayList<Edge> edges;
                boolean first = true;
		while((line = in.readLine()) != null)
		{
                    
                        if(!first)System.out.println();
                        first = false;
			int n = Integer.parseInt(line);
			init(n+1);
			oriCost = 0;
			for(int i=0;i<n-1;i++)
			{
				read = in.readLine().split("[ ]+");
				//int u = Integer.parseInt(read[0]);
				//int v = Integer.parseInt(read[1]);
				oriCost += Integer.parseInt(read[2]);
			}
			
			int nn = Integer.parseInt(in.readLine());
			edges = new ArrayList<Edge>();
			for(int i=0;i<nn;i++)
			{
				read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				int w = Integer.parseInt(read[2]);
				edges.add(new Edge(u, v, w));
			}
			
			int m = Integer.parseInt(in.readLine());
			for(int i=0;i<m;i++)
			{
				read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				int w = Integer.parseInt(read[2]);
				edges.add(new Edge(u, v, w));
			}
			Collections.sort(edges);
			int sum = 0;
			for(Edge x:edges)
			{
				if(!inSame(x.u, x.v))
				{
					sum+=x.w;
					union(x.u, x.v);
					if(sets<=1)break;
				}
			}

			System.out.println(oriCost+"\n"+sum);
			in.readLine();
		
		}
		in.close();
		System.exit(0);
		
	}
}
