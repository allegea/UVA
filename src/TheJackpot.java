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

public class TheJackpot {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int n = 0;
		int[] numbers;
		while(true)
		{
			n = in.nextInt();
			if(n == 0)break;
			numbers = new int[n];
			for(int i=0;i<n;i++)
			numbers[i] = in.nextInt();
			
			int answer = -1;
			int dp = 0;
			for(int i=0;i<n;i++)
			{
				dp+=numbers[i];
				if(dp < 0)dp = 0;
				else answer = Math.max(answer, dp);
			}
			
			System.out.println((answer<=0?"Losing streak.":"The maximum winning streak is "+answer+"."));
		}
		in.close();
		System.exit(0);
	}
}