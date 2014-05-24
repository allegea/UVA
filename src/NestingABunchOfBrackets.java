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

class  NestingABunchOfBrackets{

	static int p = 0;
	static boolean check(String x)
	{
		p = 0;
		char[] array = x.toCharArray();
		int n = x.length();
		Stack<String> st = new Stack<String>();
		for(int i=0; i<n; i++)
		{
                        //System.out.println(st);
                        //System.out.println(i+" - "+p);
			p++;
                        
			char a = array[i];
			if(a == '{' || a == '<' || a == '[')
			{
				st.push(""+a);
			}else if(a=='(')
			{
				if(i+1<n && array[i+1]=='*')
					st.push(""+a+array[++i]);
				else st.push(""+a);
				continue;
			}else if(a == ')' || a == '>' || a == ']' || a == '}')
			{
				if(st.isEmpty())return false;
				String b = st.pop();
				if( a==')' && !b.equals("("))return false;
				if( a=='>' && !b.equals("<"))return false;
				if( a==']' && !b.equals("["))return false;
				if( a=='}' && !b.equals("{"))return false;
			}else if(a == '*')
			{
				if(i+1<n && array[i+1]==')')
				{
					if(st.isEmpty() || !st.pop().equals("(*"))return false;
					i++;
				}
			}
		}
		
		if(!st.isEmpty()){
                    p++;
                    return false;
                }
		return true;
		
	}
    public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line = "";
		while((line = in.readLine())!=null && line.length()>0)
		{
			boolean answer = check(line.trim());
			if(answer)System.out.println("YES");
			else System.out.println("NO "+p);
		}
		in.close();
		System.exit(0);
	}
}