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
class  DigitCounting {

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		while(n-->0)
		{
			int m = Integer.parseInt(in.readLine());
			int[] fre = new int[10];
			StringBuilder test = new StringBuilder();
			for(int i=1;i<=m;i++)
				test.append(String.valueOf(i));
				
			char[] numbers = test.toString().toCharArray();
			for(char x:numbers)
				fre[x-'0']++;
			
			String answer = "";
			for(int i=0;i<9;i++)
				answer+=fre[i]+" ";
			answer+=fre[9];
			System.out.println(answer);
		}
		
		in.close();
		System.exit(0);
	}
}