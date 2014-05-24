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

public class HomerSimpson2
{
    static int N, M;
    static Integer[][] dp;
    static int min = 0;
    static int cant = 0;
	static int DP(int x, int y, int time)
	{
                if(time < 0)return 0;
                if(time - N < 0 && time - M < 0 )
                {
                    if(cant <= x + y)
                        min = Math.min(min, time);
                    cant = Math.max(cant, x + y);
                    return dp[x][y] = x + y;
                }
               if(dp[x][y] != null)return dp[x][y];
                return dp[x][y] = Math.max(DP(x + 1, y, time - N), DP(x, y + 1, time - M));
	}
        
        /*static int DP2(int time)
	{
                if(time < 0)return 0;
                if(time - N < 0 && time - M < 0 )
                {
                    if(cant <= x + y)
                        min = Math.min(min, time);
                    cant = Math.max(cant, x + y);
                    return dp[x][y] = x + y;
                }
               if(dp[x][y] != null)return dp[x][y];
                return dp[x][y] = Math.max(DP(x + 1, y, time - N), DP(x, y + 1, time - M));
	}*/
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
                boolean noFirst = false;
		while(in.hasNext())
		{
                        if(noFirst)System.out.println();
                        noFirst = true;
                        boolean found = false;
                        min = Integer.MAX_VALUE;
                        cant = 0;
                        int cant2 = 0;
			N = in.nextInt();
			M = in.nextInt();
			int time = in.nextInt();
                        for(int i = 0; N * i <= time; i++)
                        {
                            int y = (time - N * i) / M;
                            int remain = time - y * M - N * i;
                            //System.out.println(i + " - " + y + " - " + remain);
                            if(remain == 0)
                            {
                                found  = true;
                                cant = Math.max(cant, y + i);
                            }else{
                                if(remain <= min)
                                {
                                    if(remain == min)
                                       cant2 = Math.max(cant2, y + i);
                                    else cant2 = y + i;
                                    min = remain;
                                }
                                
                            }
                        }
                        
                        if(found)System.out.print(cant);
                        else System.out.print(cant2 + " " + min);
                        //dp = new Integer[time + 1][time + 1];
			//System.out.println(DP(0, 0, time) + (min != Integer.MAX_VALUE?" "+min:""));
                        //System.out.println(min);
		}
		in.close();
		System.exit(0);
	}
}