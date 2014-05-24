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
public class NaughtySleepyBoys {

    public static long digit(long num, long pos, int dig)
    {
       // System.out.println(num + " - " + dig + " - "+pos);
        //long answer = 0;
        while(pos++ < dig - 1)num/=10;
        return num % 10;
    }
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
       int N = 20;
        long[] dp = new long[N];
        long[] digits = new long[N];
        long[] tens = new long[N];
        int i = 0;
        tens[i] = 10;
        dp[i] = digits[i] = tens[i] - 1;
        
        while(dp[i++] < 2147483647)
        {
            digits[i] = 9l * (i + 1) * tens[i - 1];
            tens[i] = 10 * tens[i - 1];
            dp[i] = dp[i - 1] + digits[i];
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(tens));
        System.out.println(Arrays.toString(digits));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String line = "";
         while(( line = in.readLine()) != null && line.length() > 0)
         {
             long x = Long.parseLong(line);
             i = 0;
             while(dp[i] < x)i++;
             long prev = i > 0?dp[i - 1] + 1:0;
             x-= prev;
            // System.out.println(prev + " - " + x + " - " + i);
             //x/=(i + 1);
             System.out.println(digit(x/(i + 1) + (i > 0?tens[i]/10:0), x%(i + 1), i + 1));
         }
         in.close();
         System.exit(0);
     }
}
