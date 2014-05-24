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

public class SquareSums {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int curr = 1;
		boolean[][] visited;
		int[][] grid;
		int x;
		int y;
		String[] read;
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			String output = "Case "+curr+":";
			curr++;
			visited = new boolean[n][n];
			grid = new int[n][n];

			for(int i=0;i<n;i++)
			{
				read = in.readLine().split("[ ]+");
				for(int j=0;j<read.length;j++)
				grid[i][j] = Integer.parseInt(read[j]);
			}
			
			for(int i=0;i<(n/2);i++)
			{
				int dir = 0;
				int sum = 0;
				x = i;
				y = i;
                               // System.out.println(x+" - "+y+" - "+visited[x][y]);
				while(!visited[x][y])
				{
					//System.out.println(x+" - "+y+" - "+grid[x][y]);
					visited[x][y]=true;
					sum+=grid[x][y];
					int u = x+dx[dir];
					int v = y+dy[dir];
					if(u < 0 || u>= n || v < 0 || v>=n || visited[u][v])
					{
                                            if(u == i && v == i)
                                                break;
                                            dir = (dir+1)%4;
                                            u = x+dx[dir];
					    v = y+dy[dir];
					}
					x = u;
					y = v;
				}
                              //  System.out.println("***");
				//sum-=grid[i][i];
				output+=" "+sum;
			}
			
			if(n%2!=0)
			output+=" "+grid[n/2][n/2];
			System.out.println(output);
		}
		in.close();
		System.exit(0);
	}

}