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
public class PeskyPalondromes{

	public static HashSet<String> palinds;
        public static boolean[][] visited;
        public static boolean[][] dp;
	public static boolean isPalindrome(String x)
	{
                //System.out.println(x);
		int n = x.length();
		for(int i = 0; i < n/2; i++)
			if(x.charAt(i) != x.charAt(n - i - 1))
				return false;
		palinds.add(x);
		return true;
	}
        
        public static boolean DP(int i, int j, String x)
        {
            
            if(i > j)return true;
            if(visited[i][j])return dp[i][j];
            
            visited[i][j] = true;
            //System.out.println(i + " - " + j + " - " +x);
            if(i == j){
                palinds.add(x.charAt(i)+"");
                return dp[i][j] = true;
            }
            
            dp[i][j] = (x.charAt(i) == x.charAt(j)) & DP(i + 1, j - 1, x);
           // System.out.println(i + " - " + j + " - "+dp[i][j] + " - " +x.substring(i, j + 1));
            if(dp[i][j])palinds.add(x.substring(i, j + 1));
            return dp[i][j];
            
        }
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
                int x = 12;
                Integer.lowestOneBit(x);
                System.out.println(-x);
                System.out.println((x>>1));
                System.out.println((x>>>1));
                System.out.println(Integer.toBinaryString(x));
                System.out.println(Integer.toBinaryString(-x));
                System.out.println(Integer.toBinaryString(x & -x));
		while((line = in.readLine()) != null)
		{
			palinds = new HashSet<String>();
                        int n = line.length();
                        visited = new boolean[n + 1][n + 1];
                        dp = new boolean[n + 1][n + 1];
                        
			for(int i = 0; i < n; i++)
				for(int j = i  ; j < n; j++)
                                            if(!visited[i][j])
                                                DP(i, j, line);
						//isPalindrome(line.substring(j, h));
				
			System.out.println("The string '"+line+"' contains " + palinds.size() + " palindromes.");
		}
		in.close();
		System.exit(0);
	}
}