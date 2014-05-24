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

public class CoinChagen{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] coins = {0, 1, 5, 10, 25, 50};
		int n = 50;
		int max = 30;
		int[][] dp = new int[n+1][max+1];
		for(int i=1;i<coins.length;i++)
			dp[coins[i]][0] = 1;
		
                 
                //for(int k=1;k<coins.length;k++) 
		for(int i=1;i<coins.length;i++)
			for(int j=1;j<=max;j++)
			{
				dp[i][j] += dp[i][j-1];
				if(i >= coins[k])
				dp[i][j] += dp[i-coins[k]][j];
			}
              for(int i=0;i<=n;i++)
                    System.out.println(Arrays.toString(dp[i]));
                
		String line = "";
		while((line = in.readLine()) != null && line.length() > 0)
		{
			int x = Integer.parseInt(line);
			System.out.println(dp[n][x]);
		}
		in.close();
		System.exit(0);
	}
}