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
public class Overflow {
    
   public static long max = (1l<<31) - 1;
   public static final BigInteger MAX = new BigInteger(String.valueOf(max)); 

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String line = "";
         StringTokenizer st;
         System.out.println(max + " - " + Integer.MAX_VALUE);
         while(( line = in.readLine() ) != null)
         {
             st = new StringTokenizer(line);
             BigInteger x = new BigInteger(st.nextToken());
             String operator = st.nextToken();
             BigInteger y = new BigInteger(st.nextToken());
             BigInteger z;
             if(operator.equals("+"))
                 z = x.add(y);
             else z = x.multiply(y);
             System.out.println(line);
             if(x.compareTo(MAX) > 0)
                 System.out.println("first number too big");
             if(y.compareTo(MAX) > 0)
                 System.out.println("second number too big");
             if(z.compareTo(MAX) > 0)
                 System.out.println("result too big");
         }
         in.close();
         System.exit(0);
     }
}
