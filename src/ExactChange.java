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

public class ExactChange{
	private static int[] bills;
	private static final int MAX = 100000;
	private static long[] dp;
	private static int[] toPay;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		toPay = new int[cases];
		for (int i = 0; i < cases; i++) toPay[i] = Integer.parseInt(in.readLine());
		
		int M = Integer.parseInt(in.readLine());
		bills = new int[M];
		for (int j = 0; j < M; j++) bills[j] = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < cases; i++) {

			dp = new long[MAX];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			for (int j = 0; j < M; j++)
				for (int h = 0; h <= toPay[i]; h++)
					if(dp[h] != Integer.MAX_VALUE)
						dp[h + bills[j]] = Math.min(dp[h + bills[j]], 1 + dp[h] );

			//solve(M - 1, 0);
			while(dp[toPay[i]] == Integer.MAX_VALUE)toPay[i]++;
			System.out.println(toPay[i] + " " + dp[toPay[i]]);

		}
		
		in.close();
		System.exit(0);
	}
}