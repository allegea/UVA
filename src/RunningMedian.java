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
public class RunningMedian {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         ArrayList<Integer> values;
         StringBuilder output;
         while(n-- > 0)
         {
             int curr = in.nextInt();
             output = new StringBuilder();
             int  m = in.nextInt();
             output.append(curr).append(" ").append((m + 1) / 2).append("\n");
             values = new ArrayList<Integer>();
             int count = 0;
             for(int i = 1; i <= m; i++)
             {
                 values.add(in.nextInt());
                 if(i % 2 != 0)
                 {
                     Collections.sort(values);
                     count++;
                     output.append(values.get(i / 2));
                     if(count == 10)
                     {
                         output.append("\n");
                         count = 0;
                     }else if(i != m) output.append(" ");
                 }
             }
             System.out.println(output);
         }

         in.close();
         System.exit(0);
     }
}
