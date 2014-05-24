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
public class SmallFactors {
    
    public static long BS(int x, ArrayList<Long> factors)
    {
        int R = factors.size() - 1;
        int L = 0;
        long answer = 0;
        while( L <= R)
        {
            int mid = (L + R) / 2;
            //System.out.println(L + " - " + mid + " - " + R + " - "+factors.get(mid));
            if(factors.get(mid) >= x)
            {
                answer = factors.get(mid);
                R = mid - 1;
            }else L = mid + 1;
        }
        return answer;
    }

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         TreeSet<Long> compute = new TreeSet<Long>();
         ArrayList<Long> factors = new ArrayList<Long>();
         compute.add(1l);
         long max = 1l<<32;

         while(true)
         {
             long x = compute.pollFirst();
             //System.out.println(x);
             if(x > max)break;
             factors.add(x);
             compute.add(x*2L);
             compute.add(x*3L);
         }
         
         while(true)
         {
             int x = Integer.parseInt(in.readLine());
             if(x == 0)break;
             System.out.println(BS(x, factors));
             
         }
         

         in.close();
         System.exit(0);
     }
}
