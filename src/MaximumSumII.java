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
public class MaximumSumII {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         ArrayList<Integer> values;
         while(true)
         {
             int N = Integer.parseInt(in.readLine());
             if(N == 0)break;
             values = new ArrayList<Integer>();
             for(int i = 0; i < N; i ++)
             {
                 int u = Integer.parseInt(in.readLine());
                 if(u != 0)values.add(u);
             }
             if(values.size() == 0)System.out.println("0");
             else{
                 String answer = "";
                 for(int x:values)
                     answer+=x+" ";
                 System.out.println(answer.trim());
             }
             
         }
         in.close();
         System.exit(0);
     }
}
