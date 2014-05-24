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
public class AgainPalindromes {
    public static Long[][] dp;
    public static int N;
    public static char[] word;
    public static long solve(int i, int j)
    {
        if(i > j)return 0;
        if(i == j) return dp[i][j] = 1l;
        if(dp[i][j] != null) return dp[i][j];
        long count = 0;
        
        if(word[i] == word[j])count = 1 + solve(i + 1, j - 1);
        count-= solve(i + 1, j - 1);
        count+= solve(i, j - 1);
        count+= solve(i + 1, j);
        return dp[i][j] = count;
    }

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int cases = Integer.parseInt(in.readLine());
         while(cases-- > 0)
         {
             word = in.readLine().toCharArray();
             N = word.length;
             dp = new Long[N + 1][N + 1];
             System.out.println(solve(0, N - 1));
         }
         in.close();
         System.exit(0);
     }
}
