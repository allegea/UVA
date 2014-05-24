/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */

public class RobotMotion {

	static char[][] grid;
	static boolean[][] visited;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] paths;
	static int N, M;
	
	static boolean isInside(int i, int j)
	{
		return i>=0 && i<N && j>=0 && j<M;
	}
	
	static int nextMove(int i, int j)
	{
		if(grid[i][j] == 'E')return 0;
                else if(grid[i][j] == 'N')return 1;
                else if(grid[i][j] == 'W')return 2;
                else return 3;
                
	}
	
	static void DFS(int i, int j)
	{
		visited[i][j] = true;
		int x = nextMove(i, j);
		int u = i+dx[x];
		int v = j+dy[x];
		if(!isInside(u, v))
		{
			System.out.println(paths[i][j]+" step(s) to exit");
			return;
		}
		if(visited[u][v])
		{
			System.out.println((paths[u][v]-1)+" step(s) before a loop of "+(paths[i][j]-paths[u][v]+1) +" step(s)");
			return;
		}
		paths[u][v] = paths[i][j]+1;
		DFS(u, v);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] read = in.readLine().split("[ ]+");
			N = Integer.parseInt(read[0]);
			M = Integer.parseInt(read[1]);
			int f = Integer.parseInt(read[2]);
			if(N == 0 && M == 0 && f == 0)break;
			
			grid = new char[N][M];
			visited = new boolean[N][M];
                        paths = new int[N][M];
			for(int i=0;i<N;i++)
			grid[i] = in.readLine().toCharArray();
			
			paths[0][f-1] = 1;
			DFS(0, f-1);
			
		}
		in.close();
		System.exit(0);
	}
}