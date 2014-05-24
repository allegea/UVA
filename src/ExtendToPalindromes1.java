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


public class ExtendToPalindromes1 {

	static int[] kmp;
	static int n, m;
	static String Total, Reversal, Origin;
	public static void kmp()
	{
		kmp = new int[m + 1];
		int i = 0;
		int j = -1;
		kmp[i] = j;
		while( i < m)
		{
                    //System.out.println(i + " - " + j);
			while(j >= 0 && Total.charAt(i) != Total.charAt(j)) j = kmp[j];
			j++;
			i++;
			kmp[i] = j;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			Origin = in.readLine();
			if(Origin == null)break;
			Reversal = (new StringBuilder(Origin)).reverse().toString();
			Total = Reversal + "$" + Origin;
			n = Origin.length();
			m = Total.length();
			kmp();
                        //System.out.println(Arrays.toString(kmp));
                        //System.out.println(n + " - " + m+ " - " +Total );
			System.out.println(Origin + Reversal.substring(kmp[m]));
		}
		in.close();
		System.exit(0);
	}
}