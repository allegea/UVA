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
public class TwoDHieroglyphsDecoder
{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int cases = Integer.parseInt(in.readLine());
		ArrayList<Integer>[] input;
		char[][] grid;
		while(cases-- > 0)
		{
			String line = in.readLine();
			int M = line.length();
			input = new ArrayList[M - 2];
			for(int i = 0; i < M - 2; i ++)
			{
				input[i] = new ArrayList<Integer>();
				for(int j = 0; j < 256; j++)
					input[i].add(j);
			}
			
			grid = new char[10][M];
			int count = 0;
			do{
				grid[count] = line.toCharArray();
				line = in.readLine();
			
			}while(++count < 10);
		
		
		for(int i = 1; i <= 9; i++)
			for(int j = 1; j <= M - 2; j++)
			{
				boolean set = grid[i][j] == '/';
                                //System.out.println(i + " - " + j + "  -  " + M + " - " + grid[i][j] + " - " + input[j - 1]);
				for(int h = 0; h < input[j - 1].size(); h++)
				{
					boolean canGo = (input[j - 1].get(h) / (1 << (i - 1))) % 2 == 0;
					if( canGo != set )
						input[j - 1].remove(h--);
				}
                               // System.out.println(i + " * " + j + "  *  " + M + " - " + grid[i][j] + " - " + input[j - 1]);
			}
                //System.out.println(Arrays.toString(input));
		for(ArrayList<Integer> x:input)
			System.out.print(Character.toChars(x.get(0)));
		System.out.println();
		}
		in.close();
		System.exit(0);
	}

}