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

public class BombsNOTheyAreMines{
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int n, m;
	static boolean[][] bomb;
	static boolean[][] visited;
	static boolean continueCell(int i, int j)
	{
		return i>=0 && i<n && j>=0 && j<m && !visited[i][j] && !bomb[i][j];
	}
	
	public static int BFS(int ix, int iy, int jx, int jy)
	{
		int answer = 0;
               // System.out.println(ix+" - "+iy+" * "+jx+" - "+jy);
		Queue<Integer> qX = new LinkedList<Integer>();
		Queue<Integer> qY = new LinkedList<Integer>();
		Queue<Integer> steps = new LinkedList<Integer>();
		qX.offer(ix);
		qY.offer(iy);
		steps.offer(0);
                /*for(int i=0;i<n;i++)
                    System.out.println(Arrays.toString(bomb[i]));*/
                
             
                
                
		while(!qX.isEmpty())
		{
			int x = qX.poll();
			int y = qY.poll();
			int s = steps.poll();
                       // System.out.println(x+" - "+y+" - "+s);
			if(x == jx && y == jy)
			return s;
			
			for(int i=0;i<4;i++)
			{
				int u = x+dx[i];
				int v = y+dy[i];
				if(continueCell(u, v))
				{
					visited[u][v] = true;
					qX.offer(u);
					qY.offer(v);
					steps.offer(s+1);
					
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner in = new Scanner(System.in);
		while(true)
		{
                        String[] read = in.readLine().split("[ ]+");
			n = Integer.parseInt(read[0]);
			m = Integer.parseInt(read[1]);
			if(n == 0 && m == 0)break;
                        
			bomb = new boolean[n][m];
			visited = new boolean[n][m];
			int bombs = Integer.parseInt(in.readLine());
			for(int i=0;i<bombs;i++)
			{
                                read = in.readLine().split("[ ]+");
				int r = Integer.parseInt(read[0]);
				int ii = Integer.parseInt(read[1]);
				for(int j=0;j<ii;j++)
				bomb[r][Integer.parseInt(read[j+2])] = true;
			}
                        
                         read = in.readLine().split("[ ]+");
                         int a = Integer.parseInt(read[0]);
                         int b = Integer.parseInt(read[1]);
                         read = in.readLine().split("[ ]+");
                         int c = Integer.parseInt(read[0]);
                         int d = Integer.parseInt(read[1]);
			 System.out.println(BFS(a, b, c, d));
		}
		
		in.close();
		System.exit(0);
	}
}