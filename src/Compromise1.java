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

public class Compromise1{

	static ArrayList<String> a, b;
	static int n, m;
	static int[][] dp;
        static StringBuilder output;
	static int solve(int i, int j)
	{
		if(i == n || j == m) return dp[i][j] = 0;
		if(dp[i][j] != -1)return dp[i][j];

                int max = 0;
		if(a.get(i).equals(b.get(j))) max = 1 + solve(i + 1, j + 1);
                else max = Math.max(solve(i + 1, j), solve(i, j + 1 ));
		return dp[i][j] = max;
	}
        static void printSolution(int i, int j, int cant, int curr )
        {
            
            if(a.get(i).equals(b.get(j)))
            {
                if(curr == cant - 1)output.append(a.get(i));
                else {output.append(a.get(i)).append(" ");
                printSolution(i + 1, j + 1, cant, curr + 1);
                }
            }else {
                if(dp[i + 1][j] >= dp[i][j + 1])
                    printSolution(i + 1, j, cant, curr);
                else printSolution(i, j + 1, cant, curr);
                
            }
        }
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		String line = "";
		
		
		while(in.hasNext())
		{
			output = new StringBuilder();
			 a = new ArrayList<String>();
			 b = new ArrayList<String>();
			 
			 while(!(line  = in.next()).equals("#"))a.add(line);
			 
			 while(!(line  = in.next()).equals("#"))b.add(line);
			
			n = a.size();
			m = b.size();
			//System.out.println(a);
                        //System.out.println(b);
			dp = new int[n + 1][m + 1];
                        for(int i = 0; i <= n; i++)Arrays.fill(dp[i], -1);
			
                        printSolution(0, 0, solve(0, 0), 0);

			System.out.println(output);
			
		}
		
		in.close();
		System.exit(0);
		
	}
}