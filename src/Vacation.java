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

public class Vacation{

	static char[] a, b;
	static int n, m;
	static int[][] dp;
	static int LCS(int i, int j)
	{
		if(i == n || j == m)return dp[i][j] = 0;
		if(dp[i][j] != -1)return dp[i][j];
		int max = 0;
		if(a[i] == b[j])max = 1 + LCS(i + 1, j + 1);
		else max = Math.max(LCS(i + 1, j), LCS(i , j + 1));
		return dp[i][j] = max;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = 1;
		while(true)
		{
			a = in.readLine().toCharArray();
			if(a.length > 0 && a[0] == '#')break;
			b = in.readLine().toCharArray();
			n = a.length;
			m = b.length;
			dp = new int[n + 1][m + 1];
			for(int i = 0; i<=n;i++)Arrays.fill(dp[i], -1);
			System.out.println("Case #" + cases + ": you can visit at most " + LCS(0, 0) + " cities.");
			cases++;
		}
		in.close();
		System.exit(0);
	}
}