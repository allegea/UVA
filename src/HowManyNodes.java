/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */

public class  HowManyNodes {

	public static void main(String[] args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		int N = 20;
		long[] catalan = new long[N+1];
		catalan[0] = 1;
		for(int i=1;i<=N;i++)
		{
			catalan[i] = (2*(2*i-1)*catalan[i-1])/(i+1);
		}

		String line = "";
		while(( line = in.readLine()) != null)
		{
			long trees = Long.parseLong(line);
                        int answer = Arrays.binarySearch(catalan, trees);
                        System.out.println(answer>=0?answer:-answer-1);

		}
		
		in.close();
		System.exit(0);
	}
}

