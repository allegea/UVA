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

public class SuperSale{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		int[] prices;
		int[] weights;
		int[] pWe;
		int[][][] dp;
		String[] read;
		while(t-->0)
		{
			int n = Integer.parseInt(in.readLine());
			prices = new int[n+1];
			weights = new int[n+1];
			for(int i=0;i<n;i++)
			{
				read = in.readLine().split("[ ]+");
				prices[i+1] = Integer.parseInt(read[0]);
				weights[i+1] = Integer.parseInt(read[1]);
			}
			
			int m = Integer.parseInt(in.readLine());
			pWe = new int[m];
			dp = new int[n+1][31][m];
			for(int i=0;i<m;i++)
			pWe[i] = Integer.parseInt(in.readLine());
			
			for(int i=1;i<=n;i++)
				for(int j=0;j<m;j++)
					for(int k=0;k<=pWe[j];k++)
					{
                                            if(weights[i] > k)
                                            {
                                                dp[i][k][j] = dp[i-1][k][j];
                                            }else
                                            {
                                                dp[i][k][j] = Math.max(dp[i-1][k][j], dp[i-1][k-weights[i]][j]+prices[i]);
                                            }
					}
			int answer = 0;
                        for(int i=0;i<=n;i++)
                            System.out.println(Arrays.deepToString(dp[i]));
                        
			for(int i=0;i<m;i++)
				answer+=dp[n][pWe[i]][i];
			System.out.println(answer);
		}
		
		in.close();
		System.exit(0);
		
	}
}