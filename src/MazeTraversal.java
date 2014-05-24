/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alejandro E. Garces
 */
public class MazeTraversal {

	static char[][] grid;
	static boolean[] visited;
	static char[] orien = {'N','E','S','W'};
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	static char curr = 'N';
	static boolean isInside(int i, int j)
	{
		return i>=0 && i<N && j>=0 && j<M && grid[i][j] != '*';
	}
	
	static int[] nextMove(char M)
	{
		if(M == 'F')
		{
			if(curr == 'N')return new int[]{-1,0};
			else if(curr == 'E')return new int[]{0,1};
			else if(curr == 'S')return new int[]{1,0};
			else return new int[]{0,-1};
		}else if(M == 'R')
		{
			if(curr == 'N')curr = 'E';
			else if(curr == 'E')curr = 'S';
			else if(curr == 'S')curr = 'W';
			else curr = 'N';
			return new int[]{0, 0};
		}else if(M == 'L'){
			if(curr == 'N')curr = 'W';
			else if(curr == 'W')curr = 'S';
			else if(curr == 'S')curr = 'E';
			else curr = 'N';
			return new int[]{0, 0};
		}else return new int[]{0, 0};

	}
	
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
                boolean first = true;
		while(test-->0)
		{
                        
                        if(!first)System.out.println();
                        first = false;
			N = in.nextInt();
			M = in.nextInt();

			grid = new char[N][M];
                        in.nextLine();
			for(int i=0;i<N;i++)
                        {
                            grid[i] = in.nextLine().toCharArray();
                           //  System.out.print(grid[i]);
                            // System.out.println(" - "+i);
                        }
                        
			
                       // System.out.println(N + " - "+M);
                       
			int u = in.nextInt()-1;
			int v = in.nextInt()-1;
			curr = 'N';
                        boolean noExit = true;
			while(noExit)
			{
                                char[] line = in.next().toCharArray();
                               // System.out.println(line);
                                
                                for(int k=0;k<line.length;k++)
                                {
                                    char command = line[k];
                                    if(command == 'Q')
                                    {
                                            System.out.println((u+1)+" "+(v+1)+" "+curr);
                                            noExit = false;
                                            break;
                                    }

                                    int[] next = nextMove(command);
                                    
                                  //  System.out.println(Arrays.toString(next)+" "+u+" - "+v+" - "+curr+" - "+command);
                                    int i = u+next[0];
                                    int j = v+next[1];
                                    if(isInside(i, j))
                                    {
                                            u = i;
                                            v = j;
                                    }
                                }
				
			}
			
		}
		in.close();
		System.exit(0);
	}
}