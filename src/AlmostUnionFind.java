/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

class AlmostUnionFind {

	static class AlmostUF{
	
		int[] parents;
		int[] ids;
		int[] sizes;
		int[] sums;
		int n;
		AlmostUF(int m)
		{
			n = m;
			parents = new int[n+1];
			ids = new int[n+1];
			sizes = new int[n+1];
			sums = new int[n+1];
			for(int i=0;i<=n;i++)
			{
				parents[i] = i;
				ids[i] = i;
				sizes[i] = 1;
				sums[i] = i;
			}
		}
		
		int root(int p)
		{
			p = ids[p];
			while(parents[p] != p)
				p = parents[p];
			return p;
		}
		void query(int p)
		{
			int r = root(p);
			System.out.println(sizes[r] +" "+ sums[r]);
		}
		
		void move(int p, int q)
		{
			int rP = root(p);
			int rQ = root(q);
			if(rP == rQ)return;
			sums[rP]-=p;
			sizes[rP]--;
			sums[rQ]+=p;
			sizes[rQ]++;
			ids[p] = q;
		}
		
		void union(int p, int q)
		{
			int rP = root(p);
			int rQ = root(q);
			if(rP == rQ)return;
			
			sizes[rP]+=sizes[rQ];
			sums[rP]+=sums[rQ];
			parents[ids[q]] = parents[ids[p]];
		}
                
                void print(){
                    
                    System.out.println(Arrays.toString(parents));
                    System.out.println(Arrays.toString(ids));
                    System.out.println(Arrays.toString(sizes));
                    System.out.println(Arrays.toString(sums));
                }
	}
	public static void main(String[] args) throws IOException{
	fs
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringTokenizer r;
		while((line = in.readLine()) != null && line.length() > 0)
		{
			r = new StringTokenizer(line);
			int n = Integer.parseInt(r.nextToken());
			int m = Integer.parseInt(r.nextToken());
			AlmostUF UF = new AlmostUF(n);
			for(int i=0;i<m;i++)
			{
                                line = in.readLine();
				r = new StringTokenizer(line);
                                //System.out.println(line+" **");
                                int x = Integer.parseInt(r.nextToken());
                                int u = Integer.parseInt(r.nextToken());
                                if(x == 1)
                                {
                                     int v = Integer.parseInt(r.nextToken());
                                     UF.union(u, v);
                                }else if(x == 2)
                                {
                                     int v = Integer.parseInt(r.nextToken());
                                     UF.move(u, v);
                                }else{
                                    UF.query(u);
                                }
                                //UF.print();
				
			}
			
		}
		in.close();
		System.exit(0);
	
	}

}