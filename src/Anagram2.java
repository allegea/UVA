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
public class Anagram2{

	public static TreeSet<String> ana;
	public static int N;
	public static char[] letters;
	public static boolean[] used;
	public static void BT(int pos, String anagra)
	{
		if(pos == N)
			ana.add(anagra);
		else{
			for(int i = 0; i < N; i++)
				if(!used[i])
				{
					used[i] = true;
					BT(pos + 1, anagra + letters[i]);
					used[i] = false;
				}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(in.readLine());
		while(m-- > 0)
		{
			ana = new TreeSet<String>();
                        
			letters = in.readLine().toCharArray();
			N = letters.length;
                        used = new boolean[N];
			BT(0, "");
			for(String output:ana)
				System.out.println(output);
		}
		in.close();
		System.exit(0);
	}

}