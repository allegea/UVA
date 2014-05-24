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
public class SimplySintax{


	public static final char[] valids = {'C', 'D', 'E', 'I'};
	public static boolean UpperValidC(char c)
	{
		for(int i = 0; i < valids.length; i++)
			if(c == valids[i])
				return true;
		return false;	
	}
	
	public static boolean LowerValidC(char c)
	{
		return (c >= 'p' && c <= 'z');
	}
	
	public static String check(String line)
	{
		boolean answer = true;
		char[] cline = line.toCharArray();
		int n = line.length();
		int count = 0;
		for(int i = n - 1; i >= 0 && answer ; i--)
		{
                       // System.out.println(count);
			if(LowerValidC(cline[i]))
				count++;
			else if(UpperValidC(cline[i]))
			{
				if(count >= 2)
					count--;
				else answer = false;
			}else if(cline[i] == 'N')
			{
				if(count == 0)
				answer = false;
			}else answer = false;
		}
                //System.out.println("f "+count);
		return answer && count == 1?"YES":"NO";
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
                StringTokenizer st = new StringTokenizer("fdsf");
                st.
		while((line = in.readLine()) != null)
			System.out.println(check(line));
		in.close();
		System.exit(0);
	}
}