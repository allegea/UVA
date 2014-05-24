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

public class FlightPlanner{

	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		boolean[][] allowed;
		int[][] dp;
		int[][] values;
		int cases = in.nextInt();
		int x = 0;
		int n = 10;
		int m = 0;
		while(cases-->0)
		{
			
			x = in.nextInt();
			m = x/100;
			dp = new int[n][m+1];
			values = new int[n][m];
			allowed = new boolean[n][m+1];
			
			for(int i=0;i<n;i++)
			{	Arrays.fill(dp[i], INF);
				for(int j=0;j<m;j++)
					values[i][j] = in.nextInt();
			}		
					
			allowed[n-2][1] = true;
			dp[n-2][1] = 60-values[n-1][0];
			
			for(int j=1;j<m;j++)
				for(int i=n-2;i>=0;i--)
				{
					if(!allowed[i][j])continue;
                                        
					int value = dp[i][j]-values[i][j];
                                       // System.out.println(i+" - "+j+" - "+value);
					if(i-1>=0)
					{
						dp[i-1][j+1]=Math.min(dp[i-1][j+1], value+60);
						allowed[i-1][j+1] = true;
					}
					
					dp[i][j+1]=Math.min(dp[i][j+1], value+30);
					allowed[i][j+1] = true;
					
					dp[i+1][j+1]=Math.min(dp[i+1][j+1], value+20);
					allowed[i+1][j+1] = true;
					
				}
                        /*for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(dp[i]));*/
			System.out.println(dp[n-1][m]);
                        System.out.println();
		}
		in.close();
		System.exit(0);
	}
}