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

class  SimplyEmirp {

	static boolean isEmirp(int x, boolean[] noPrime)
	{
		int reverse = 0;
                int aux = x;
		while(aux!=0)
		{
			reverse=reverse*10+aux%10;
			aux/=10;
		}
		if(x != reverse && !noPrime[reverse])return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = 1000000;
		boolean[] noPrime = new boolean[n+1];
		for(int i=3;i*2<=n;i+=2)
			if(!noPrime[i])
				for(int j=i*2;j<=n;j+=i)
					noPrime[j] = true;
		
		
		String line = "";
		while((line = in.readLine())!=null && line.length()>0)
		{
			int x = Integer.parseInt(line);
                       
                        if((x%2 == 0 && x!=2) || noPrime[x])System.out.println(x+" is not prime.");
                        else if(isEmirp(x, noPrime))System.out.println(x+" is emirp.");
			else System.out.println(x+" is prime.");
			
		}
		
		in.close();
		System.exit(0);
	}
}