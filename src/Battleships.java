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

public class Battleships {

	static int n;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static char[][] grid;
	static boolean[][] visited;
	static boolean alive;
	static boolean canGo(int i, int j)
	{
		return i>=0 && i<n && j>=0 && j<n && !visited[i][j] && grid[i][j] != '.';
	}
	
	static void DFS(int i, int j)
	{
		if(!canGo(i, j))return;
		alive|= (grid[i][j] ==  'x');
                visited[i][j] = true;
		for(int ii=0;ii<dx.length;ii++)
			DFS(i+dx[ii], j+dy[ii]);
	}	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		int curr = 0;
		while(curr++<t)
		{
			n = Integer.parseInt(in.readLine());
			grid = new char[n][n];
			visited = new boolean[n][n];
			for(int i=0;i<n;i++)
			grid[i] = in.readLine().toCharArray();
			
			int count = 0;
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				if(grid[i][j] != '.' && !visited[i][j])
				{
					alive = false;
					DFS(i, j);
					if(alive) count++;
				}
			System.out.println("Case "+curr+": "+count);
		}
		in.close();
		System.exit(0);
		}
}