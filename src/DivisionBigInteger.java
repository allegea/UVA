/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class DivisionBigInteger {

    public static final BigDecimal mONE = new BigDecimal("-1");
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st;
         BigDecimal t, x, y;
         int a, b;
         String line = "";
         while(( line = in.readLine()) != null)
         {
             st = new StringTokenizer(line);
             t = new BigDecimal(st.nextToken());
             a = Integer.parseInt(st.nextToken());
             b = Integer.parseInt(st.nextToken());
             x = t.pow(a).add(mONE);
             y = t.pow(b).add(mONE);
            // BigDecimal xx = new BigDecimal("0");
             try {
               x = x.divide(y);
            } catch (ArithmeticException e) {
                System.out.println("(" + t.toString() + "^" + a + "-1)/(" + t.toString() + "^" + b + "-1) is not an integer with less than 100 digits");
            }
             
             String answer = x.toString();
             if(answer.length() > 100)answer = "is not an integer with less than 100 digits";
             System.out.println("(" + t.toString() + "^" + a + "-1)/(" + t.toString() + "^" + b + "-1) " + answer);
            
         }
         in.close();
         System.exit(0);
     }
}
