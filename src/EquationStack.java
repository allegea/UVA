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

class EquationStack{

	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
                boolean nofirts = false;
		String read = "";
                String input = "";
                String answer = "";
                in.readLine();
                char aux;
		while(n-->0)
		{
			read = "";
			input = "";
                        answer = "";
			while((read = in.readLine()) != null && !read.isEmpty())
			input+=read.charAt(0);
			
			Stack<Character> S = new Stack<Character>();
                         System.out.println("I - "+input);
                        for(char c:input.toCharArray())
                        {
                            if(c == '(')S.push(c);
                            else if(c == ')')
                            {
                                System.out.println(S);
                                while(S.peek() != '(')
                                    answer+=S.pop();
                                S.pop();
                            }else if(Character.isDigit(c))answer+=c;
                            else{
                                if(S.isEmpty())S.push(c);
                                else{
                                    aux = S.pop();
                                    if(aux == '(')
                                    {
                                        S.push(aux);
                                        S.push(c);
                                        //answer+=c;
                                        continue;
                                    }
                                            
                                    
                                    if(c == '*' || c == '/')
                                    {
                                        if(aux == '+' || aux == '-')
                                        {
                                            S.push(aux);
                                            S.push(c);
                                            //answer+=c;
                                        }else{
                                            
                                            S.push(c);
                                            answer+=aux;
                                        }
                                        
                                    }else 
                                    {
                                        if(aux == '+' || aux == '-')
                                        {
                                            S.push(c);
                                            answer+=aux;
                                        }else{
                                            S.push(c);
                                            //S.push(aux);
                                            fdsfs
                                            answer+=aux;
                                        }
                                    }
                                }
                                
                            }
                        }
                        while(!S.isEmpty())answer+=S.pop();
                       
			
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