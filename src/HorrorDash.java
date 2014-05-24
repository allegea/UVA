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

class HorrorDash
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int curr = 0;
		while(curr++<n)
		{
			StringTokenizer read = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(read.nextToken());
			int max = 0;
			for(int i = 0;i<m;i++)
				max = Math.max(max, Integer.parseInt(read.nextToken()));
			
			System.out.println("Case "+curr+": "+max);
			
		}
		in.close();
		System.exit(0);
	}
}