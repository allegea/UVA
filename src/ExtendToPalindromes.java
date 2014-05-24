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

public class  ExtendToPalindromes
{
	static int[] kmp;
	static char[] word;
	static int n;
	static void kmpProcess()
	{
		int i, j;
		i = 0;
		j = -1;
		kmp = new int[n + 1];
		kmp[0] = j;
		while( i < n)
		{
			while(j>=0 && word[i] != word[j]) j = kmp[j];
			i++;
			j++;
			kmp[i] = j;
		}
	
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while(true)
		{
			String line = in.readLine();
			if(line == null)break;
			ArrayList<Integer> posLast = new ArrayList<Integer>();
			char[] word = line.toCharArray();
			int n = line.length();
			char last = word[n - 1];
			for( int i = 0; i < n - 1; i ++)if(word[i]==last)posLast.add(i);
			if(posLast.size() == 0)System.out.println(line+""+(new StringBuilder(line.substring(0, n - 1))).reverse().toString());
			else{
				boolean found = false;
				for(int pos:posLast)
				{
					boolean isPalin = true;
					int j = 1;
					for(int i = pos + 1; i < n - 1 && isPalin; i++)
						isPalin = word[i] == word[n - 1 - (j++)];
					if(isPalin)
					{
                                                //System.out.println(pos);
						System.out.println(line+""+(new StringBuilder(line.substring(0, pos))).reverse().toString());
						found  = true;
						break;
					}
				}
				if(!found)
				System.out.println(line+""+(new StringBuilder(line.substring(0, n - 1))).reverse().toString());
			}
		}
	
		in.close();
		System.exit(0);
	}


}

