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

public class MaceAndMaze{

	public static final int INF = Integer.MAX_VALUE >> 1;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		int[][] dist;
                boolean noFirst = false;
		while(cases-- > 0)
		{
                        if(noFirst)System.out.println();
                        noFirst = true;
			in.readLine();
			int M = Integer.parseInt(in.readLine());
			int exit = Integer.parseInt(in.readLine());
			int time = Integer.parseInt(in.readLine());
			int  N = Integer.parseInt(in.readLine());
			dist = new int[M + 1][M + 1];
			
			for(int i = 0 ; i <= M; i++){
                            Arrays.fill(dist[i], INF);
                            dist[i][i] = 0;
                        }
			StringTokenizer st;
			
			for(int i = 0; i < N; i ++)
			{
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				dist[u][v] = t;
			}
			
                        for(int k = 1; k <= M; k++)
                            for(int i = 1; i <= M; i++)
                                    for(int j = 1; j <= M; j++)
                                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        
			int answer = 0;
			for(int i = 1; i <= M; i++)
				if(dist[i][exit] <= time)
					answer++;
					
			System.out.println(answer);
			
		}
		in.close();
		System.exit(0);
	}
}