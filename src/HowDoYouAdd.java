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
public class HowDoYouAdd {

    public static final long MOD = 1000000;
    public static Long[][] dp;
    public static long DP(int n, int k)
    {
        if(k == 1)return dp[n][k] = 1l;
        if(dp[n][k] != null) return dp[n][k] % MOD;
        
        long answer = 0;
        for(int i = 0; i <= n; i++)
            answer+= DP(n - i, k - 1) % MOD;
        return dp[n][k] = answer % MOD;
    }
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         while(true)
         {
             st = new StringTokenizer(in.readLine());
             int n = Integer.parseInt(st.nextToken());
             int k = Integer.parseInt(st.nextToken());
             if(n == 0 && k == 0)break;
             dp = new Long[n + 1][k + 1];
             System.out.println(DP(n, k));
         }
         in.close();
         System.exit(0);
     }
}

