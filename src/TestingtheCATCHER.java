/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */

public class TestingtheCATCHER{
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> numbers;
		int curr = 1;
		boolean first = true;
		int answer = 0;
		int[] states;
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == -1)break;
			numbers = new ArrayList<Integer>();
			numbers.add(n);
			while(true)
			{
				n = Integer.parseInt(in.readLine());
				if(n == -1)break;
				numbers.add(n);
			}
			
			states = new int[numbers.size()];
			if(!first)System.out.println();
			first = false;
			answer = 0;
			for(int i=0;i<numbers.size();i++)
			{
				int max = 0;
				for(int j=0;j<i;j++)
					if(numbers.get(j)>=numbers.get(i))
						max = Math.max(max, states[j]);
						
				states[i] = max + 1;
				answer = Math.max(answer, states[i]);
			}
			//System.out.println(Arrays.toString(states));
			System.out.println("Test #"+curr+":");
			System.out.println("  maximum possible interceptions: "+answer);
			curr++;
		
		}
		in.close();
		System.exit(0);
	}

}