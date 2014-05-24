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

public class TheTwinTowers {
        static int[][] dp;
	static int[] a, b;
	static int n, m;
	static int LCS(int i, int j)
	{
		if(j == m)return dp[i][j] = 0;
		if(i == n)return dp[i][j] = 0;
		if(dp[i][j] != -1)return dp[i][j];
                int max = 0;
		if(a[i] == b[j])max = 1 + LCS(i + 1, j + 1);
		else max =  Math.max(LCS(i + 1, j), LCS(i, j + 1));
                return dp[i][j] = max;
	
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cases = 1;
		while(true)
		{
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
                        if(n == 0 && m == 0)break;
			a = new int[n];
			b = new int[m];
                        dp = new int[n+1][m+1];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++)
                        {
                            a[i] = Integer.parseInt(st.nextToken());
                            Arrays.fill(dp[i], -1);
                        }
                        Arrays.fill(dp[n], -1);
                        st = new StringTokenizer(in.readLine());
			for(int i = 0; i < m; i++)
				b[i] = Integer.parseInt(st.nextToken());
			
                        
			System.out.println("Twin Towers #" + cases);
			System.out.println("Number of Tiles : " + LCS(0, 0));
			System.out.println();
                        cases++;
		}
		in.close();
		System.exit(0);
	}

}