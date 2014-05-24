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

public class EightQueensChessProblem {

	public static final int N = 92;
	public static final int M = 8;
	public static int size = 0;
	public static int[][] solutions = new int[92 + 1][8];
	public static int visitedRow = 0;
	public static boolean[][] visited = new boolean[M][M];
	public static void BT(int col, int[] sol)
	{
            //System.out.println(row);
		if(col == 8)
		{
			for(int i = 0; i < M; i++)
				solutions[size][i] = sol[i];
                       //System.out.println(size + " - " + Arrays.toString(solutions[size]));
                       
			size++;
		}else{
			
			for(int i = 0; i < 8; i++)
				if( (visitedRow & (1 << i)) == 0 && !checkDiag(i, col))
				{
					visitedRow|=1<<i;
					visited[i][col] = true;
					sol[col] = i + 1;
					BT(col + 1, sol);
					visitedRow^=1<<i;
					visited[i][col] = false;
				}
			
		}
	}
	
	public static boolean checkDiag(int i, int j)
	{
		boolean answer = false;
		int posI = i;
		int posJ = j;
		while(posI >= 0 && posJ >= 0 && !answer)
			answer|=visited[posI--][posJ--];
		
		posI = i;
		posJ = j;
		while(posI >= 0 && posJ < M && !answer)
			answer|=visited[posI--][posJ++];
			
		posI = i;
		posJ = j;
		while(posI < M && posJ < M && !answer)
			answer|=visited[posI++][posJ++];
			
		posI = i;
		posJ = j;
		while(posI < M && posJ >= 0 && !answer)
			answer|=visited[posI++][posJ--];
			
               // System.out.println(i + " - " + j + " - " + answer);
		return answer;
	}
	
	public static void solve(int x, int y)
	{
		//TreeSet<String> toPrint = new TreeSet<String>();
                ArrayList<String> toPrint = new ArrayList<String>();
		System.out.println("SOLN       COLUMN");
		System.out.println(" #      1 2 3 4 5 6 7 8\n");
		for(int i = 0; i < 92; i++)
			if(solutions[i][y - 1] == x)
			{
				String getSol = "";
				for(int j = 0; j < M; j++)
					getSol+=solutions[i][j] + " ";
				
				toPrint.add(getSol.trim());
			}
		
		int pos = 1;
		for(String out:toPrint)
		System.out.printf("%2d      %s\n",(pos++), out);
	}
	public static void main(String[] args) throws IOException{
		BT(0, new int[M]);
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
                boolean noFirst = false;
		while(cases-->0)
		{
                        if(noFirst)System.out.println();
                        noFirst = true;
			int x = in.nextInt();
			int y = in.nextInt();
			solve(x, y);
                        
		}
	}
}