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

public class CuttingSticks{

	static int min = Integer.MAX_VALUE;
	static int[] numbers;
	static int[][] dp;
	static int DP(int i, int j)
	{
                // System.out.println(i+" - "+j);
                if(i+1 == j)return 0;
                if(dp[i][j] != -1)return dp[i][j];
                int aux = Integer.MAX_VALUE;
		for(int u=i+1;u<j;u++)
			aux = Math.min(aux, DP(i, u)+DP(u, j) + numbers[j]-numbers[i]);
                //System.out.println(i+" - "+j+" - "+aux);
                return dp[i][j] = aux;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			min = Integer.MAX_VALUE;
			int m = Integer.parseInt(in.readLine());
                        numbers = new int[m+2];
                        numbers[0] = 0;
                        numbers[m+1] = n;
                        
			read = new StringTokenizer(in.readLine());
			for(int i=1;i<=m;i++) numbers[i] = Integer.parseInt(read.nextToken());
                        
                        dp = new int[60][60];
                        for(int i=0;i<60;i++)
                            Arrays.fill(dp[i], -1);
			
			System.out.println("The minimum cutting is "+DP(0, m+1)+".");
		}
		in.close();
		System.exit(0);
	}
}