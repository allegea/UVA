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
public class MakePalindrome
{
	public static final int INF = Integer.MAX_VALUE/2;
	public static int[][] dp;
	public static char[] word;
	public static int N = 0;
	public static int solve(int i, int j)
	{
               // System.out.println(i + " - " + j);
		if(i > j)return  0;
		if(dp[i][j] != INF)return dp[i][j];
		
		int min = INF;
		if(word[i] == word[j])
			min = solve(i + 1, j - 1);
		else{
			min = Math.min(solve(i + 1, j) + 1, solve(i, j - 1) + 1);
		}
		return dp[i][j] = min;
	
	}
	public static String answer(int i, int j)
	{
                 //System.out.println(i + " - " + j + " - "+dp[i][j]);
		if(i > j)return "";
                if(i == j)return "" + word[i];
		if(word[i] == word[j])
			return word[i] + answer(i + 1, j - 1) + word[j];
		else {
			if(dp[i + 1][j] < dp[i][j - 1])
			return word[i] + answer(i + 1, j) + word[i];
			else return word[j] + answer(i, j - 1) + word[j];
		}
	
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line = in.readLine()) != null)
		{
			word = line.toCharArray();
			N = line.length();
			dp = new int[N + 1][N + 1];
			for(int i = 0; i <= N; i++)
				Arrays.fill(dp[i], INF);
			System.out.println(solve(0, N - 1) + " " + answer(0, N - 1));
		}
		in.close();
		System.exit(0);
	
	}

}