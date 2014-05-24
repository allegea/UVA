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

public class YetAnotherNumberSequence
{
	static int MOD = 10;

	static int[][] multi(int[][] x, int[][] y)
	{
		int[][] result = new int[2][2];
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 2; j++)
			{
				for(int h = 0; h < 2; h++)
					result[i][j]+= ((x[i][h]%MOD)*(y[h][j]%MOD))%MOD;
				result[i][j]%=MOD;
			}
		return result;
	}
	
	static int fastExpo(int[][] init, int n, int a, int b)
	{
		int[][] id = new int[2][2];
		id[0][0] = id[1][1] = 1;
                //System.out.println(Arrays.deepToString(init));
		while(n != 0)
		{
			if(n%2 != 0) id = multi(init, id);
			init = multi(init, init);
			n>>=1;
		}
		//System.out.println(Arrays.deepToString(id));
		return (id[0][0] + id[0][1])%MOD;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(in.readLine());
		StringTokenizer st;
		int[][] start;
		while(c-->0)
		{
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			MOD = 1;
			for(int i = 1; i <= m;i++)MOD*=10;
			
			start = new int[2][2];
			//start[0][1] = start[1][0] = start[1][1] = 1;
                        start[0][1] = start[1][0] = start[1][1] = 1;
			
			System.out.println(fastExpo(start, n, a, b));
		}	
		in.close();
		System.exit(0);
	}
}
