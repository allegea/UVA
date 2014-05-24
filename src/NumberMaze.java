/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */
public class NumberMaze {

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int N;
	static int M;
	
	static boolean check(int i, int j)
	{
            //System.out.println(i+" - "+j+" - "+ N+" - "+M+" - "+(i >=0 && i<N && j>=0 && j<M));
		return i >=0 && i<N && j>=0 && j<M;
	}
	public static class Edge implements Comparable {
	
		int u;
		int v;
		int w;
		Edge(int uu, int vv, int ww){
			u = uu;
			v = vv;
			w = ww;
		}
		@Override
		public int compareTo(Object o){
			return this.w - ((Edge)o).w; 
		}
                @Override
                public String toString()
                {
                    return u+" * "+v+" * "+w;
                }
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] dist;
		int[][] matriz;
		Queue<Edge> minPath;
		int mazes = Integer.parseInt(in.readLine());
		while(mazes-->0)
		{
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			minPath = new PriorityQueue<Edge>();
			dist = new int[N][M];
			matriz = new int[N][M];
			for(int i=0;i<N;i++)
			{
				String[] row = in.readLine().split("[ ]+");
				for(int j=0;j<M;j++){
				matriz[i][j] = Integer.parseInt(row[j]);
				dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
                        dist[0][0] = matriz[0][0];
			minPath.offer(new Edge(0, 0, dist[0][0]));
			
			
			while(!minPath.isEmpty())
			{
				int uu = minPath.peek().u;
				int vv = minPath.peek().v;
				int ww = minPath.poll().w;
				if(uu == N-1 && vv == M-1)break;
				
                                if(dist[uu][vv] == ww)
				for(int i = 0;i<dx.length;i++)
				{
					int ii = uu + dx[i];
					int jj = vv + dy[i];
					if(check(ii, jj))
					{
						if(dist[ii][jj] > dist[uu][vv]+matriz[ii][jj])
						{
							dist[ii][jj] = dist[uu][vv]+matriz[ii][jj];
							minPath.offer(new Edge(ii, jj, dist[ii][jj]));
						}
					}
				}
                               // System.out.println(uu+" - "+vv+" - "+minPath);
				
			}
			
			/*for(int i=0;i<N;i++)
			System.out.println(Arrays.toString(dist[i]));*/
			
			System.out.println(dist[N-1][M-1]);
			
		}
		
		in.close();
		System.exit(0);
	}
}