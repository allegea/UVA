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
public class  Grapevine {

	public static int N, M, Q;
        public static int[][] grid;
	public static int BSLower(int L, int R, int x, int row)
	{
		int answer = -1;
		while(L <= R)
		{
			int mid = (L + R) / 2;
			if(grid[row][mid] > x)
				R = mid - 1;
			else {
				answer = mid;
				L = mid + 1;
			}
		}
		return answer;
	
	}
        
        public static int BSUpper(int L, int R, int x, int row)
	{
		int answer = -1;
		while(L <= R)
		{
			int mid = (L + R) / 2;
			if(grid[row][mid] >= x)
                        {
                            answer = mid;
                            R = mid - 1;
                        }
			else {
				L = mid + 1;
			}
		}
		return answer;
	
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true)
		{
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0)break;
			grid = new int[N][M];
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < M; j++)
					grid[i][j] = Integer.parseInt(st.nextToken());
			}
			Q = Integer.parseInt(in.readLine());
			
			for(int h = 0; h < Q; h++)
			{
				int max = 0;
				st = new StringTokenizer(in.readLine());
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				int i = 0;
                                
				while(i < N ) 
				{
					int x = BSUpper(0, M - 1, L, i);
                                        System.out.println("i " + i + " - " + x);
					if(x == - 1)break;
					int j = N;
					while(--j >= i)
					{
						int y = BSLower(0, M - 1, R, j);
                                                System.out.println("j " + j + " - " + y);
						//if(y == -1)break;
						if(y - j == x - i)
						{
							max = Math.max(max, y - x + 1);
							break;
						}
					}
					i++;
				}
				System.out.println(max);
			}
			System.out.println("-");
		}
	}
}