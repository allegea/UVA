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
public class StringComputer {
    public static char[] x, y;
    public static int N, M;
    public static int[][] dp;
    public static int INF = Integer.MAX_VALUE / 2;
    
    public static int solve(int i, int j)
    {
        if(i == N || j == M )return 0;//dp[i][j] = Math.abs((N - i) - (M - j));
        if(dp[i][j] != INF)return dp[i][j];
        int min = INF;
        if(x[i] == y[j])min = solve(i + 1, j + 1);
        else{
            min = Math.min(min, solve(i + 1, j + 1) + 1);
            min = Math.min(min, solve(i + 1, j) + 1);
            min = Math.min(min, solve(i, j + 1) + 1);
        }
        return dp[i][j] = min;
    }
    public static int ins, del;
    public static void print(int i, int j)
    {
        if(i == N || j == M )return;
        if(x[i] == y[j])print(i + 1, j + 1);
        else{
            if(dp[i + 1][j + 1] <= dp[i][j + 1] && dp[i + 1][j + 1] <= dp[i + 1][j]) //change
            {
                System.out.printf("C%c%02d", y[i + 1], j + ins - del);
                print(i + 1, j + 1);
            }else if(dp[i][j + 1] <= dp[i + 1][j + 1] && dp[i][j + 1] <= dp[i + 1][j]) //insert
            {
                System.out.printf("I%c%02d", y[i], j + 1);
                ins++;
                print(i, j + 1);
                
            }else  //delete
            {
                del++;
                System.out.printf("D%c%02d", x[i], i + 1);
                print(i + 1, j);
            }
        }
        
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
             String line =  st.nextToken();
             if(line.compareTo("#") == 0)break;
             x = line.toCharArray();
             y = st.nextToken().toCharArray();
             N = x.length;
             M = y.length;
             ins = 0;
             del = 0;
             dp = new int[N + 1][M + 1];
             for(int i = 0; i <= N; i++)Arrays.fill(dp[i], INF);
             int min = solve(0, 0);
             print(0, 0);
             System.out.println("E");
             
         }
         in.close();
         System.exit(0);
     }
}
