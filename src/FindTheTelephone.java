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
public class FindTheTelephone{

    
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
                HashMap<Character, Character> map = new HashMap<Character, Character>();
                for(char a = 'A'; a <= 'Z'; a++)
                    map.put(a, (char)(((a - 'A') / 3 ) + '2'));
                
                 map.put('S', '7');
                 map.put('T', '8');
                 map.put('U', '8');
                 map.put('V', '8');
                 map.put('W', '9');
                 map.put('X', '9');
                 map.put('Y', '9');
                 map.put('Z', '9');
		while( (line = in.readLine() ) != null)
		{
			char[] answer = line.toCharArray();
			for(int i = 0; i < answer.length; i++)
				if(Character.isLetter(answer[i]))
				answer[i] = map.get(answer[i]);
			System.out.println(String.valueOf(answer));
				
		}
		in.close();
		System.exit(0);
	}

}
