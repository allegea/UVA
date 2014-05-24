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

public class  StringDistanceAndTransformProcess  {
static int n, m;
static char[] a, b;
static int[][] dp;
static final int INF = Integer.MAX_VALUE/2;
static StringBuilder output  = new StringBuilder();
	static int solve(int i, int j)
	{
		if(i == n || j == m )return dp[i][j] = Math.abs((n - i) - (m - j));
                if(dp[i][j] != INF)return dp[i][j];
                int min = INF;
                if(a[i] == b[j])min = solve(i + 1, j + 1);
                else{
                    min = Math.min(solve(i, j + 1) + 1, solve(i + 1, j) + 1);
                    min = Math.min(solve(i + 1, j + 1) + 1, min);
                    
                }
                return dp[i][j] = min;
                
	}
        
        static void printSolution(int i, int j, int curr, int dist, int pos)
        {
            if(curr == dist)return;
            if(i == n || j == m)
            {
              if(i == n)
                {
                for(int h = j; h < m; h++)
                     output.append(++curr).append(" Insert ").append(i-(pos--)+1).append(",").append(b[h]);
                    //System.out.println((++curr) + " Insert "+(i-(pos--)+1)+","+b[h]);
                return;
                }
                 if(j == m)
                for(int h = i; h < n; h++)
                    output.append(++curr).append(" Delete ").append((++i)-(pos++));
                   //System.out.println((++curr) + " Delete "+((++i)-(pos++)));
                return;
            }
            if(a[i] == b[j])
                printSolution(i + 1, j + 1, curr, dist, pos);
            else{
                if(dp[i + 1][j + 1] <= dp[i + 1][j] && dp[i + 1][j + 1] <= dp[i][j + 1])
                {
                     output.append(curr).append(1).append(" Replace ").append(i+1).append(",").append(b[j]);
                    //System.out.println(curr+1 + " Replace "+(i+1)+","+b[j]);
                    printSolution(i + 1, j + 1, curr + 1, dist, pos);
                }else if(dp[i + 1][j] <= dp[i + 1][j + 1] && dp[i + 1][j] <= dp[i][j + 1])
                {
                     output.append(curr).append(1).append(" Delete ").append(i-pos + 1);
                    //System.out.println(curr+1 + " Delete "+(i-pos + 1));
                    printSolution(i + 1, j, curr + 1, dist, pos + 1);
                    
                }else if(dp[i][j + 1] <= dp[i + 1][j + 1] && dp[i][j + 1] <= dp[i + 1][j])
                {
                    output.append(curr).append(1).append(" Insert ").append(i-pos+1).append(",").append(b[j]);
                    //System.out.println(curr+1 + " Insert "+(i-pos+1)+","+b[j]);
                    printSolution(i, j + 1, curr + 1, dist, pos - 1);
                }
            }
        }
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		boolean noFirst = false;
		while(( line = in.readLine()) != null)
		{
		    if(noFirst)System.out.println();
			noFirst = true;
			a = line.toCharArray();
			b = in.readLine().toCharArray();
			n = a.length;
			m = b.length;
                        dp = new int[n + 1][m + 1];
                        for(int i = 0; i<=n; i++)Arrays.fill(dp[i], INF);
			int dist = solve(0, 0);
			//System.out.println(dist);
                         output.append(dist);
			printSolution(0, 0, 0, dist, 0);
                        fsdfsdf
		}
		in.close();
		System.exit(0);
	}
}


 /*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class StringDistanceAndTransformProcess {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder("");
        while (true) {
            String line = buf.readLine();
            if (line == null )
                break;
 
            char[] c1 = line.toCharArray();
            char[] c2 = buf.readLine().toCharArray();
            int[][] dp = new int[c1.length][c2.length];
            for (int i = 0; i < dp.length; i++)
                Arrays.fill(dp[i], -1);
            int[][] best = new int[c1.length + 1][c2.length + 1];
            int min = go(dp, best, 0, 0, c1, c2);
            StringBuilder ans = build(best, c1, c2);
            s.append(min + "\n");
            s.append(ans + "\n");
        }
        System.out.print(s.substring(0, s.length() - 1));
    }
 
    private static StringBuilder build(int[][] best, char[] c1, char[] c2) {
        int i = 0;
        int j = 0;
        int index = 1;
        StringBuilder ans = new StringBuilder("");
        int len = 1;
        while (i < best.length && j < best[0].length) {
            if (best[i][j] == 1) {
                for (int k = j; k < c2.length; k++)
                    ans.append((index++) + " Insert " + (len++) + "," + c2[k]
                            + "\n");
                break;
            } else if (best[i][j] == 2) {
                for (int k = i; k < c1.length; k++)
                    ans.append((index++) + " Delete " + (len) + "\n");
                break;
            } else if (best[i][j] == 3) {
                ans.append((index++) + " Replace " + (len++) + "," + c2[j]
                        + "\n");
                i++;
                j++;
            } else if (best[i][j] == 4) {
                ans.append((index++) + " Delete " + (len) + "\n");
                i++;
            } else if (best[i][j] == 5) {
                ans.append((index++) + " Insert " + (len++) + "," + c2[j]
                        + "\n");
                j++;
            } else {
                len++;
                i++;
                j++;
            }
        }
        return ans;
    }
 
    private static int go(int[][] dp, int[][] best, int i, int j, char[] c1,
            char[] c2) {
        if (i == c1.length) {
            best[i][j] = 1;
            return c2.length - j;
        } else if (j == c2.length) {
            best[i][j] = 2;
            return c1.length - i;
        } else if (dp[i][j] != -1)
            return dp[i][j];
        else {
            int min = Integer.MAX_VALUE;
            if (i < c1.length && j < c2.length && c1[i] == c2[j]) {
                best[i][j] = 0;
                min = go(dp, best, i + 1, j + 1, c1, c2);
            } else {
                int x = 1 + go(dp, best, i + 1, j, c1, c2);
                int y = 1 + go(dp, best, i, j + 1, c1, c2);
                int z = 1 + go(dp, best, i + 1, j + 1, c1, c2);
                min = Math.min(z, Math.min(x, y));
                if (min == x)
                    best[i][j] = 4;
                else if (min == y)
                    best[i][j] = 5;
                else if (min == z)
                    best[i][j] = 3;
            }
            return dp[i][j] = min;
        }
    }
}*/