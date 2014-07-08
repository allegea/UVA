/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

public class StringPartition {

	private final static long MAX_VALUE = Integer.MAX_VALUE;
	private final static int MAX_DIGITS = 10;
	private static String number;
	private static Long[] dp;
	private static long solve(int i) {
		if (dp[i] != null) return dp[i];
		if (i >= number.length()) return 0l;
		long value = 0;
		for (int h = 1; h <= MAX_DIGITS && i + h <= number.length(); h ++) 
			if (number.charAt(i) != '0') {
				long posValue = Long.parseLong(number.substring(i, i + h));
				if (posValue <= MAX_VALUE) 
					value = Math.max(solve(i + h) + posValue, value);
			} else value = Math.max(solve(i + 1), value);
				
		return dp[i] = value;
	}
	
	/*private static long solve(int i, int j) {
		if (dp[i][j] != null) return dp[i][j];
		if (i >= j) return dp[i][j] = 0l;
		long value = 0;
		if (j - i <= MAX_DIGITS) {
			long posValue = Long.parseLong(number.substring(i, j));
			if (posValue <= MAX_VALUE) return dp[i][j] = posValue;
		}
		for (int h = i + 1; h < j; h ++) 
			if (number.charAt(h) != '0') 
				value = Math.max(solve(i, h) + solve(h, j), value);
		return dp[i][j] = value;
	}*/
   public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int cases = Integer.parseInt(in.readLine());
         StringBuilder st = new StringBuilder();
         while (cases-- > 0) {
        	 number = in.readLine();
        	 int m = number.length();
        	 dp = new Long[m + 1];
        	 long answer = solve(0);
        	 st.append(answer).append("\n");
        	 //dp = new Long[m + 1][m + 1];
        	// st.append(solve(0, m)).append("\n");
         }
         System.out.print(st);
         in.close();
         System.exit(0);
     }
}
