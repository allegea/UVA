/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Alejandro E. Garces
 */
public class  CountTheTrees {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = 300;
		BigInteger[] catalan = new BigInteger[N+1];
		catalan[0] = BigInteger.ONE;
                BigInteger[] fact = new BigInteger[N+1];
                fact[0] = BigInteger.ONE;
                for(int i=1;i<=N;i++)
                    fact[i] = fact[i-1].multiply(new BigInteger(String.valueOf(i)));
                
		for(int i=1;i<=N;i++)
		{
			
                        BigInteger num = new BigInteger(String.valueOf(2*(2*i-1)));
                        BigInteger den = new BigInteger(String.valueOf((i+1)));
			//catalan[i] = (((2*nAux+2)*(2*nAux+1))/((nAux+2)*(nAux+1)))*catalan[i-1];
                        catalan[i] = (num.multiply(catalan[i-1])).divide(den);
			//System.out.println(catalan[i].toString());
		}
		
                while(true)
                {
                    int u = Integer.parseInt(in.readLine());
                    if(u == 0)break;
                    System.out.println(catalan[u].multiply(fact[u]).toString());
                }
		in.close();
		System.exit(0);
	}
}