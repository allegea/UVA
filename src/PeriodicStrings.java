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

public class  PeriodicStrings
{
	static int[] kmp;
	static char[] word;
	static int n;
	static void kmpPreProcess()
	{
		kmp = new int[n + 1];
		int i = 0;
		int j = -1;
		kmp[0] = j;
		while( i < n)
		{
			while(j >=0 && word[i] != word[j]) j = kmp[j];
			i++;
			j++;
			kmp[i] = j;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(in.readLine());
		
		boolean noFirst = false;
		
		while(c-->0)
		{
			in.readLine();
			if(noFirst)System.out.println();
			noFirst = true;
			String line = in.readLine();
			word = line.toCharArray();
			n = line.length();
			kmpPreProcess();
			int m = kmp[n];
                        //System.out.println(Arrays.toString(kmp) + " - " +m);
			if(m == 0)System.out.println(n);
			else{
				String sub = line.substring(0, n - m);
				int size = sub.length();
				if(n % size != 0) System.out.println(n);
				else{
				
					boolean check = true;
					for(int i = 0; i < n - size && check; i+=size)
                                        {   //System.out.println(line.substring(i, i + size)+"-"+sub + " - "+i+" - "+size);
						check = line.substring(i, i + size).equals(sub);
                                                
                                        }
					
					if(check)System.out.println(size);
					else System.out.println(n);
				}
			}
		}	
		in.close();
		System.exit(0);
	}


}
