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

public class LongestCommonSubsequence {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while(( line = in.readLine()) != null && line.length() > 0)
		{
			char[] a = line.toCharArray();
			char[] b = in.readLine().toCharArray();
			int n = a.length;
			int m = b.length;
			int[][] dp = new int[n + 1][m + 1];
			for(int i = 1; i <= n; i++)
				for(int j = 1; j <= m; j++)
				{
					if(a[i - 1] == b[j - 1])dp[i][j] = 1 + dp[i - 1][j - 1];
					else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
				
			System.out.println(dp[n][m]);
		}
		
		in.close();
		System.exit(0);
	}

}