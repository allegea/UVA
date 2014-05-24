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

public class NetworkConnections{

	static int[] id;
	static int[] size;
	static int N;
	static int sets;
	static void init(int n)
	{
		N = n;
		sets = N;
		id = new int[N+1];
		size = new int[N+1];
		for(int i=0;i<=N;i++)
		{
			size[i] = 1;
			id[i] = i;
		}
	}
	
	static int root(int i)
	{
		return id[i] == i? i : (id[i] = root(id[i]));
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
		 int tests = Integer.parseInt(in.readLine());
                 in.readLine();
		 boolean first = true;
		 while(tests-->0)
		 {
			//in.readLine();
			int n = Integer.parseInt(in.readLine());
			init(n);
			if(!first)System.out.println();
			first = false;
			
			int succ = 0;
			int failed = 0;
                        String line = "";
			while( (line = in.readLine()) != null && line.length() > 0)
			{
				String[] read = line.split("[ ]+");
				int u = Integer.parseInt(read[1]);
				int v = Integer.parseInt(read[2]);
				if(read[0].charAt(0) == 'c')
				union(u, v);
				else if(isSame(u, v)) succ++;
				else failed++;
			}
			System.out.println(succ+","+failed);

		 }
		 
		 in.close();
		 System.exit(0);
		}

}
