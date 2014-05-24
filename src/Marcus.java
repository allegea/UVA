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

public class Marcus {

	static char[][] grid;
	static int[] dx = {-1, 0, 0};
	static int[] dy = {0, 1, -1};
	static String[] steps = {"forth", "right" , "left"};
	static char[] iehova = "IEHOVA#".toCharArray();
	static int n;
	static int m;
	static boolean answer;
	
	public static boolean forContinue(int i, int j, char x){
		return i>=0 && i<n && j>=0 && j<m && grid[i][j] == x;
	}
	
	public static void BT(String toPrint, int i, int j, int k)
	{
		if(answer)return;
		if(k == 7){
		System.out.println(toPrint.trim());
		answer = true;
		return;
		}
		for(int ii=0;ii<dx.length;ii++)
		{
			int uu = i+dx[ii];
			int jj = j+dy[ii];
			if(forContinue(uu, jj, iehova[k]))
			{
				BT(toPrint+" "+steps[ii], uu, jj, k+1);
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] read;
		int tests = Integer.parseInt(in.readLine());
		boolean first = true;
		while(tests-->0)
		{
			read = in.readLine().split("[ ]+");
			n = Integer.parseInt(read[0]);
			m = Integer.parseInt(read[1]);
			grid = new char[n][m];
			for(int i=0;i<n;i++)
			grid[i] = in.readLine().toCharArray();
			answer = false;
			for(int i=0;i<m;i++)
				if(grid[n-1][i] == '@'){
				BT("", n-1, i, 0);
				break;
				}
			

			
		}
		in.close();
		System.exit(0);
	}
}