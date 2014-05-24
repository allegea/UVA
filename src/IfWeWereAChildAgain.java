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
public class IfWeWereAChildAgain {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         String line, oper;
         BigInteger x, y, z;
         while(( line = in.readLine()) != null)
         {
             st = new StringTokenizer(line);
             x = new BigInteger(st.nextToken());
             oper = st.nextToken();
             y = new BigInteger(st.nextToken());
             if(oper.compareTo("/") == 0)
             z = x.divide(y);
             else z = x.mod(y);
             System.out.println(z.toString());
         }
         in.close();
         System.exit(0);
     }
}
