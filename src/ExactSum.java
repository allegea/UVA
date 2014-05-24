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
public class ExactSum {

   public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder out = new StringBuilder();
         StringTokenizer r;
         String line = "";
         while((line = in.readLine()) != null && line.length() > 0)
         {
             int n = Integer.parseInt(line);
             HashSet<Integer> numbers = new HashSet<Integer>();
             ArrayList<Integer> num = new ArrayList<Integer>();
             r = new StringTokenizer(in.readLine());
             int money = Integer.parseInt(in.readLine());
             
             for(int i=0;i<n;i++)
             {
                 int value = Integer.parseInt(r.nextToken());
                 if(value <= money){
                     numbers.add(value);
                     num.add(value);
                 }
             }
             int a = 0;
             int b = Integer.MAX_VALUE;
             int dif = b-a;
             for(int x:num)
             {
                 int y = money-x;
                 if(numbers.contains(y))
                 {
                     if(Math.abs(x-y)<dif)
                     {
                         dif = Math.abs(x-y);
                         a = x;
                         b = y;
                     }
                 }
             }
             int min = Math.min(a, b);
             int max = Math.max(a, b);
             out.append("Peter should buy books whose prices are ").append(min).append(" and ").append(max).append(".").append("\n\n");
             //System.out.println("Peter should buy books whose prices are "+min+" and "+max+".");
             //System.out.println();
             in.readLine();
         }
         System.out.print(out);
         in.close();
         System.exit(0);
     }
}
