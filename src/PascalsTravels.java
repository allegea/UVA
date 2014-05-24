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
public class PascalsTravels {

    public static int N;
    public static boolean canGo(int i, int j)
    {
        return i < N && j < N;
    }
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int[][] grid;
         long[][] dp;
         boolean[][] visited;
         String line = "";
         while(true)
         {
             N = Integer.parseInt(in.readLine().trim());
             if(N == -1)break;
             grid = new int[N][N];
             dp = new long[N][N];
             visited = new boolean[N][N];
             for(int i = 0; i < N; i++)
             {
                 line = in.readLine();
                 for(int j = 0; j < N; j++)
                     grid[i][j] = line.charAt(j) - '0';
             }
             dp[0][0] = 1;
             visited[0][0] = true;
             
             for(int i = 0; i < N; i++)
                 for(int j = 0; j < N; j++)
                 {
                     if(!visited[i][j]) continue;
                     if(grid[i][j] == 0)continue;
                     int u = i + grid[i][j];
                     int v = j + grid[i][j];
                     if(canGo(u, j))
                     {
                         dp[u][j]+= dp[i][j];
                         visited[u][j] = true;
                     }
                     
                     if(canGo(i, v))
                     {
                         dp[i][v]+= dp[i][j];
                          visited[i][v] = true;
                     }
                     
                 }
            // for(int i = 0; i < N; i++)
             //System.out.println(Arrays.toString(dp[i]));
             System.out.println(dp[N - 1][N - 1]);
         }
         in.close();
         System.exit(0);
     }
}
