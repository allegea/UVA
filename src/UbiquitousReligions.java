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
public class UbiquitousReligions{

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
		boolean first = true;
                int test = 1;
		while( true)
		{
			String[] read = in.readLine().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			
			if(n == 0 && m == 0)break;
			init(n+1);
			for(int i=0;i<m;i++)
			{
				read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				union(u, v);
			}
			
			System.out.println("Case "+(test++)+": "+(sets+1));
			
		}
		
		in.close();
		System.exit(0);
	}
}