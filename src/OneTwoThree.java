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
public class OneTwoThree{

	public static String[] words = {"one","two","three"};
	
	public static int dista(String input)
	{
		for(int i = 0; i < 3; i++)
		{
			int dist = 0;
			int n = input.length();
			int m = words[i].length();
			dist+=Math.abs(n - m);
			for(int j = 0; j < Math.min(n, m); j++)
				if(words[i].charAt(j) != input.charAt(j))
					dist++;
                        //System.out.println(i + " - "+dist + " - "+input);
			if(dist <= 1)
				return i + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(in.readLine());
		while(m-- > 0)
		{
			System.out.println(dista(in.readLine()));
		}
		in.close();
		System.exit(0);
	}

}
