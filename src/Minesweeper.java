/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */

public class Minesweeper {

	static int[][] count;
	static char[][] grid;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
	static int n;
	static int m;
	
	public static boolean isForCount(int i, int j){
		return i>=0 && i<n && j>=0 && j<m && grid[i][j] != '*';
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] read;
		int curr = 1;
		int ii = 0;
		int jj = 0;
		boolean first = true;
		while(true)
		{
			read = in.readLine().split("[ ]+");
			n = Integer.parseInt(read[0]);
			m = Integer.parseInt(read[1]);
			if(n == 0 && m == 0)break;
			if(!first)System.out.println();
			first = false;
			count = new int[n][m];
			grid = new char[n][m];
			for(int i=0;i<n;i++)
			grid[i] = in.readLine().toCharArray();
			
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					if(grid[i][j] == '*')
					{
						for(int k = 0;k<dx.length;k++)
						{
							ii = i + dx[k];
							jj = j + dy[k];
							if(isForCount(ii, jj))
							count[ii][jj]++;
						}
					}
			
			System.out.println("Field #"+curr+":");
			curr++;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				if(grid[i][j] == '*')
				System.out.print('*');
				else System.out.print(count[i][j]);
				System.out.println();
			}
			
		}
		in.close();
		System.exit(0);
	}
}