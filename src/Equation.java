/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

class Equation{

	static String answer = "";
	static String input = "";
	static int i = 0;
	static int m = 0;
	static void term()
	{
		char aux;
                //System.out.println("term "+i);
		factor();
		while(i < m && (input.charAt(i) == '+' || input.charAt(i) == '-'))
		{
                        
			aux = input.charAt(i++);
                       // System.out.println("Found "+aux);
			factor();
                        //System.out.println(aux);
			answer+=""+aux;
		}
	}
	
	static void factor()
	{
		char aux;
                 //System.out.println("factor "+i);
		number();
               // if(i < m)
		while(i < m && (input.charAt(i) == '/' || input.charAt(i) == '*'))
		{
			aux = input.charAt(i++);
                        //System.out.println("Found "+aux);
			number();
                       // System.out.println(aux);
			answer+=""+aux;
		}
	}
	
	static void number()
	{
                // System.out.println("number "+i);
                 if(i < m)
		if(Character.isDigit(input.charAt(i)))
		{
                        //System.out.println(input.charAt(i));
			answer+=""+input.charAt(i++);
		}else if(input.charAt(i) == '(')
		{
                        //System.out.println("Found (");
			i++;
			term();
                       // i++;
                        if(input.charAt(i) == ')')i++;
		} 
	}
	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
                boolean nofirts = false;
		String read = "";
                in.readLine();
		while(n-->0)
		{
			read = "";
			input = "";
			while((read = in.readLine()) != null && !read.isEmpty())
			input+=read.charAt(0);
			
			answer = "";
			m = input.length();
                        //System.out.println("I - "+input);
			i = 0;
                        while(i<m)
                        {
                            //System.out.println("M - "+i);
                            term();
                        }
                        if(nofirts)System.out.println();
                        nofirts = true;
			System.out.println(answer);
			
		}
		in.close();
		System.exit(0);
	}
}

/*
1

0
*
8
-
4
*
6
+
4
/
7
*
2

* */