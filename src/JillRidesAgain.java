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
public class JillRidesAgain {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int cases = Integer.parseInt(in.readLine());
         long[] dp, numbers;
         int posX, posY;
         long max;
         int curr = 0;
         while(curr++ < cases)
         {
             int N = Integer.parseInt(in.readLine());
             max = Long.MIN_VALUE;
             posX = posY =  - 1;
             dp = new long[N + 1];
             numbers = new long[N];
             for(int i = 0; i < N - 1; i++)
             {
                 numbers[i] = Long.parseLong(in.readLine().trim());
                 if(numbers[i] > 0 && numbers[i] > max)
                 {
                     posX = i;
                     posY = i + 1;
                     max = numbers[i];
                 }
             }
             
             for(int i = 1; i < N; i++)
                 dp[i] = dp[i - 1] + numbers[i - 1];
             
           //  System.out.println(Arrays.toString(dp));
             for(int i = 1; i < N; i++)
             {
                 for(int j = i + 1; j < N; j++)
                 {
                     long value = dp[j] - dp[i];
                     if(value > max)
                     {
                         max = value;
                         posX = i;
                         posY = j;
                        // System.out.println(max + " * " + posX + " * " + posY);
                     }else if(value == max)
                     {
                         if(posY - posX < j - i)
                         {
                             posX = i;
                             posY = j;
                           //  System.out.println(max + " - " + posX + " - " + posY);
                         }/*else if(posY - posX == j - i)
                         {
                             if(i < posX)
                             {
                                posX = i - 1;
                                 posY = j - 1; 
                             }
                         }*/
                         
                     }
                 }
             }
             
                 
             if(max > 0)
             System.out.println("The nicest part of route " + curr + " is between stops " + (posX + 1) + " and " + (posY + 1));
             else System.out.println("Route " + curr + " has no nice parts");
                 
         }
         in.close();
         System.exit(0);
     }
}
