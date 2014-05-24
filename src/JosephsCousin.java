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

public class JosephsCousin {

        static int[] primes;
        static int m;
        static int simulate(int x)
        {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for(int i=1;i<=x;i++)numbers.add(i);
            
            int n = 0;
            int pos = 0;
            int size = x;
            while(size > 1)
            {
                pos += primes[n++];
                pos%= size--;
                numbers.remove(pos--);
                
            }
           return numbers.get(0);
        }
	public static void main(String[] args) throws IOException{
		int n = 1000000;
		m = 0;
		primes = new int[n];
		primes[m++] = 1;
		
		BitSet prime = new BitSet();
		
		for(int i=3;i<=n && m<4000;i+=2)
			if(!prime.get(i))
			{
                            //System.out.println(m+" - "+i);
				primes[m++] = i;
                                
				for(int j=i*2;j<=n;j+=i)
				prime.set(j);
			}
		
		Scanner in = new Scanner(System.in);
		
                while(true)
                {
                    int num = in.nextInt();
                    if(num == 0)break;
                    System.out.println(simulate(num));
                }

		in.close();
		System.exit(0);
	}
}