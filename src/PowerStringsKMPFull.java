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

public class   PowerStringsKMPFull
{
	static int[] kmp;
	static char[] word;
	static int n, m;
	static void kmpProcess()
	{
		int i, j;
		i = 0;
		j = -1;
		kmp = new int[m + 1];
		kmp[0] = j;
		while( i < n)
		{
			while(j>=0 && word[i] != word[j]) j = kmp[j];
			i++;
			j++;
			kmp[i] = j;
		}
                
                //System.out.println(Arrays.toString(kmp));
	
	}
        
        static int kmpSearch(char[] newWord)
        {
            int i, j;
            j = kmp[n];
            i = n;
            while ( i < m)
            {
                //System.out.println(i + " - "+j);
                while(j >= 0 && word[i] != newWord[j]) j = kmp[j];
                i++;
                j++;
                
                if(j == n)
                {
                    return n/(i - j);
                }
                
            }
            return 0;
            
            
            
        }
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String line = in.readLine();
			if(line.charAt(0) == '.')break;
			n = line.length();
                        m = 2 * n;
                        String concat = line + line;
			word = concat.toCharArray();
			kmpProcess();
                        System.out.println(kmpSearch(line.toCharArray()));
			
		}
	
		in.close();
		System.exit(0);
	}


}
