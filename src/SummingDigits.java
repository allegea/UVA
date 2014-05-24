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

class SummingDigits
{
	static int f(int n)
	{
		int sum = 0;
		while(n != 0)
		{
			sum+=n%10;
			n/=10;
		}
		return sum;
	}
	
	static int g(int n)
	{
		while(n >= 10)n = f(n);
		return n;
	}
        
        static int g2(int n)
	{
                int answer = n%9;
		if(answer == 0)answer = 9;
		return answer;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = 2000000000;
		while(true)
		{
			int x = Integer.parseInt(in.readLine());
			if(x == 0)break;
			System.out.println(g2(x));
		}
		in.close();
		System.exit(0);
	
	}
	

}