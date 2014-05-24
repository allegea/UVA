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

public class HomerSimpson
{WA
    static int M;
	static int DP(int x, int y, int time)
	{
		if(time > M)return 0;
		int value = 0;
		if(time + x <= M)value = Math.max(value, DP(x, y, time+x)+1);
		if(time + y <= M)value = Math.max(value, DP(x, y, time+y)+1);
               // System.out.println(x+" - "+y+" - "+value);
		return value;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
                int[] dp;
		while(in.hasNext())
		{
			int n = in.nextInt();
			int m = in.nextInt();
			M = in.nextInt();
                        dp = new int[M+1];
                        dp[n] = dp[m] = 1;
                        for(int i=n;i<=M;i++)
                            if(dp[i-n]>0)
                            dp[i] +=dp[i-n]+1;
                        
                        for(int i=m;i<=M;i++)
                            if(dp[i-m]>0)
                            dp[i] +=dp[i-m]+1;
                        
                        System.out.println(Arrays.toString(dp));
			//System.out.println(DP(n, m, 0));
		}
		in.close();
		System.exit(0);
	}
}