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

public class DoYourOwnHomework {

	public static String[] answers = {"Yesss", "Late", "Do your own homework!" };
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int cases = 0;
		HashMap<String, Integer> map;
		StringTokenizer st;
		int posAnswer = 0;
		while(cases++ < N)
		{
			int M = Integer.parseInt(in.readLine());
			map = new HashMap<String, Integer>();
			for(int i = 0; i < M; i++)
			{
				st = new StringTokenizer(in.readLine());
				map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
			}
			int D = Integer.parseInt(in.readLine());
			String name = in.readLine();
			if(map.containsKey(name))
			{
				int value = map.get(name);
				if(value <= D) posAnswer = 0;
				else if(value <= D + 5)posAnswer = 1;
				else posAnswer = 2;
                                
                               // System.out.println(value + " - " + D + " - " + posAnswer);
			}else posAnswer = 2;
			
			System.out.println("Case " + cases + ": " + answers[posAnswer]);
			
		}
		in.close();
		System.exit(0);
	}
}