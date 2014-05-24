/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class SuDoku {

	static int[] row, col;
	static int[][] sectors;
	static int[][] grid;
	static int N, M;
	static boolean found;
	static void BT(int i, int j)
	{
		if(found == true)return;
		if(i == M - 1 && j == M)
		{
			found = true;
			printBoard();	
			return;
		}
		if(j == M){
			i++;
			j = 0;
		}
		//System.out.println(i + " - "+ j );
               // printBoard();
                if(grid[i][j] != 0)
                    BT(i, j + 1);
                else{
		for(int h = 1; h <= M; h++)
			if(canGo(i, j, h))
			{
				BT(i, j + 1);
				clean(i, j, h);
			}
                }
	}
        
        static void printBoard()
        {
            for(int i = 0; i < M; i++)
            {
                    StringBuilder line = new StringBuilder();
                    for(int j = 0; j < M; j++)
                            line.append(grid[i][j]).append(" ");

                    System.out.println(line.toString().trim());

            }
        }
	
	static void preProcessing()
	{
		for(int i = 0; i < M; i++)
			for(int j = 0; j < M; j++)
			{
				sectors[i/N][j/N]|=1<<grid[i][j];
				row[i]|=1<<grid[i][j];
				col[i]|=1<<grid[j][i];
			}
	}
	
	static boolean canGo(int i, int j, int value)
	{
		int newValue = 1<<value;
		if((sectors[i/N][j/N]&newValue) == 0 && (row[i]&newValue) == 0 && (col[j]&newValue) == 0)
		{
			set(i, j, value);
			return true;
		}else return false;
	}
	
	static void set(int i, int j, int value)
	{
		row[i]|=1<<value;
		col[j]|=1<<value;
		sectors[i/N][j/N]|=1<<value;
                grid[i][j] = value;
		
	}
	
	static void clean(int i, int j, int value)
	{
		row[i]^=1<<value;
		col[j]^=1<<value;
		sectors[i/N][j/N]^=1<<value;
                 grid[i][j] = 0;
	}
	
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		boolean noFirst = false;
		while(in.hasNextInt())
		{
			if(noFirst)System.out.println();
			found = false;
			noFirst = true;
			N = in.nextInt();
			M = N*N;
			grid = new int[M][M];
			sectors = new int[N][N];
			row = new int[M];
			col = new int[M];
			for(int i = 0; i < M; i++)
				for(int j = 0; j < M; j++)
					grid[i][j] = in.nextInt();
					
			preProcessing();
			BT(0, 0);
			
			if(!found) System.out.println("NO SOLUTION");	
			
		}
		
		
		in.close();
		System.exit(0);
	}
} 
