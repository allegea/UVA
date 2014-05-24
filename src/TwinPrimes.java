/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class TwinPrimes
{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = 20000000;
		BitSet primes = new BitSet();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<String> couples = new ArrayList<String>();
		//primes[1] = true;
		for(int i=2;i*i<=n;i++)
			if(!primes.get(i))
			{
				
				for(int j=i*i;j<=n;j+=i)
					primes.set(j);
			}
                for(int i=1;i<=n;i++)
                    if(!primes.get(i))
                        numbers.add(i);

		for(int i=2;i<numbers.size();i++)
		{
			int u = numbers.get(i-1);
			int v = numbers.get(i);
			if(v - u == 2)
			couples.add("("+u+", "+v+")");
		}
		
		String line = "";
		while((line = in.readLine()) != null)
		{
			
			int u = Integer.parseInt(line);
			System.out.println(couples.get(u-1));
		}
		
		in.close();
		System.exit(0);
				
	}
}
