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

public class CollectingBeepers {
	static int N;
	static int[][] dist;
	static int[][] dp;
	static int MAX = Integer.MAX_VALUE/2;
	static int LIMIT;
	static int TSP(int pos, int bitmask)
	{
		if(bitmask == LIMIT)return dist[pos][0];
		if(dp[pos][bitmask] != MAX)return  dp[pos][bitmask];
		int min = MAX;
		for(int i=0;i<=N;i++)
			if(i!=pos && ((1<<i)&bitmask)==0)
			min = Math.min(min, dist[pos][i]+TSP(i, (1<<i)|bitmask));
		
		return dp[pos][bitmask] = min;
	}
	
	public static void main(String[] args) throws IOException{
	Scanner in = new Scanner(System.in);
	int cases = in.nextInt();
	int[][] points;
	while(cases-->0)
	{
		in.nextInt();
		in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		N = in.nextInt();
		dist = new int[N+1][N+1];
		points = new int[N+1][2];
		dp = new int[N+1][1<<(N+1)];
		LIMIT = (1<<(N+1))-1;
		points[0][0] = x;
		points[0][1] = y;
		Arrays.fill(dp[0], MAX);
		for(int i=1;i<=N;i++){
			points[i][0] = in.nextInt();
			points[i][1] = in.nextInt();
			Arrays.fill(dp[i], MAX);
		}
		
		for(int i=0;i<=N;i++)
		{
			dist[i][i] = 0;
			for(int j=i+1;j<=N;j++)
			{
				dist[i][j] = dist[j][i] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
				
			}
		}
		System.out.println("The shortest path has length "+TSP(0, 1));
	
	}
	in.close();
	System.exit(0);
	}
}
