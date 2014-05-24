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

public class WhatIsTheFrequencyKenneth{

	public static final int N = 27;
	public static int[] upper, lower;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while(( line = in.readLine()) != null)
		{
			int max = 0;
			upper = new int[N];
			lower = new int[N];
			for(char x:line.toCharArray())
				if(Character.isLetter(x))
				{   int fre = 0;	
					if(Character.isUpperCase(x))
						fre = ++upper[x - 65];
					else fre = ++lower[x - 97];
				
					max = Math.max(max, fre);
				}
			StringBuilder answer = new StringBuilder();
			for(int i = 0; i < N; i++)
				if(upper[i] == max)
					answer.append((char)(i + 65));
			for(int i = 0; i < N; i++)
				if(lower[i] == max)
					answer.append((char)(i + 97));
			
			System.out.println(answer + " " + max);
		}
		
	}
}