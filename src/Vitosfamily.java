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
public class Vitosfamily {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(in.readLine());
         while(n-- > 0)
         {
             StringTokenizer st = new StringTokenizer(in.readLine());
             int m = Integer.parseInt(st.nextToken());
             int[] values = new int[m];
             long answer = Integer.MAX_VALUE;
             for(int i = 0; i < m; i++)
                 values[i] = Integer.parseInt(st.nextToken());
             
             for(int i = 0; i < m; i++)
             {
                 long partial = 0;
                 for(int j = 0; j < m; j++)
                     partial+=Math.abs(values[i] - values[j]);
                 answer = Math.min(answer, partial);
             }
             System.out.println(answer);
                 
         }
         in.close();
         System.exit(0);
     }
}
