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

public class Luggage {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		int[][] dp;
		int[] w;
		while(t-->0)
		{
			String[] read = in.readLine().split("[ ]+");
			int n = read.length;
			w = new int[n];
			int sum = 0;
			
			for(int i=0;i<n;i++)
			sum+= (w[i] = Integer.parseInt(read[i]));
			
			dp = new int[n+1][sum+1];
			
			for(int i=1;i<=n;i++)
				for(int j=1;j<=sum;j++)
				{
					dp[i][j] = dp[i-1][j];
					if(j >= w[i-1])
					dp[i][j] = Math.max(dp[i-1][j], w[i-1]+dp[i-1][j-w[i-1]]);
				}
				
			int answer = Integer.MAX_VALUE;
			for(int i=1;i<=sum;i++)
			answer = Math.min(answer, Math.abs(Math.abs(sum-dp[n][i])-dp[n][i]));
			
			System.out.println(answer==0?"YES":"NO");
			
		}
		in.close();
		System.exit(0);
	}
}