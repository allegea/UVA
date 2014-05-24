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

public class   PowerStrings
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
			if(line.charAt(0) == '.')break;
			n = line.length();
			word = line.toCharArray();
			kmpProcess();
			int m = kmp[n];
                        System.out.println(Arrays.toString(kmp));
			if(m == 0)System.out.println(1);
			else{
				String sub = line.substring(0, n - m); 
				int size = sub.length();
				if(n % size != 0)System.out.println(1);
				else{
					boolean check = true;
					for(int i = 0; i < n - size && check; i+=size)
					{
						check = line.substring(i, i + size).equals(sub);
					}
					if(check)System.out.println(n/size);
					else System.out.println(1);
				
				}
			}
		}
	
		in.close();
		System.exit(0);
	}


}
