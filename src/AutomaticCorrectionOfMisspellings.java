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
public class AutomaticCorrectionOfMisspellings {

	public static String ans = "";
	public static String[] words;
	public static boolean oneLetter(String word, String x)
	{
			if(x.length() == word.length())
			{
				int count = 0;
				for(int i = 0; i < x.length(); i++)
					if(x.charAt(i) != word.charAt(i)) count++;
				//System.out.println(x + " * " + word + " - " + count);
				if(count == 1 )
				{	ans = x;
					return true;
				}
			}
		
		return false;
	}	
	
	public static boolean twoLetters(String word, String x)
	{

			if(x.length() == word.length())
			{
				int count = 0;
				int[] pos = new int[x.length()];
				for(int i = 0; i < x.length(); i++)
					if(x.charAt(i) != word.charAt(i))
						pos[(++count) - 1] = i;
					
				
				if(count == 2 && (pos[1] - pos[0] == 1) && x.charAt(pos[0]) == word.charAt(pos[1])
				&& x.charAt(pos[1]) == word.charAt(pos[0]))
				{	ans = x;
					return true;
				}
			}
		
		return false;
	}
	
	public static boolean oneMoreOrLess(String word, String x)
	{
			if(x.length() == word.length() + 1)
			{
				int count = 0;
				boolean cont = true;
				int more = 0;
				for(int i = 0; i < word.length(); i++)
					if(x.charAt(i + more) != word.charAt(i))
					{
						if(cont){
							cont = false;
							more++;
							i--;
						}else count++;
					}
					
				
				if(count == 0)
				{	ans = x;
					return true;
				}
			}else if(x.length() + 1 == word.length())
			{
				int count = 0;
				boolean cont = true;
				int more = 0;
				for(int i = 0; i < x.length(); i++)
					if(word.charAt(i + more) != x.charAt(i))
					{
						if(cont){
							cont = false;
							more++;
							i--;
						}else count++;
					}
					
				//System.out.println(count + " - " + cont + " - " + more + " - " + x);
				if(count == 0)
				{	ans = x;
					return true;
				}
			}
		
		return false;
	}
    
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> dict = new HashSet<String>();
		int N = Integer.parseInt(in.readLine());
		words = new String[N];
		for(int i = 0; i < N; i ++)
		{
			ans = in.readLine();
			dict.add(ans);
			words[i] = ans;
		}
		
		int M = Integer.parseInt(in.readLine());
		for(int i = 0; i < M; i ++)
		{
			String word = in.readLine();
			 ans = "";
                         String answer = "";
			if(dict.contains(word))
			{
				System.out.println(word +" is correct");
			}else 
                        {
                            for(int j = 0; j < N && answer.isEmpty(); j ++)
                            {
                                String x = words[j];
                                if(oneMoreOrLess(word, x))answer = ans;
                                else if(oneLetter(word, x))answer = ans;
                                else if(twoLetters(word, x))answer = ans;
                            }
                            
                            if(!answer.isEmpty())
                            System.out.println(word + " is a misspelling of " + answer);
                            else System.out.println(word + " is unknown");
                        }
		}
			
		
                in.readLine();
		in.close();
		System.exit(0);
	}
}