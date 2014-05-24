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

class  GoogleIsFeelingLucky {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int curr = 0;
		StringTokenizer read;
		while(curr++<n)
		{
			String[] names = new String[10];
			int[] rate = new int[10];
			int max = -1;
			for(int i=0;i<10;i++)
			{
				read = new StringTokenizer(in.readLine());
				names[i] = read.nextToken();
				rate[i] = Integer.parseInt(read.nextToken());
				max = Math.max(max, rate[i]);
			}
			
			System.out.println("Case #"+curr+":");
			for(int i=0;i<10;i++)
				if(rate[i] == max)
					System.out.println(names[i]);
		}
		
		in.close();
		System.exit(0);
	}
}