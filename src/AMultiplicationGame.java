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

public class  AMultiplicationGame{

	public static long goal;
	public static int solve(int turn, long curr)
	{
		if(curr >= goal)return 1 - turn;
		else{
			int wins = solve(1 - turn, curr * 2);
			if(wins != turn)return solve(1 - turn, curr * 9);
			return wins;
		}
	}
	public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line  = in.readLine()) != null)
		{
			goal = Long.parseLong(line);
			System.out.println( (solve(0, 1l) == 0?"Stan ":"Ollie ") + "wins.");
		}
         in.close();
         System.exit(0);
     }

}