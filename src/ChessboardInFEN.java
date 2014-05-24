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

public class ChessboardInFEN {
	
	static int[] dxKnight = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dyKnight = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] dxPeon = {1, 1};
	static int[] dyPeon = {-1, 1};
	static int[] dxKing = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dyKing = {0, 1, 1, 1, 0, -1, -1, -1};
	static char[][] grid;
	static boolean[][] visited;
	
	static boolean canGo(int i, int j)
	{
		return i>=0 && i<8 && j>=0 && j<8 && grid[i][j] == '.';
	}
	
	static void movesTorre(int i, int j)
	{
		for(int ii=i+1;ii<8;ii++)
		  if(canGo(ii, j))visited[ii][j] = true;
		  else break;
		  
		for(int ii=i-1;ii>=0;ii--)
		  if(canGo(ii, j))visited[ii][j] = true;
		  else break;
		  
		for(int ii=j+1;ii<8;ii++)
		  if(canGo(i, ii))visited[i][ii] = true;
		  else break;
		  
		for(int ii=j-1;ii>=0;ii--)
		  if(canGo(i, ii))visited[i][ii] = true;
		  else break;
	}
	
	static void movesAlfil(int i, int j)
	{
		int ii = i-1;
		int jj = j-1;
		while(ii>=0 && jj>=0)
		{
			if(grid[ii][jj] == '.')visited[ii--][jj--] = true;
			else break;
		}
		
		ii = i+1;
		jj = j+1;
		while(ii<8 && jj<8)
		{
			if(grid[ii][jj] == '.')visited[ii++][jj++] = true;
			else break;
		}
		ii = i+1;
		jj = j-1;
		while(ii<8 && jj>=0)
		{
			if(grid[ii][jj] == '.')visited[ii++][jj--] = true;
			else break;
		}
		ii = i-1;
		jj = j+1;
		while(ii>=0 && jj<8)
		{
			if(grid[ii][jj] == '.')visited[ii--][jj++] = true;
			else break;
		}
	}
	
	static void movesQueen(int i, int j)
	{
		movesAlfil(i, j);
		movesTorre(i, j);
	}
	
	static void movesKing(int i, int j)
	{
		for(int ii=0;ii<dxKing.length;ii++)
		{
			int u = i+dxKing[ii];
			int v = j+dyKing[ii];
			if(canGo(u, v))visited[u][v] = true;
		}
	}
	
	static void movesPeon(int i, int j, int dir)
	{
		for(int ii=0;ii<dxPeon.length;ii++)
		{
			int u = i+dxPeon[ii]*dir;
			int v = j+dyPeon[ii];
			if(canGo(u, v))visited[u][v] = true;
		}
	}
	
	static void movesCaballo(int i, int j)
	{
		for(int ii=0;ii<dxKnight.length;ii++)
		{
			int u = i+dxKnight[ii];
			int v = j+dyKnight[ii];
			if(canGo(u, v))visited[u][v] = true;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		String line = "";
		while((line = in.readLine())!=null && line.length()>0)
		{
			read = new StringTokenizer(line, "/");
			visited = new boolean[8][8];
			grid = new char[8][8];
			for(int i=0;i<8;i++)
			{
				char[] aux = read.nextToken().toCharArray();
                                //System.out.println(String.valueOf(aux));
				int pos = 0;
				for(int j=0;j<aux.length;j++)
				{
					if(Character.isDigit(aux[j]))
					{
						int k = pos;
						for(;k<pos+(aux[j]-'0');k++)
						grid[i][k] = '.';
						pos = k;
					}else grid[i][pos++] = aux[j];
				}
                                //System.out.println(String.valueOf(grid[i]));
			}
			
			for(int i=0;i<8;i++)
				for(int j=0;j<8;j++)
				if(grid[i][j] != '.')
				{
					if(grid[i][j] == 'r' || grid[i][j] == 'R')movesTorre(i, j);
					else if(grid[i][j] == 'n' || grid[i][j] == 'N') movesCaballo(i, j);
					else if(grid[i][j] == 'b' || grid[i][j] == 'B') movesAlfil(i, j);
					else if(grid[i][j] == 'q' || grid[i][j] == 'Q') movesQueen(i, j);
					else if(grid[i][j] == 'k' || grid[i][j] == 'K') movesKing(i, j);
					else if(grid[i][j] == 'p') movesPeon(i, j, 1);
					else movesPeon(i, j, -1);
				}
				
			int count = 0;
			for(int i=0;i<8;i++)
				for(int j=0;j<8;j++)
				if(grid[i][j] == '.' && !visited[i][j])
				count++;
			System.out.println(count);
		}
	}

}