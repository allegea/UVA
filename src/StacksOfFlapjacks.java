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
public class StacksOfFlapjacks
{
	public static void swap(int[] v, int j, int i)
	{
		int h = v[j];
		v[j] = v[i];
		v[i] = h;
	}
	public static void flip(int[] v, int i)
	{
		for(int j = 0 ; j <= i/2; j++)
			swap(v, j, i - j);
			
		//System.out.println(i + " - "+Arrays.toString(v));
	}
	
	public static int find(int[] v, int x, int i)
	{
		for( ; i >= 0; i--)
			if(v[i] == x)
				return i;
				
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringBuilder answer;
		StringTokenizer st;
		int[] values, sorted;
		int n;
		
		while(( line = in.readLine()) != null)
		{
			st = new StringTokenizer(line);
			n = st.countTokens();
			values = new int[n];
			sorted = new int[n];
			answer = new StringBuilder();
			int pos = 0;
			while(st.hasMoreTokens())
			{
				int u = Integer.parseInt(st.nextToken());
				values[pos] = u;
				sorted[pos++] = u;
			}
			
			Arrays.sort(sorted);
			pos = n - 1;
			while(pos >= 0 && sorted[pos] == values[pos])pos--;
			
			while(pos > 0)
			{
				
				int search = sorted[pos];
				int f = find(values, search, pos);
                                //System.out.println("F - "+pos + " - "+search+" - "+f);
				if(f == pos)
				{
					pos--;
					continue;
				}
				if(f != 0)
				{
					flip(values, f);
					answer.append(n - f).append(" ");
                                       // System.out.println(n-f);
				}
				
				flip(values, pos);
				answer.append(n - pos).append(" ");
				pos--;
			}
			answer.append("0");
                        System.out.println(line);
			System.out.println(answer);
			
		}
		
	}
}