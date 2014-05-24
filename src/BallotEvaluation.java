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
public class BallotEvaluation {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = 0;
                StringBuilder out = new StringBuilder();
		StringTokenizer st;
		HashMap<String, Long> map = new HashMap<String, Long>();
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		while(N-- > 0)
		{
			st = new StringTokenizer(in.readLine());
			String x = st.nextToken();
			long y = (long)(Float.parseFloat(st.nextToken()) * 10);
			map.put(x, y);
			
		}
		//System.out.println(map);
		while( cases++ < M )
		{
			st = new StringTokenizer(in.readLine());
			long guess = 0;
			while(true)
			{
				String x = st.nextToken();
				if(x.charAt(0) == '<' || x.charAt(0) == '>' || x.charAt(0) == '=')
				{
					boolean answer = false;
					long equal = Long.parseLong(st.nextToken()) * 10;
					if(x.equals("<")) answer = guess < equal;
					else if(x.equals("<=")) answer = guess <= equal;
					else if(x.equals(">")) answer = guess > equal;
					else if(x.equals(">=")) answer = guess >= equal;
					else  answer = guess == equal;
					
                                        String prefix = "";
                                        if(!answer)prefix = "in";
                                        out.append("Guess #").append(cases).append(" was ").append(prefix).append("correct.\n");
					//System.out.println("Guess #" + cases + " was " + (answer?"correct.":"incorrect."));
					break;
					
				}else if(x.charAt(0) != '+')
				guess += map.get(x);
			}

		}
                System.out.print(out);
		in.close();
		System.exit(0);
	}
}