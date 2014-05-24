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

class ParenthesesBalance {

	static boolean check(String x)
	{
		if(x.length() == 0)return true;
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<x.length();i++)
		{
			char y = x.charAt(i);
			if(y == '(' || y == '[')st.push(y);
			else
			{
				if(st.isEmpty())return false;
                                char z = st.pop();
				if(y == ')' && z != '(') return false;
				if(y == ']' && z != '[') return false;
			}
		
		}
		
		if(!st.isEmpty())return false;
		return true;
		
	
	}
	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		while(n-->0)System.out.println((check(in.readLine())?"Yes":"No"));

		in.close();
		System.exit(0);
                
	}
}