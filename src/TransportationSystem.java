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

/**
 *
 * @author Alejandro E. Garces
 */

public class TransportationSystem{

	public static class Edge implements Comparable{
	
		int u;
		int v;
		double w;
		Edge(int uu, int vv, double ww)
		{
			u = uu;
			v = vv;
			w = ww;
		}
                
		@Override
		public int compareTo(Object o){
                    if(this.w < ((Edge)o).w)return -1;
                    else if(this.w > ((Edge)o).w)return 1;
                    else return 0;
		}
                
                @Override
                public String toString()
                {
                    return w+" - "+u+" - "+v;
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
		 int tests = Integer.parseInt(in.readLine());
		 int curr = 1;
		 Point2D.Double[] points;
		 while(tests-->0)
		 {
			String[] read = in.readLine().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int r = Integer.parseInt(read[1]);
			edges = new ArrayList<Edge>();
			points = new Point2D.Double[n];

			init(n);
			for(int i=0;i<n;i++)
			{	read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				points[i] = new Point2D.Double(u, v);
			}
			
			for(int i=0;i<n;i++)
			{
				for(int j=i+1;j<n;j++)
				edges.add(new Edge(i, j, points[i].distance(points[j])));
			}
			
			int countStates = 1;
			double roads = 0;
			double railroads = 0;
			Collections.sort(edges);
                       // for(Edge x:edges)
                            //System.out.println(x.toString());
			for(Edge x:edges)
			{
				if(!isSame(x.u, x.v))
				{
					if(x.w <= r)roads+=x.w;
					else{
						countStates++;
						railroads+=x.w;
					}
					union(x.u, x.v);
					if(sets<=1)break;
				}
				
			}

			System.out.println("Case #"+(curr++)+": "+countStates+" "+Math.round(roads)+" "+Math.round(railroads));
			
			
		 }
		 
		 in.close();
		 System.exit(0);
		}

}
