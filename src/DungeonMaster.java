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

public class DungeonMaster{

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int[] dz = {-1, 0, 1};
	static char[][][] grid;
	static boolean[][][] visited;
	static int n, m, l;
	
	static boolean canGo(int i, int j, int k)
	{
		return k>=0 && k<l && i>=0 && i<n && j>=0 && j<m && !visited[k][i][j] && grid[k][i][j] != '#'; 
	}	
	
	static int BFS(int i, int j, int k)
	{
		Queue<Integer> x = new LinkedList<Integer>();
		Queue<Integer> y = new LinkedList<Integer>();
		Queue<Integer> z = new LinkedList<Integer>();
		visited[k][i][j] = true;
		x.offer(i);
		y.offer(j);
		z.offer(k);
		int[][][] paths = new int[l][n][m];
		while(!x.isEmpty())
		{
			int a = x.poll();
			int b = y.poll();
			int c = z.poll();
			if(grid[c][a][b] == 'E')
			{
				return paths[c][a][b];
			}
			
			for(int ii=0;ii<dz.length;ii++)
			{
				int p = (dz[ii]==0?1:0);
				for(int jj=0;jj<dx.length;jj++)
				{
					int u = a+dx[jj]*p;
					int v = b+dy[jj]*p;
					int vv = c+dz[ii];
					if(canGo(u, v, vv))
					{
						paths[vv][u][v] = paths[c][a][b]+1;
						x.offer(u);
						y.offer(v);
						z.offer(vv);
                                                visited[vv][u][v] = true;
					}
				}
			}
		}
		return -1;
	
	}

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			String[] read = in.readLine().split("[ ]+");
			l = Integer.parseInt(read[0]);
			n = Integer.parseInt(read[1]);
			m = Integer.parseInt(read[2]);
			if(l == 0 && n == 0 && m == 0)break;
			grid = new char[l][n][m];
			visited = new boolean[l][n][m];
			
			for(int i=0;i<l;i++)
			{
				for(int j=0;j<n;j++)
				grid[i][j] = in.readLine().toCharArray();
				in.readLine();
			}
			
			boolean nofound = true;
			for(int i=0;i<l && nofound;i++)
				for(int j=0;j<n && nofound;j++)
					for(int k=0;k<m && nofound;k++)
					if(grid[i][j][k] == 'S')
					{
						nofound = false;
						int answer = BFS(j, k, i);
						System.out.println(answer>=0?"Escaped in "+answer+" minute(s).":"Trapped!");
					}
			
		}
		in.close();
		System.exit(0);
	}

}
