/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Alejandro E. Garces
 */

public class MoneyMatters{
	static int[] ids;
	static int[] sizes;
	static int N;
	static HashMap<Integer, Integer> debts;
	public static void init(int n)
	{
		N = n;
		ids = new int[N];
		sizes = new int[N];
		debts = new HashMap<Integer, Integer>();
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
		int uu = debts.get(u);
		int vv = debts.get(v);
		debts.remove(u);
		debts.remove(v);
			
		if(sizes[u] > sizes[v])
		{
			sizes[u]+=sizes[v];
			ids[v] = u;
			uu+=vv;
			debts.put(u, uu);
			
		}else{
			sizes[v]+=sizes[u];
			ids[u] = v;
			vv+=uu;
			debts.put(v, vv);
		}
		
	}

	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner in = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(in.readLine());
		while(tests-->0)
		{
			String[] read = in.readLine().split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			init(n);

			for(int i=0;i<n;i++)
			{
				int debt = Integer.parseInt(in.readLine());
				debts.put(i, debt);
			}
			
			for(int i=0;i<m;i++)
			{
				read = in.readLine().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				union(u,v);
			}
			
			String out = "POSSIBLE";
                        Set<Integer> keys = debts.keySet();
                        //System.out.println(debts);
                        
			for(int x:keys)
				if(debts.get(x) != 0)
				{
					out = "IM"+out;
					break;
				}
			System.out.println(out);
			
		}
		
		in.close();
		System.exit(0);
	}
	
}