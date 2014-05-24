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

public class AllIntegerAverage {
	
	static int GCD(int x, int y)
	{
		if(y == 0)return x;
		return GCD(y, x%y);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = 1;
		StringTokenizer sT;
		int cases;
		while(true)
		{
			sT = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(sT.nextToken());
			if(n == 0)break;
			int sum = 0;
			for(int i = 0; i < n; i++)
				sum+= Integer.parseInt(sT.nextToken());
			System.out.println("Case "+ cases + ":");
			cases++;
			
		}
		
		in.close();
		System.exit(0);
	}
}