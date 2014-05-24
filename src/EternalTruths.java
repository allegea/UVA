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

public class EternalTruths{
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][][] visited;
	static int n, m;
	static char[][] grid;
	static int[][][] steps;
	
	public static boolean canGo(int i, int j)
	{
		return i>=0 && i<n && j>=0 && j<m && grid[i][j] != '#' ;
	}
	
	public static int BFS()
	{
		Queue<Integer> qX = new LinkedList<Integer>();
		Queue<Integer> qY = new LinkedList<Integer>();
		Queue<Integer> qS = new LinkedList<Integer>();
		boolean noFound = true;
		int mo = 3;
		for(int i = 0;i<n && noFound;i++)
			for(int j=0;j<m; j++)
				if(grid[i][j] == 'S')
				{
					qX.offer(i);
					qY.offer(j);
					qS.offer(1);
					noFound = false;
					break;
				}
		int answer = -1;	
		while(!qX.isEmpty())
		{
			int x = qX.poll();
			int y = qY.poll();
			int s = qS.poll();
			//System.out.println("****"+x+" - "+y+" - "+s);
			if(grid[x][y] == 'E')
			{
                                //System.out.println("Return "+steps[x][y][((s-2+mo)%mo+1)]+" - "+steps[x][y][s]);
				answer = steps[x][y][s];
				break;
			}
			
			for(int i=0;i<4;i++)
			{
				boolean can = true;
				int u = -1;
				int v = -1;
				for(int j=1;j<=s && can;j++)
				{
					u = x+j*dx[i];
					v = y+j*dy[i];
					//System.out.println(u+" - "+v+" -- "+x+" - "+y);
					can&=canGo(u, v);
				}
				//System.out.println(can);
				if(can)
				{
					if(!visited[u][v][s])
					{
						visited[u][v][s] = true;
                                               // System.out.println("Add "+u+" - "+v+" - "+s);
                                                steps[u][v][s%mo+1] = steps[x][y][s]+1 ;
						qX.offer(u);
						qY.offer(v);
						qS.offer(s%mo+1);
					}
				}
			}
		}
			
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		while(cases-->0)
		{
			String[] read = in.readLine().split("[ ]+");
			n = Integer.parseInt(read[0]);
			m = Integer.parseInt(read[1]);
			grid = new char[n][m];
			visited = new boolean[n][m][4];
			steps = new int[n][m][4];
			
			for(int i=0;i<n;i++)
				grid[i] = in.readLine().toCharArray();
			
			int answer = BFS();
			System.out.println(answer>0?answer:"NO");
		}
		in.close();
		System.exit(0);
	}
}