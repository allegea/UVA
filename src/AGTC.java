/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class AGTC {

    static int gap = 1;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader in = new BufferedReader(new FileReader("knapsack2.txt"));
        //Scanner in = new Scanner(new FileReader("clustering1test.txt"));
        String line = "";
        while((line = in.readLine()) != null && line.length() > 0)
        {
        String[] read = line.split("[ ]+");
        int n = Integer.parseInt(read[0]);
        char[] x = read[1].toCharArray();
        
        read = in.readLine().split("[ ]+");
        int m = Integer.parseInt(read[0]);
        char[] y = read[1].toCharArray();

        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=m;i++)
            dp[0][i] = i*gap;
        for(int i=0;i<=n;i++)
            dp[i][0] = i*gap;
        
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                dp[i][j] = Math.min(dp[i-1][j-1]+(x[i-1]==y[j-1]?0:1), Math.min(dp[i][j-1]+gap, dp[i-1][j]+gap));
        
        
        /*System.out.println(String.valueOf(x)+"\n"+String.valueOf(y));
        for(int i=0;i<=n;i++)
            System.out.println(Arrays.toString(dp[i]));
        */
        System.out.println(dp[n][m]);
        
        }
       
       
        System.exit(0);
        in.close();
    }
}
