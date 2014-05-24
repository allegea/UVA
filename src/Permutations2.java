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

public class Permutations2{

	public static void main(String[] args) throws IOException{
	Scanner in = new Scanner(System.in);
	int cases = Integer.parseInt(in.nextLine());
	long[] permu = new long[30];
	permu[0] = 1;
	for(int i=1;i<=29;i++)
	permu[i] = i*permu[i-1];
	ArrayList<Character> letters;
	String answer;
	while(cases-->0)
	{
		char[] array = in.nextLine().toCharArray();
		long n = Long.parseLong(in.nextLine());
		Arrays.sort(array);
		int m = array.length;
		letters = new ArrayList<Character>();
		for(int i=0;i<m;i++)
		letters.add(array[i]);
		answer = "";
		while(m > 0)
		{
			long x = n/permu[m-1];
			answer+= letters.remove((int)x);
			n-=x*permu[m-1];
			m--;
		}
		System.out.println(answer);
	}
	in.close();
	System.exit(0);
	}
}