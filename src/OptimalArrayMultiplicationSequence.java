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

public class OptimalArrayMultiplicationSequence {

static String answer(int[][] paths, int i, int j)  
{  
    if(i == j) return "A"+i;  
    return "("+ answer(paths, i, paths[i][j]) + " x "+answer(paths, paths[i][j]+1, j)+")";
        /*System.out.print("(");  
        print_ans(paths, i, paths[i][j]);  
        System.out.print(" x ");  
        print_ans(paths, paths[i][j]+1, j);  
        System.out.print(")");  */
    
}  
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		int[][] dp;
                int[][] dp2;
		int[][] matriz;
                int t = 1;
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			matriz = new int[n+1][2];
			dp = new int[n+1][n+1];
                        dp2 = new int[n+1][n+1];
			for(int i=1;i<=n;i++)
			{
				read = new StringTokenizer(in.readLine());
				matriz[i][0] = Integer.parseInt(read.nextToken());
				matriz[i][1] = Integer.parseInt(read.nextToken());
			}
			
			for(int s = 2;s<=n;s++)
				for(int i=1; i<=n-s+1;i++)
					{
						int j = i+s-1;
                                                dp[i][j] = Integer.MAX_VALUE;
                                               // System.out.println(i+" - "+j+" - "+s);
						for(int k=i;k<j;k++)
                                                {
                                                    //dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + matriz[i][0]*matriz[k][1]*matriz[j][1]);
                                                    int value =  dp[i][k] + dp[k+1][j] + matriz[i][0]*matriz[k][1]*matriz[j][1];
                                                    if(dp[i][j] > value)
                                                    {
                                                        dp[i][j] = value;
                                                        dp2[i][j] = k;
                                                    }
                                                }
					}
			
			/*for(int i=0;i<=n;i++)
			System.out.println(Arrays.toString(dp[i]));
                        System.out.println("*********");
                        for(int i=0;i<=n;i++)
			System.out.println(Arrays.toString(dp2[i]));*/
                        System.out.println("Case "+t+": "+answer(dp2, 1, n));
                        t++;
                        
                        
				
		}
		in.close();
		System.exit(0);
	}
}