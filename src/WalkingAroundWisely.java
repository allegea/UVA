/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class WalkingAroundWisely {
	
	static HashSet<String>[][] discont;
	static long[][] paths;
	static boolean[][] visit;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	static int N;
	
	static boolean isInside(int i, int j)
	{
		return i>0 && i<=N && j>0 && j<=N;
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(in.readLine());
		String[] read;
		
		while(test-->0)
		{
			N = Integer.parseInt(in.readLine());
			paths = new long[N+1][N+1];
			discont = new HashSet[N+1][N+1];
			visit = new boolean[N+1][N+1];
			
			for(int i=0;i<=N;i++)
				for(int j=0;j<=N;j++)
					discont[i][j] = new HashSet<String>();
			
			read = in.readLine().trim().split("[ ]+");
			int u = Integer.parseInt(read[0]);
			int v = Integer.parseInt(read[1]);
			visit[u][v] = true;
                        paths[u][v]++;
			read = in.readLine().trim().split("[ ]+");
			int uu = Integer.parseInt(read[0]);
			int vv = Integer.parseInt(read[1]);
			
			int m = Integer.parseInt(in.readLine());
			
			for(int i=0;i<m;i++)
			{
				read = in.readLine().trim().split("[ ]+");
				int a = Integer.parseInt(read[0]);
				int b = Integer.parseInt(read[1]);
				if(read[2].equals("N"))
				{
					discont[a][b].add(a+","+(b+1));
					discont[a][b+1].add(a+","+(b));
				}else if(read[2].equals("S"))
				{
					discont[a][b].add(a+","+(b-1));
					discont[a][b-1].add(a+","+(b));
				}else if(read[2].equals("W"))
				{
					discont[a][b].add((a-1)+","+(b));
					discont[a-1][b].add(a+","+(b));
				}else
				{
					discont[a][b].add((a+1)+","+(b));
					discont[a+1][b].add(a+","+(b));
				}				
			}
			
                      //  for(int i=N;i>=1;i--)
                        //    System.out.println(Arrays.toString(discont[i]));
                        
			for(int i=u; i<=uu;i++)
				for(int j=v; j<=vv;j++)
				{
					if(!visit[i][j])continue;
					for(int k=0;k<dx.length;k++)
					{
						int ii = i+dx[k];
						int jj = j+dy[k];
						if(isInside(ii, jj) && !discont[i][j].contains(ii+","+jj))
						{
							paths[ii][jj] += paths[i][j];
							visit[ii][jj] = true;	
						}
					}
				}
			for(int i=N;i>=1;i--)
                            System.out.println(Arrays.toString(paths[i]));
                        
                       // for(int i=N;i>=1;i--)
                           //System.out.println(Arrays.toString(visit[i]));
			System.out.println(paths[uu][vv]);
			
		}
		
		in.close();
		System.exit(0);
		
	}
	

}