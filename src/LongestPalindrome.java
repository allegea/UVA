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

public class LongestPalindrome {

	static Integer[][] dp;
	
	static int DP(char[] word, int l, int r)
	{
		if(l == r)return dp[l][r] = 1;
		if(l + 1 == r)
			if(word[l] == word[r])return dp[l][r] = 2;
			else return dp[l][r] = 1;
			
		if(dp[l][r] != null)return dp[l][r];
		
		int max = 0;
		if(word[l] == word[r]) max = 2 + DP(word, l + 1, r - 1);
		else max = Math.max(DP(word, l + 1, r), DP(word, l, r - 1));
		
		return dp[l][r] = max;
	}
	public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	int n = Integer.parseInt(in.readLine());
	while(n-->0)
	{
		char[] word = in.readLine().toCharArray();
		int m = word.length;
                if(m == 0){System.out.println(m); continue;}
		dp = new Integer[m][m];
		//for(int i=0;i<m;i++)Arrays.fill(dp[i], -1);
		System.out.println(DP(word, 0, m-1));
	}
	
	in.close();
	System.exit(0);
	}

}
