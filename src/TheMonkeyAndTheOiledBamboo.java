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
public class  TheMonkeyAndTheOiledBamboo{
	public static final int Upper = 100000000;
	public static final int Lower = 0;
	
	public static boolean simulate(int k, int[] heights, int n)
	{
		boolean canGo = true;
		int prev = 0;
		for(int i = 0; i < n && canGo; i++)
		{
			if(heights[i] > k + prev)canGo = false;
			else if(heights[i] == k + prev)k--;
			
			prev = heights[i];
		}
		return canGo;
	}
	
	public static int BS(int n, int[] heights)
	{
		int L = Lower;
		int R = Upper;
		int answer = 0;
		while(L < R)
		{
			int M = (L + R)/2;
			if(simulate(M, heights, n))
				answer = R = M;
			else L = M + 1;
		
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		int c = 0;
		StringTokenizer st;
		int[] heights;
		while(c++ < cases)
		{
			int n = Integer.parseInt(in.readLine());
			heights = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++)
				heights[i] = Integer.parseInt(st.nextToken());
			
			System.out.println("Case " + c + ": "+ BS(n, heights) );
		}
		in.close();
		System.exit(0);
	
	}

}