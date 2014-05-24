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

public class SecretWord {
    static int[] kmp;
    static char[] newWord;
    static void kmpPre(int n)
    {
        int  j = -1;
        int i = 0;
        kmp[0] = j;
        while(i < n)
        {
            while(j >= 0 && newWord[i] != newWord[j]) j = kmp[j];
            i++;
            kmp[i] = ++j;
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		while(n-- > 0)
		{
			String word = in.readLine();
			int m = word.length();
			word = word + "$" + (new StringBuilder(word)).reverse().toString();
                        //System.out.println(word+"**");
			newWord = word.toCharArray();
			int newM = word.length();
			kmp = new int[newM + 1];
			/*int j = 0;
			kmp[j] = 0;
			for(int i = 1; i < newM; i++)
			{
                                //System.out.println(i + " - " + newWord[i] + " - "+j + " - " + kmp[j] + " - " + newWord[j]);
				if(newWord[i] == newWord[j])
					kmp[i] = ++j;
				else kmp[j] = j;
			}
			
			System.out.println(Arrays.toString(kmp));
                        kmp = new int[newM + 1];
                        
                        //System.out.println("*"+Arrays.toString(kmp));*/
                        kmpPre(newM);
                        System.out.println("*"+Arrays.toString(kmp));
			int max = 0;
                        //System.out.println(word.charAt(m));
			for(int i = m + 1; i <= newM; i++)
				max = Math.max(max, kmp[i]);
			System.out.println(word.substring(newM - max));
		}
		in.close();
		System.exit(0);
	
	}
}