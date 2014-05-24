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

class TheMonocycle {

	static int n, m;
	static boolean[][][][] visited;
	static char[][] grid;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	//0, green
	//1, black
	//2, red
	//3, blue
	//4, white
	static class State {

            int x, y, c, d;
        public State(int x, int y, int c, int d) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.d = d;
        }

        }
	static boolean canGo(int i, int j, int col, int pos)
	{
		return i>=0 && i<n && j>=0 && j<m && grid[i][j] != '#' && !visited[i][j][col][pos];
	}
	
	static int BFS(int i, int j)
	{
		Queue<State> Q = new LinkedList<State>();

		visited = new boolean[n][m][5][4];
		int[][][][] path = new int[n][m][5][4];
		visited[i][j][0][0] = true;
                Q.offer(new State(i, j, 0, 0));

		int x, y, c, d;
                State aux;
		while(!Q.isEmpty())
		{
                        aux = Q.poll();
			x = aux.x;
			y = aux.y;
			c = aux.c;
			d = aux.d;
			if(grid[x][y] == 'T' && c == 0)return path[x][y][c][d];
			
			int u = x+dx[d];
			int v = y+dy[d];
			int newC = (c+1)%5;
			int newD = (d+1)%4;
                        int newDD = (d-1+4)%4;
			if(canGo(u, v, newC, d))
			{
                                 Q.offer(new State(u, v, newC, d));
				visited[u][v][newC][d] = true;
				path[u][v][newC][d] = path[x][y][c][d] + 1;
			}
			
			if(!visited[x][y][c][newD])
			{
                                Q.offer(new State(x, y, c, newD));
				visited[x][y][c][newD] = true;
				path[x][y][c][newD] = path[x][y][c][d] + 1;
			}
                        
                        if(!visited[x][y][c][newDD])
			{
                                Q.offer(new State(x, y, c, newDD));
				visited[x][y][c][newDD] = true;
				path[x][y][c][newDD] = path[x][y][c][d] + 1;
			}
		
		}
		return -1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer r;
		boolean first = true;
		int cases = 1;
		while(true)
		{
			r = new StringTokenizer(in.readLine());
			n = Integer.parseInt(r.nextToken());
			m = Integer.parseInt(r.nextToken());
			if(n == 0 && m == 0)break;
			if(!first)System.out.println();
			first = false;
			grid = new char[n][m];
			for(int i=0;i<n;i++)
				grid[i] = in.readLine().toCharArray();
			boolean conti = true;
			int answer = 0;
			for(int i=0;i<n && conti;i++)
				for(int j=0;j<m && conti;j++)
					if(grid[i][j]=='S')
					{
						System.out.println("Case #"+(cases++));
						System.out.println((answer = BFS(i, j))!=-1?"minimum time = "+answer+" sec":"destination not reachable");
						conti = false;
					}
		}
		in.close();
		System.exit(0);
	
	}
	
}
