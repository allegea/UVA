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

public class GettingInLine{

	static int N;
	static int MAX;
	static float INF = Float.MAX_VALUE/2;
	static int[][] path;
	static float[][] dist;
	static float[][] dp;
	static float TSP(int pos, int bitmask)
	{
		if(bitmask == MAX) return 0;
		if(dp[pos][bitmask] != -1)return dp[pos][bitmask];
		float min = INF;
		for(int i=0;i<N;i++)
			if(i!=pos && ((1<<i)&bitmask)==0)
			{
				float aux = dist[pos][i]+TSP(i, (1<<i)|bitmask);
				if(aux < min)
				{
                                    //System.out.println(pos+" - "+i);
					min = aux;
					path[pos][bitmask] = i;
				}
			}
		return dp[pos][bitmask] = min;
	}
	
	static float distance(int x, int y, int xx, int yy)
	{
		return (float)(Math.sqrt((x-xx)*(x-xx)+(y-yy)*(y-yy)));
	}
	
	public static void main(String[] args) throws IOException{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer r;
	int[][] points;
	int[][] finalPaths;
	int curr = 1;
	while(true)
	{
		N = Integer.parseInt(in.readLine());
		if(N == 0)break;
		System.out.println("**********************************************************");
		
		points = new int[N][2];
		MAX = (1<<N)-1;
		dp = new float[N][1<<N];
		path = new int[N][1<<N];
		finalPaths = new int[N][1<<N];
		dist = new float[N][N];
		
		for(int i=0;i<N;i++)
		{
			r = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(r.nextToken());
			int y = Integer.parseInt(r.nextToken());
			points[i][0] = x;
			points[i][1] = y;
		}
		
		for(int i=0;i<N;i++)
		{
			dist[i][i] = 0;
			for(int j=i+1;j<N;j++)
			dist[i][j] = dist[j][i] = distance(points[i][0], points[i][1], points[j][0], points[j][1])+16;
                        //System.out.println(Arrays.toString(dist[i]));
		}
		
		float min = INF;
		int pos = -1;
		float distAux = 0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			Arrays.fill(dp[j], -1);
			
			path = new int[N][1<<N];
			distAux = TSP(i, 1<<i);
                        //System.out.println(distAux);
			if(distAux < min)
			{	pos = i;
				min = distAux;
                                for(int j=0;j<N;j++)
                                System.arraycopy(path[j], 0, finalPaths[j], 0, 1<<N);
			}
		}
		//System.out.println(pos+" - "+Arrays.toString(finalPaths));
		System.out.println("Network #"+curr);
		curr++;
                int bitmask = 1<<pos;
		for(int i=0;i<N-1;i++)
		{
			System.out.printf("Cable requirement to connect ("+points[pos][0]+","+points[pos][1]+") to ("+points[finalPaths[pos][bitmask]][0]+","+points[finalPaths[pos][bitmask]][1]+") is %.2f feet.\n", dist[pos][finalPaths[pos][bitmask]]);
                        pos = finalPaths[pos][bitmask];
                        bitmask|=1<<pos;
                        
		}
		System.out.printf("Number of feet of cable required is %.2f.\n",min);
		
		
		
	}
	in.close();
	System.exit(0);
	}
}