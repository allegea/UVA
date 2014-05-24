/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class MaximumSubSequenceProduct {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int[] numbers;
         BigInteger[] dp;
         String line = "";
         StringTokenizer st;
         int n;
         BigInteger answer;
         while((line = in.readLine()) != null)
         {
             answer = new BigInteger("-9999999999");
             st = new StringTokenizer(line);
             n = st.countTokens() - 1;
             numbers = new int[n];
             dp = new BigInteger[n + 1];
             Arrays.fill(dp, BigInteger.ZERO);
             for(int i = 0; i < n; i++)
             {
                 int x = Integer.parseInt(st.nextToken());
                 numbers[i] = x;
             }
             
             for(int i = 1; i <= n; i++)
                 dp[i] = (dp[i - 1].equals(BigInteger.ZERO)?BigInteger.ONE:dp[i - 1]).multiply(new BigInteger(String.valueOf(numbers[i - 1])));
            // System.out.println(Arrays.toString(dp));
             
             for(int i = 1; i <= n; i++)
             {
                 answer = answer.max(dp[i]);
                 for(int j = i - 1; j >= 0 && !dp[j].equals(BigInteger.ZERO); j--)
                     answer = answer.max(dp[i].divide(dp[j]));
             }
             System.out.println(answer);
         }
         in.close();
         System.exit(0);
     }
}
