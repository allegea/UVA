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
public class AGTCTopDown {

    //static int gap = 1;
    static int n, m;
    static char[] x, y;
    static final int INF = Integer.MAX_VALUE/2;
    static int[][] dp;
    static int solve(int i, int j)
    {
        if(i == n || j == m )return dp[i][j] = Math.abs((n - i) - (m - j));
        if(dp[i][j] != INF) return dp[i][j];
        int min = INF;
        if(x[i] == y[j]) min = solve(i + 1, j + 1);
        else {
            min = Math.min(solve(i, j + 1) + 1, solve( i + 1, j) + 1);
            min = Math.min(solve(i + 1, j + 1) + 1, min);
        }
        return dp[i][j] = min;
    }
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
        n = Integer.parseInt(read[0]);
        x = read[1].toCharArray();
        
        read = in.readLine().split("[ ]+");
        m = Integer.parseInt(read[0]);
        y = read[1].toCharArray();

        dp = new int[n+1][m+1];
        for(int i = 0 ; i < n + 1; i++)Arrays.fill(dp[i], INF );
        
        System.out.println(solve(0 , 0));
        
        }
       
       
        System.exit(0);
        in.close();
    }
}
