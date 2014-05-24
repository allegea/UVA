/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */

public class  LittleRedRidingHood{
	
	static int N, M;
	static int[][] paths;
	static boolean[][] enable; 
	static boolean[][] wolf;
	static int[] dx = {0, -1};
	static int[] dy = {1, 0};
	
	static boolean isInside(int i, int j)
	{
		return i>=0 && i<=N && j>=0 && j<=M && !wolf[i][j];
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] read;
		while(true)
		{
			read = in.readLine().trim().split("[ ]+");
			N = Integer.parseInt(read[0]);
			M = Integer.parseInt(read[1]);
			
			if(N == 0 && M == 0)break;
			paths = new int[N+1][M+1];
			enable = new boolean[N+1][M+1];
			wolf = new boolean[N+1][M+1];
			
			int nWolf = Integer.parseInt(in.readLine());
			for(int i=0;i<nWolf;i++)
			{
				read = in.readLine().trim().split("[ ]+");
				int u = Integer.parseInt(read[0]);
				int v = Integer.parseInt(read[1]);
				wolf[N-u][v] = true;
			}
			//for(int i=0;i<=N;i++)
                           // System.out.println(Arrays.toString(wolf[i]));
			paths[N][0] = 1;
			enable[N][0] = true;
			
			for(int i = N;i>=0;i--)
				for(int j=0;j<=M;j++)
				{
					if(!enable[i][j] || wolf[i][j])continue;
					for(int k = 0;k<dx.length;k++)
					{
						int u = i +dx[k];
						int v = j +dy[k];
						if(isInside(u, v))
						{
							paths[u][v]+= paths[i][j];
							enable[u][v] = true;
						}
					}
					
				}
			//for(int i=0;i<=N;i++)
                          //  System.out.println(Arrays.toString(paths[i]));
			int answer = paths[0][M];
			if(answer == 0)
			System.out.println("There is no path.");
			else if(answer == 1)
			System.out.println("There is one path from Little Red Riding Hood's house to her grandmother's house.");
			else System.out.println("There are "+answer+" paths from Little Red Riding Hood's house to her grandmother's house.");
		}
		
		in.close();
		System.exit(0);
	}

}