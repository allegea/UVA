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

public class CoinChagen2{

    public static int N = 5;
    public static int M = 7489 ;
    public static int[] coinValue = {1, 5, 10, 25, 50};
    static Long[][] memo = new Long[N + 1][ M + 1 ];
    public static long DP(int type, int value)
    {
        if(value == 0)return memo[type][value] = (long)1;
        if(value < 0 || type < 0)return 0;
        if( memo[type][value] != null) return  memo[type][value];
        return  memo[type][value] = DP(type - 1, value) + DP(type, value - coinValue[type]);
        
    }
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
                
		while((line = in.readLine()) != null && line.length() > 0)
		{
			int x = Integer.parseInt(line);
			System.out.println(DP(5 - 1, x));
		}
		in.close();
		System.exit(0);
	}
}