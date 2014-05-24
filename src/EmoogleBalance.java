/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class EmoogleBalance {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         Scanner in = new Scanner((System.in));
         HashSet<Integer> set;
         StringTokenizer st;
         int cases = 1;
         while(true)
         {
             //int n = Integer.parseInt(in.readLine());
             int n = in.nextInt();
             if(n == 0)break;
             //set = new HashSet<Integer>();
             int count = 0;
             int count2 = 0;
             //st = new StringTokenizer(in.readLine());
             while(n -- > 0)
             {
                 //int value = Integer.parseInt(st.nextToken());
                 int value = in.nextInt();
                 if(value == 0)count++;
                 else count2++;
             }
             System.out.println("Case " + cases + ": " + (count2 - count));
             cases++;
             
         }
         in.close();
         System.exit(0);
     }
}
