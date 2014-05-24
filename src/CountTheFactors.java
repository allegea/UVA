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

public class CountTheFactors
{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = 1000000;
		int[] sieve = new int[n + 1];
		sieve[1] = 1;
		for(int i = 2; i  <= n; i++)
			if(sieve[i] == 0)
			{
				sieve[i]++;
				for(int j = i * 2; j <= n; j+=i)sieve[j]++;
			}
		
		while(true)
		{
			int x = Integer.parseInt(in.readLine());
			if(x == 0)break;
			System.out.println(x + " : " + sieve[x]);
		}
	
		in.close();
		System.exit(0);
	}
}