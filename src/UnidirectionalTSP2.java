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
public class UnidirectionalTSP2{

	static int[] dx = {-1, 0, 1};
	static long INF = Long.MAX_VALUE/2;
	public static void main(String[] args) throws IOException
	{
           
                //System.out.println(Integer.parseInt("110", 2));
		Scanner in = new Scanner(System.in);
		int[][] grid;
		long[][] path;
                int[][] rowPos;
		int n, m;
		while(in.hasNext())
		{
			n = in.nextInt();
			m = in.nextInt();
			grid = new int[n][m];
			path = new long[n][m];
                        rowPos = new int[n][m];
			for(int i=0;i<n;i++)
			{
				Arrays.fill(path[i], INF);
                                Arrays.fill(rowPos[i], Integer.MAX_VALUE);
				for(int j=0;j<m-1;j++)
				grid[i][j] = in.nextInt();
                                
                                rowPos[i][m-1] = i;
                                grid[i][m-1] = in.nextInt();
                                path[i][m-1] = (long)grid[i][m-1];
			}
			
			for(int j=m-1;j>=1;j--)
                            for(int i=0;i<n;i++)
				{
				    int pos = rowPos[i][j];
					for(int k=0;k<dx.length;k++)
					{
						int u = (n+i+dx[k])%n;
						if(path[u][j-1] == path[i][j]+grid[u][j-1])
                                                {
                                                    rowPos[u][j-1] = Math.min(i, rowPos[u][j-1]);
                                                }
                                                else if(path[u][j-1] > path[i][j]+grid[u][j-1])
						{
							path[u][j-1] = path[i][j] +grid[u][j-1] ;
                                                        rowPos[u][j-1] = i;
                                                        //pos = u;
                                                        //pos = Math.min(u, pos);
						}
					}
                                       // rowPos[i][j] = pos;
					//path[i][j]+=grid[i][j];
				}
			
			/*for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(path[i]));
                        
                        System.out.println(" ****** ");
                                
                        for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(rowPos[i]));*/
                        
                        int posRow = 0;
                        long value = path[0][0];
                        for(int i=1;i<n;i++)
                        {
                            if(path[i][0] < value)
                            {
                                value = path[i][0];
                                posRow = i;
                            }
                        }
                        
                        String answer = ""+(posRow+1);
                       // System.out.println(answer+" ** ");
                        for(int i=0;i<m-1;i++)
                        {
                           // System.out.println(posRow+" - "+i+" - "+rowPos[posRow][i]);
                            answer += " "+(1+rowPos[posRow][i]);
                            posRow = rowPos[posRow][i];
                        }
                        System.out.println(answer+"\n"+value);
		}
		in.close();
		System.exit(0);
	}
}

/*
6 6
1 2 2 1 1 1
1 1 2 2 1 1
1 1 1 2 2 1
1 1 1 2 2 1
1 1 1 2 1 1
1 1 1 1 2 1
5 4
9 1 9 9
1 9 9 9
9 9 9 9
1 1 1 1
9 9 1 9
* 
1 6 5 6 1 1
6
2 1 5 4
4
 */