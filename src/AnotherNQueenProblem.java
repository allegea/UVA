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

public class  AnotherNQueenProblem{

	static boolean[][] valid;
	static int answer;
	static boolean[] occupedRow;
         static int used;
        static boolean[][] leftD;
        static boolean[][] RightD;
	static int n;
	/*static boolean canLeft(int x, int y)
	{
		int min = Math.min(x, y);
		int i = x-min;
		int j = y-min;
		for(;i<8 && j<8;)
			if(occuped[i++][j++])return false;

		return true;
	}*/
	
	/*static boolean canRight(int x, int y)
	{
		int min = Math.min(x, 7-y);
		int i = x-min;
		int j = y+min;
		for(;i<8 && j>=0;)
			if(occuped[i++][j--])return false;
		return true;
	}*/
	
        static boolean canDiag(int x, int y){
            
            int minl = Math.min(x, (n-1)-y);
            int il = x-minl;
            int jl = y+minl;
            
            int minR = Math.min(x, y);
            int iR = x-minR;
            int jR = y-minR;
            if(leftD[il][jl] || RightD[iR][jR])return false;
            leftD[il][jl] = true;
            RightD[iR][jR] = true;
            return true;
            
        }
        
        static boolean unmark(int x, int y){
            
            int minl = Math.min(x, (n-1)-y);
            int il = x-minl;
            int jl = y+minl;
            
            int minR = Math.min(x, y);
            int iR = x-minR;
            int jR = y-minR;
            leftD[il][jl] = false;
            RightD[iR][jR] = false;
            return true;
            
        }
	static void BT(int col)
	{
		if(col == n)
		{
                        used++;
			return;
		}
		
		for(int i=0;i<n;i++)
		{
			if( valid[i][col] && !occupedRow[i] && canDiag(i, col)/*&& canLeft(i, col) && canRight(i, col)*/)
			{
				occupedRow[i] = true;
				//occuped[i][col] = true;
				BT(col+1);
				occupedRow[i] = false;
				//occuped[i][col] = false;
                                 unmark(i, col);
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		String[] read;
                 int curr = 1;
		while(true)
		{
			n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			valid = new boolean[n][n];
			leftD = new boolean[n][n];
			RightD = new boolean[n][n];
			occupedRow = new boolean[n];
			char[][] grid = new char[n][n];
			for(int i=0;i<n;i++)
			{
				grid[i] = in.readLine().toCharArray();
				for(int j=0;j<n;j++)
					if(grid[i][j] == '.')
					valid[i][j] = true;
				
			}
                        used = 0;           
			BT(0);
            
			System.out.println("Case "+curr+": "+used);
                        //System.out.println(used);
                        curr++;
		
		}
		
		in.close();
		System.exit(0);
	}
}
