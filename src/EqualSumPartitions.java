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

public class EqualSumPartitions {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int[] values;
		TreeSet<Integer> div;
		while(cases-->0)
		{
			int m = in.nextInt();
			int n = in.nextInt();
			values = new int[n];
			int max = 0;
			div = new TreeSet<Integer>();
			long sum = 0 ;
			for(int i = 0 ; i < n ; i++)
			{
				values[i] = in.nextInt();
				max = Math.max(max, values[i]);
				sum+=values[i];
			}
			
			for(int i = max; i <=sum;i++)
				if(sum%i == 0)div.add(i);
				
                       // System.out.println(div);
			for(int x:div)
			{
				int i = 0;
				int eqSum = 0;
				for(; i < n;i++)
				{
					if(eqSum > x)break;
					if(eqSum == x)eqSum = 0;
					eqSum+=values[i];
				}
				
				if(eqSum == x && i == n)
				{
					System.out.println(m + " " + x);
					break;
				}
			}
		}
		in.close();
		System.exit(0);
	}
}