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
public class WhoSaidCrisis {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         BigInteger x, y;
         int cases = Integer.parseInt(in.readLine());
         while(cases-- > 0)
         {
             st = new StringTokenizer(in.readLine());
             x = new BigInteger(st.nextToken());
             y = new BigInteger(st.nextToken());
             System.out.println(x.add(y.negate()));
         }
         in.close();
         System.exit(0);
     }
}
