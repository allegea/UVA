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
public class PrimeWords {
WA
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String line = "";
         long sum;
         while(( line = in.readLine()) != null)
         {
             sum = 0;
             for(char c:line.toCharArray())
             {
                 int value = 0;
                 if(c <= 'Z')value= (c - 'A') + 27;
                 else value = (c - 'a') + 1;
                 sum+=value;
                 //System.out.println(value);
             }
             BigInteger answer = new BigInteger(String.valueOf(sum));
             System.out.println("It is " + (answer.isProbablePrime(100000000)?"":"not ") +"a prime word.");
         }
         in.close();
         System.exit(0);
     }
}
