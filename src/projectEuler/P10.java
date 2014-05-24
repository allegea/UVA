/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uva.projectEuler;
import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;



/**
 *
 * @author allegea
 */
public class P10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
         //BufferedReader in   = new BufferedReader(new FileReader("triangulo.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        int n=2000000;   
        BitSet primes = new BitSet();
        
        for(int i=2;i*i<=n;i++)
            if(!primes.get(i))
                for(int j=2*i;j<=n;j+=i)
                    primes.set(j);
                
       long sum = 0;
        for(int j=2;j<=n;j++)
            if(!primes.get(j))sum+=j;
        
        System.out.println(sum);
        
        
       /* public Problem()
	{
		BigInteger sum = BigInteger.ZERO;
		for (BigInteger num = BigInteger.valueOf(2); num.compareTo(BigInteger.valueOf(1000000)) < 0; num = num.nextProbablePrime())
			sum = sum.add(num);
		System.out.println(sum.toString());
	}*/

        
    }
}
