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
public class  Grapevine2 {

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
                StringBuilder output = new StringBuilder();
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
				int i = -1;
                                
				while(++i < N - max ) 
				{
					int x = BSUpper(0, M - 1, L, i);
                                        //System.out.println("i " + i + " - " + x);
					if(x == - 1)continue;
                                        boolean found = false;
                                       // for( ; x + max < M && grid[i][x] >= L && grid[i][x] <= R && !found; x++)
                                        {
                                            int diff = M - x - 1;
                                            diff = Math.min(diff, N - i - 1);
                                            //System.out.println("Diff - " + diff + " - " + x + " - " + max);
                                            while(diff >= max)
                                            {
                                                int j = i + diff;
                                                int y = x + diff;
                                               // System.out.println("j - " + j + " - " + y);
                                                if(grid[j][y] <= R)
                                                {
                                                    max = Math.max(diff + 1, max);
                                                    break;
                                                }
                                                diff--;
                                            }
                                            
                                        }
					
					//i++;
				}
				//System.out.println(max);
                                output.append(max).append("\n");
			}
			//System.out.println("-");
                        output.append("-\n");
		}
                System.out.print(output);
                in.close();
                System.exit(0);
	}
}