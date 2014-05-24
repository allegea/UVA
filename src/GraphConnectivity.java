/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */

public class GraphConnectivity{

	static int[] ids;
	static int[] sizes;
	static int sets;
	static int N;
	
	public static void init(int n){
		N = n;
		sets = n;
                ids = new int[n];
                sizes = new int[n];
		for(int i=0;i<n;i++)
		{
			ids[i] = i;
			sizes[i] = 1;
		}
	}
	
	public static int root(int i)
	{
		return ids[i] == i?i:(ids[i] = root(ids[i]));
	}
	
	public static void union(int i, int j)
	{
		int u = root(i);
		int v = root(j);
		
		if(u == v)return;
		
		if(sizes[u] > sizes[v])
		{
			sizes[u] += sizes[v];
			ids[v] = u;
		}else{
			sizes[v] += sizes[u];
			ids[u] = v;
		}
		sets--;
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(in.readLine());
		boolean first = true;
		in.readLine();
		String line = "";
		while( (line = in.readLine()) != null && line.length() > 0)
		{
			if(!first) System.out.println();
			first = false;
			int n = line.charAt(0)-'A'+1;
			init(n);
			
			while( (line = in.readLine()) != null && line.length() > 0)
			{
				int u = line.charAt(0) - 'A';
				int v = line.charAt(1) - 'A';
				union(u, v);
			}
			
			System.out.println(sets);
		}
		
		in.close();
		System.exit(0);
	}
}