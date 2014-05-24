/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class PrimeWords2 {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
       BitSet criba = new BitSet();
       int n = 1000000;
       for( int i = 2; i * i <= n; i++)
           if(!criba.get(i))
               for(int j = i * 2; j <= n; j+=i)
                   criba.set(j);
       /*for( int i = 1; i  <= n; i++)
           if(!criba.get(i) && i % 2 != 0)
               System.out.println(i);*/
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String line = "";
         int sum;
         while(( line = in.readLine()) != null)
         {
             sum = 0;
             for(char c:line.toCharArray())
             {
                 int value = 0;
                 if (Character.isUpperCase(c))value= (c - 'A') + 27;
                 else value = (c - 'a') + 1;
                 sum+=value;
                // System.out.println(value);
             }
            // BigInteger answer = new BigInteger(String.valueOf(sum));
             System.out.println("It is " + (!criba.get(sum)?"":"not ") +"a prime word.");
         }
         in.close();
         System.exit(0);
     }
}
