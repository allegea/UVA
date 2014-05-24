/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Checkers{

	static int mod = 1000007;
	static char[][] grid;
	static int[][] paths;
	static int N;
	static int[] dx = {-1, 1};
	static boolean[][] visit;
	static boolean isInside(int i, int j)
	{
		return i>=0 && i<N && j>=0 && j<N;
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		int currCase = 0;
		while(currCase++<cases)
		{
			N = Integer.parseInt(in.readLine());
			paths = new int[N][N];
			grid = new char[N][N];
			visit = new boolean[N][N];
			for(int i=0;i<N;i++)
				grid[i] = in.readLine().toCharArray();
			
			int ii = 0;
			int jj = 0;
			boolean nofound = true; 
			for(int i=0;i<N && nofound;i++)
				for(int j=0;j<N && nofound;j++)
					if(grid[i][j] == 'W'){
						ii = i;
						jj = j;
						break;
					}
					
			paths[ii][jj] = 1;
			visit[ii][jj] = true;
			for(int i=ii;i>0;i--)
				for(int j=0;j<N;j++)
				{
					if(visit[i][j])
					{
						for(int k = 0;k<dx.length;k++)
						{
							int u = i - 1;
							int v = j + dx[k];
							if(isInside(u, v))
							{
								if(grid[u][v] != 'B'){
								paths[u][v] += (paths[i][j]%mod);
                                                                paths[u][v]%=mod;
								visit[u][v] = true;
								}
								else
								{
									u -= 1;
									v +=dx[k];
									if(isInside(u, v))
									if(grid[u][v] != 'B'){
										paths[u][v] += (paths[i][j]%mod);
                                                                                paths[u][v]%=mod;
										visit[u][v] = true;
									}
										
								}
							}
						}
					}
				}
				
			int answer = 0;	
			for(int i=0;i<N;i++){
			answer+=(paths[0][i]%mod);
                        answer%=mod;
                        //System.out.println(Arrays.toString(paths[i]));
                        }
			
			System.out.println("Case "+currCase+": "+answer);
		}
		in.close();
		System.exit(0);
	}
}
