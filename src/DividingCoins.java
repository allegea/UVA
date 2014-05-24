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
public class DividingCoins{
    

    public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(in.readLine());
                        int max = 0;
			String[] read = in.readLine().split("[ ]+");
			int[] values = new int[n];
			for(int i=0;i<n;i++)
			  max+=(values[i] = Integer.parseInt(read[i]));
                        
                        int[][] dp = new int[n+1][max+1];
                        for(int i=1;i<=n;i++)
                            for(int j=1;j<=max;j++)
                            {
                                dp[i][j] = dp[i-1][j];
                                if(j >= values[i-1])
                                    dp[i][j] = Math.max(dp[i-1][j], values[i-1]+dp[i-1][j-values[i-1]]);
                            }
                        int answer = Integer.MAX_VALUE;
                        
                        for(int i=1;i<=n;i++)
                            System.out.println(Arrays.toString(dp[i]));
                        for(int i=0;i<=max;i++)
                            answer = Math.min(answer, Math.abs((Math.abs(max-dp[n][i])-dp[n][i])));
                        System.out.println(answer);
                                    
                        
		
		}
                in.close();
                System.exit(0);
         }
    

}