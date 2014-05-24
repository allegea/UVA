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

public class LongestMatch{

	static ArrayList<String> a, b;
	static int n, m;
	static int[][] dp;
	static int LCS(int i, int j)
	{
		if(i == n || j == m)return dp[i][j] = 0;
		if(dp[i][j] != -1)return dp[i][j];
		int max = 0;
		if(a.get(i).equals(b.get(j))) max = 1 + LCS(i + 1, j + 1);
		else max = Math.max(LCS(i + 1, j), LCS(i, j + 1));
		
		return dp[i][j] = max;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner in = new Scanner(System.in);
		String one = "";
		String two = "";
		//StringBuilder output = new StringBuilder();
		StringTokenizer st;
		int cases = 1;
		while( (one = in.readLine()) != null )
		{
                    StringBuilder output = new StringBuilder();
			//one = in.readLine();
			two = in.readLine();
			//if(n == 0 && m == 0)break;
			
			
			int nn = one.length();
                        int mm = two.length();
			one = one.replaceAll("[^a-zA-Z0-9]", " ");
			two = two.replaceAll("[^a-zA-Z0-9]", " ");
                        //System.out.println(" - "+one);
                        //System.out.println(" - "+two);
			st = new StringTokenizer(one);
			b = new ArrayList<String>();
			a = new ArrayList<String>();
			while(st.hasMoreTokens())a.add(st.nextToken());
			st = new StringTokenizer(two);
			while(st.hasMoreTokens())b.add(st.nextToken());
                        
                        n = a.size();
                        m = b.size();
                        dp = new int[n + 1][m + 1];
			for(int i = 0; i <= n ; i++)Arrays.fill(dp[i], -1);
                        
			String suffix = cases < 10?" "+cases:""+cases;
			output.append(suffix).append(". ");
			cases++;
			if(nn == 0 || mm == 0){
				output.append("Blank!\n");
			}else output.append("Length of longest match: ").append(LCS(0, 0)).append("\n");
			System.out.print(output);
		}
		//System.out.print(output);
		in.close();
		System.exit(0);
		
	}
}