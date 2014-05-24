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
public class ZombiesTreasureChest {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         int n = Integer.parseInt(in.readLine());
         int M = 2;
         int curr = 1;
         while(n-- > 0)
         {
            st = new StringTokenizer(in.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] v = new int[M + 1];
            int[] w = new int[M + 1];
            int[][] dp = new int[M + 1][size + 1];
            
            w[2] = Integer.parseInt(st.nextToken());
            v[2] = Integer.parseInt(st.nextToken());
            w[1] = Integer.parseInt(st.nextToken());
            v[1] = Integer.parseInt(st.nextToken());
            System.out.println(size + " - " + Arrays.toString(v));
            System.out.println(size + " - " + Arrays.toString(w));
            
            
            for(int i = 1; i <= M; i++)
                for(int j = 0; j <= size; j++)
                {
                    if(w[i] > j)
                        dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            for(int i = 0; i <= M; i++)
                System.out.println(Arrays.toString(dp[i]));
            System.out.println("Case #" + curr + ": " + dp[M][size]);
            curr++;
            
         }
         in.close();
         System.exit(0);
     }
}
