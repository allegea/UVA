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

public class StringToPalindrome{

	static char[] word;
	static int n;
	static int[][] dp;
	static final int INF = Integer.MAX_VALUE/2;
	static int solve(int i, int j)
	{
		if(i >= j) return dp[i][j] = 0;
		if(dp[i][j] != INF)return dp[i][j];
		int min = INF;
		if(word[i] == word[j])min = solve(i + 1, j - 1);
		else {
			min = Math.min( 1 + solve(i + 1, j), 1 + solve(i, j - 1));
			min = Math.min( min, 1 + solve(i + 1, j - 1));
		}
                //System.out.println(i + " - " + j + " - "+ min);
		return dp[i][j] = min;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner in = new Scanner(System.in);
		int m = Integer.parseInt(in.readLine());
		StringBuilder output = new StringBuilder();
		for(int i = 1; i <= m; i++)
		{
			word = in.readLine().toCharArray();
                        //System.out.println("** "+Arrays.toString(word));
			n = word.length;
			dp = new int[n + 1][n + 1];
			for(int j = 0; j <= n; j++)Arrays.fill(dp[j], INF);
			output.append("Case ").append(i).append(": ").append(solve(0, n - 1)).append("\n");
		}
		System.out.print(output);
		in.close();
		System.exit(0);
		
	}
}