/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Alejandro E. Garces
 */
public class  HowManyTrees {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = 20;
		BigInteger[] catalan = new BigInteger[N+1];
		catalan[0] = BigInteger.ONE;
                Scanner x;

		for(int i=1;i<=N;i++)
		{
			BigInteger a = new BigInteger(String.valueOf(2*(2*i-1)));
			BigInteger b = new BigInteger(String.valueOf(i+1));
			catalan[i] = (a.multiply(catalan[i-1])).divide(b);
                        System.out.println(catalan[i].toString());
		}
                
                String line = "";
                while( (line = in.readLine()) != null)
                {
                    int u = Integer.parseInt(line);
                    System.out.println(catalan[u]);
                }
                       

		
		in.close();
		System.exit(0);
	}
}