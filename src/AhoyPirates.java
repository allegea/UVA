/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class AhoyPirates{
	static int[] RSQ;
	static int[] values;
	static int N, M;
	static void initST()
	{
		N = (int)(Math.log((double)M)/Math.log(2.0))+2;
		N = 1<<N;
		RSQ = new int[N];
               // System.out.println(N+" ----");
		buildST(1, 0, M-1);
	}
	
	static void buildST(int root, int L, int R)
	{
		if(L == R) RSQ[root] = values[L];
		else{
		int pL = root<<1;
		int pR = pL+1;
		int mid = (L+R)>>1;
		buildST(pL, L, mid);
		buildST(pR, mid+1, R);
		RSQ[root] = RSQ[pL] + RSQ[pR];
		}	
	}

	static int QR(int root, int L, int R, int i, int j)
	{
		if(i > R || j < L) return 0;
		if(L >= i && R <= j)return RSQ[root];
		int pL = root<<1;
		int pR = pL+1;
		int mid = (L+R)>>1;
		return QR(pL, L, mid, i, j)+QR(pR, mid+1, R, i, j);
	}

	static int QR(int i, int j)
	{
		return QR(1, 0, M-1, i, j);	
	}
	
	static int update(int root, int L, int R, int pos, int value)
	{
                //System.out.println(root+" - "+L+" - "+R);
		if(pos > R || pos < L) return RSQ[root];
		if(pos == L && R == pos){
                    //values[pos] = value;
                    return RSQ[root] = values[pos] = value;
                }
		int pL = root<<1;
		int pR = pL+1;
		int mid = (L+R)>>1;
		pL = update(pL, L, mid, pos, value);
		pR = update(pR, mid+1, R, pos, value);
		return RSQ[root] = pL+pR;
	}

	static void update(int pos, int value)
	{
		update(1, 0, M-1, pos, value);	
	}
	
	static void updateToBuccaneer(int u, int v)
	{
		for(int i=u;i<=v;i++)
			update(i, 1);
	}
	
	static void updateToBarbary(int u, int v)
	{
		for(int i=u;i<=v;i++)
			update(i, 0);
	}
	
	static void updateSwap(int u, int v)
	{
		for(int i=u;i<=v;i++)
			update(i, 1-values[i]);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder output = new StringBuilder();
		int cases = Integer.parseInt(in.readLine());
		int current = 1;
		StringTokenizer r;
		String[] inputs;
		int[] times;
		while(cases-->0)
		{
			int pairs = Integer.parseInt(in.readLine());
			inputs = new String[pairs];
			times = new int[pairs];
			M = 0;
			for(int i=0;i<pairs;i++)
			{
				times[i] = Integer.parseInt(in.readLine());
				inputs[i] = in.readLine();
				M+=times[i]*inputs[i].length();
			}
			values = new int[M];
			int k = 0;
			int queries = 1;
			for(int i=0;i<pairs;i++)
			{	char[] land = inputs[i].toCharArray();
				for(int j=0;j<times[i];j++)
					for(int h=0;h<land.length;h++)
						values[k++] = land[h]-'0';
			}
                        initST();
			//System.out.println(Arrays.toString(values)+" **");
			k = Integer.parseInt(in.readLine());
                        output.append("Case ").append(current++).append(":").append("\n");
			//System.out.println("Case "+(current++)+":");
			for(int i=0;i<k;i++)
			{
				r = new StringTokenizer(in.readLine());
				char comm = r.nextToken().charAt(0);
				int u = Integer.parseInt(r.nextToken());
				int v = Integer.parseInt(r.nextToken());
				if(comm == 'F')
				{
					updateToBuccaneer(u, v);
				}else if(comm == 'E'){
					updateToBarbary(u, v);
				}else if(comm == 'I'){
					updateSwap(u, v);
				}else if(comm == 'S'){
				
                                        output.append("Q").append(queries).append(": ").append(QR(u,v)).append("\n");
					//System.out.println("Q"+queries+": "+QR(u,v));
					queries++;
				}
				
			}
			
		}
                System.out.print(output);
		in.close();
		System.exit(0);
	
	}

}