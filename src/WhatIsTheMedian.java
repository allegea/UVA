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

class WhatIsTheMedian {

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Long> numbers = new ArrayList<Long>();
		int n = 0;
		while(in.hasNextLong())
		{
			n++;
			numbers.add(in.nextLong());
			Collections.sort(numbers);
			int mid = n/2;
			if(n%2==0)System.out.println((numbers.get(mid-1)+numbers.get(mid))/2);
			else System.out.println(numbers.get(mid));
		}
		in.close();
		System.exit(0);
	}
}