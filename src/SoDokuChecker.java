/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class SoDokuChecker {
	static int[] row;
	static int[] col;
	static int[][] board;
	static int[][] sectors;
	static final int N = 9;
        static final int M = 3;
	static int solutions;
	
	static boolean canGo(int i, int j, int value)
	{
		int newValue = 1<<value;
		if(((row[i]&newValue) == 0) && ((col[j]&newValue) == 0) && (sectors[i/M][j/M]&newValue) == 0)
		{
			set(i, j, value);
			return true;
		}
            return false;
	}
	
	static void set(int i, int j, int value)
	{
		board[i][j] = value;
		sectors[i/M][j/M]|=1<<value;
		row[i]|=1<<value;
		col[j]|=1<<value;
	}
	
	static void clear(int i, int j, int value)
	{
		board[i][j] = 0;
		sectors[i/M][j/M]^=1<<value;
		row[i]^=1<<value;
		col[j]^=1<<value;
	}
	
	static boolean preProcessing()
	{
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				if(board[i][j] == 0)continue;
				if(!canGo(i, j, board[i][j]))return false;
			}
		return true;
	}
	
	static void BT(int i, int j)
	{
		if(solutions > 1)return;
		if(i == N - 1 && j == N){
			solutions++;
			return;
		}
		
		if(j == N){
			i++;
			j = 0;
		}
		
		if(board[i][j] == 0)
		{
			for(int h = 1; h <= N; h++)
				if(canGo(i, j, h))
				{
					BT(i, j + 1);
					clear(i, j, h);
				}
		}else BT(i, j + 1);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder output = new StringBuilder();
		//Scanner in = new Scanner(System.in);
            String line = "";
            StringTokenizer sT;
		int cases = 1;
                while(( line = in.readLine()) != null && line.length() > 0)
		//while(in.hasNextInt())
		{
			row = new int[N]; 
			col = new int[N];
			board = new int[N][N];
			sectors = new int[N/3][N/3];
			solutions = 0;
			for(int i = 0; i < N; i++)
                        {   sT = new StringTokenizer(line);
                            line = in.readLine();
                            for(int j = 0; j < N; j++)
                                board[i][j] = Integer.parseInt(sT.nextToken());
                                //board[i][j] = in.nextInt();
                            
                        }
                        if(!preProcessing())output.append("Case ").append(cases).append(": Illegal.").append("\n");
			else{
				BT(0, 0);
				if(solutions == 1)output.append("Case ").append(cases).append(": Unique.").append("\n");
				else if(solutions == 0)output.append("Case ").append(cases).append(": Impossible.").append("\n");
				else output.append("Case ").append(cases).append(": Ambiguous.").append("\n");
			}
			cases++;
			
		}
		System.out.print(output);
		in.close();
		System.exit(0);
	}
}

