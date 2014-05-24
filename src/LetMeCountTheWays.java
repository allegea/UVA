/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class LetMeCountTheWays{

    public static int N = 5;
    public static int M = 30000;
    public static int[] coinValue = {0, 1, 5, 10, 25, 50};
    static long[][] memo = new long[N + 1][ M + 1 ];
   /* public static long DP(int type, int value)
    {
        if(value == 0)return memo[type][value] = (long)1;
        if(value < 0 || type < 0)return 0;
        if( memo[type][value] != null) return  memo[type][value];
        return  memo[type][value] = DP(type - 1, value) + DP(type, value - coinValue[type]);
        
    }*/
    public static void DPbott()
    {
        for(int i = 0; i <= N; i++)
            memo[i][0] = 1;
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
            {
                
                memo[i][j] = memo[i - 1][j];
                if(j - coinValue[i] >= 0)
                    memo[i][j]+= memo[i][j - coinValue[i]];
                    
            }
                
    }
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
                
		while((line = in.readLine()) != null && line.length() > 0)
		{
			int x = Integer.parseInt(line);
			//long answer = DP(5 - 1, x);
                        DPbott();
                        long answer = memo[N][x];
                        if(answer == 1)
                            System.out.println("There is only 1 way to produce " + x + " cents change.");
                        else System.out.println("There are " + answer + " ways to produce " + x + " cents change.");
                        
		}
		in.close();
		System.exit(0);
	}
}