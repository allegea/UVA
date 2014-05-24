/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uva.projectEuler;
import java.io.*;
import java.math.BigInteger;



/**
 *
 * @author allegea
 */
public class P25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
         //BufferedReader in   = new BufferedReader(new FileReader("triangulo.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BigInteger upper = new BigInteger("10");
        upper = upper.pow(999);
        
        BigInteger fibo1 = new BigInteger("1");
        BigInteger fibo2 = new BigInteger("1");
        BigInteger fibo = fibo1.add(fibo2);
        
        int count = 3;
        while(upper.compareTo(fibo)==1){
             //System.out.println(fibo);
            fibo1=fibo2;
            fibo2=fibo;
            fibo = fibo1.add(fibo2);
            count++;
        }
        
        System.out.println(count + " - "+fibo);

        /*Saying that a number contains 1000 digits is the same as
saying that it's greater than 10**999.

The nth Fibonacci number is [phi**n / sqrt(5)], where the
brackets denote "nearest integer".

So we need phi**n/sqrt(5) > 10**999

n * log(phi) - log(5)/2 > 999 * log(10)

n * log(phi) > 999 * log(10) + log(5)/2
n > (999 * log(10) + log(5) / 2) / log(phi)

A handheld calculator shows the right hand side to be
4781.8593, so 4782 is the first integer n with the
desired property.

Why bother with a computer on this one?*/
        
        
        
        /*Fibonacci terms converge to (n)*Phi=(n+1), where Phi is the
 Golden Ratio (1+sqrt5)/2.
I reasoned that there is an nth term that is smaller than 10^999
 with the corresponding nth+1 term bigger than 10^999.
So, using the binary splitting method for searching, I used
 the MS calculator and found Phi^4780<10^999 and Phi^4781>10^999.
Since the two initial terms of the series have the same value
 by definition, you have to add one to the exponents found.
No code necessary.
Rudy.*/
        
    }
}
