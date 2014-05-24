/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Alejandro E. Garces
 */
public class Nature{

	static int[] ids;
	static int[] sizes;
	static int sets;
	static int N;
        static int maxSize;
	
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
                        maxSize = Math.max(maxSize, sizes[u]);
		}else{
			sizes[v] += sizes[u];
			ids[u] = v;
                        maxSize = Math.max(maxSize, sizes[v]);
		}
		sets--;
	}
	
	public static void main(String[] args) throws IOException{
	
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                Scanner in = new Scanner((System.in));
		boolean first = true;
		HashMap<String, Integer> mapNames;
		while( true)
		{
			
			int n = Integer.parseInt(in.next());
			int m = Integer.parseInt(in.next());
			
			if(n == 0 && m == 0)break;
                        //if(!first)System.out.println();
                        first = false;
                        maxSize = 1;
			init(n);
			int currPos = 0;
			mapNames = new HashMap<String, Integer>();
			for(int i=0;i<n;i++)
				mapNames.put(in.next(), currPos++);
			
			for(int i=0;i<m;i++)
			{
				//read = in.readLine().split("[ ]+");
				int u = mapNames.get(in.next());
				int v = mapNames.get(in.next());
				union(u, v);
			}
			
			
			
			System.out.println(maxSize);
			//in.readLine();
			
		}
		
		in.close();
		System.exit(0);
	}
}