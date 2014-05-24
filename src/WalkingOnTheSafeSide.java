/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class WalkingOnTheSafeSide {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         long[][] dp;
         boolean[][] unSafe;
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                in.readLine();
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               
               dp = new long[n+1][m+1];
               unSafe = new boolean[n+1][m+1];
               
               for(int i=0;i<n;i++)
               {
                   input = in.readLine().split("[ ]+");
                   int u = Integer.parseInt(input[0]);
                   for(int j=1;j<input.length;j++)
                       unSafe[u][Integer.parseInt(input[j])] = true;
               }
               
               dp[1][1] = 1;
               
               for(int i =1;i<=n; i++)
                   for(int j=1;j<=m;j++)
                   {
                       if(unSafe[i][j])continue;
                       if(i+1<=n)
                       {
                           dp[i+1][j]+=dp[i][j];
                       }
                       
                       if(j+1<=m)
                       {
                           dp[i][j+1]+=dp[i][j];
                       }
                   }
                
              // for(int i =1;i<=n; i++)
                 //  System.out.println(Arrays.toString(dp[i]));
               if(act>1)System.out.println();
               System.out.println(dp[n][m]);
            }

        in.close();
        System.exit(0);
        
    }
}
