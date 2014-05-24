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
public class Scarecrow {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int cases = 0;
		while(cases++ < N)
		{
			int answer = 0;
			boolean prev = false;
			int M = Integer.parseInt(in.readLine());
			char[] field = in.readLine().toCharArray();
			for(int i = 0; i < M; i ++)
			{
				if(prev == true)
				{
					prev = false;
					answer++;
					i++;
				}else if(field[i] == '.')
				{
					if(i + 1 == M)answer++;
					else prev = true;
				}
                               // System.out.println(i + " - " + prev + " - " + answer);
			}
			
			System.out.println("Case " + cases + ": " + answer);
		}
         in.close();
         System.exit(0);
     }
}
