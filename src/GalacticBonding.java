/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */

public class GalacticBonding{
	static int[] ids;
	static int[] sizes;
	static int N;
	static int sets;
	public static void init(int n)
	{
		N = n;
		sets = n;
		ids = new int[N];
		sizes = new int[N];
		for(int i=0;i<N;i++)
		{
			ids[i] = i;
			sizes[i] = 1;
		}
	}
	
	public static int root(int i)
	{
		return ids[i] == i?i: (ids[i] = root(ids[i]));
	}

	public boolean inSame(int i, int j)
	{
		return root(i) == root(j);
	}
	
	
	public static void union(int i, int j)
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

	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner in = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(in.readLine());
		Point2D.Double[] points;
		int cases = 1;
		while(tests-->0)
		{
			String[] read = in.readLine().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			double dist = Double.parseDouble(read[1]);
			points = new Point2D.Double[n];
			
			init(n);

			for(int i=0;i<n;i++)
			{
				read = in.readLine().split("[ ]+");
				double u = Double.parseDouble(read[0]);
				double v = Double.parseDouble(read[1]);
				points[i] = new Point2D.Double(u, v);
			}
			
			for(int i=0;i<n;i++)
				for(int j=i+1;j<n;j++)
					if(Double.compare(dist, points[i].distance(points[j])) > 0)
						union(i, j);
			

			System.out.println("Case "+(cases++)+": "+sets);
			
		}
		
		in.close();
		System.exit(0);
	}
	
}