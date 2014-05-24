/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */

public class ThePathInTheColoredField {

	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		boolean[][] visited;
		char[][] grid;
		int[][] steps;
		Queue<Integer> qX;
		Queue<Integer> qY;
                HashSet<Integer> paths;
                int[][] prev;
		while((line = in.readLine()) != null && line.length() > 0)
		{
			int n = Integer.parseInt(line);
			
			grid = new char[n][n];
			//steps = new int[n][n];
                       // prev = new int[n][n];
			//qX = new LinkedList<Integer>();
			//qY = new LinkedList<Integer>();
                       // visited = new boolean[n][n];
                        paths = new HashSet<Integer>();
			for(int i=0;i<n;i++)
				grid[i] = in.readLine().toCharArray();
				
                       
                        int pp = 1;
                        int answer = 0;
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(grid[i][j] == '1')
					{
						
                                                steps = new int[n][n];
                                                prev = new int[n][n];
                                                qX = new LinkedList<Integer>();
                                                qY = new LinkedList<Integer>();
                                                visited = new boolean[n][n];
						visited[i][j]=true;
                                                prev[i][j] = pp++;
                                                qX.offer(i);
						qY.offer(j);
                                                while(!qX.isEmpty())
                                                {
                                                    int x = qX.poll();
                                                    int y = qY.poll();
                                                    if(grid[x][y] == '3')
                                                    {
                                                           // if(paths.add(prev[i][j]))
                                                           // System.out.println(i+" - "+j+" -- "+x+" - "+y+" | "+steps[x][y]);
                                                            answer = Math.max(answer, steps[x][y]);
                                                            break;
                                                    }

                                                    for(int ii=0;ii<4;ii++)
                                                    {
                                                            int u = x+dx[ii];
                                                            int v = y+dy[ii];
                                                            if(u>=0 && u<n && v>=0 && v<n && !visited[u][v])
                                                            {

                                                                    steps[u][v] = steps[x][y]+1;
                                                                    prev[u][v] = prev[x][y];
                                                                    visited[u][v]=true;
                                                                    qX.offer(u);
                                                                    qY.offer(v);
                                                            }
                                                    }
                                                }
					}
			
			
			
			
			System.out.println(answer);
			
		}
		in.close();
		System.exit(0);
	}
}
