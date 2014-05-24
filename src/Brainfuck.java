/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class Brainfuck {
    
   public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(in.readLine());
         int cases = 1;
         
         int[] num;
         int m = 100;
         int ma = 256;
         char[] line;
         while(n-->0)
         {
             line = in.readLine().toCharArray();
             num = new int[m];
             int p = 0;
             for(char c:line)
             {
                 if(c == '>')p=(p+1)%m;
                 else if(c == '<')p=(p-1+m)%m;
                 else if(c == '+')num[p] = (num[p]+1)%ma;
                 else if(c == '-')num[p] = (num[p]-1+ma)%ma;
             }
             
             String output = "Case "+cases+":";
             cases++;
             for(int i=0;i<m;i++)
             {
                 String aux = Integer.toHexString(num[i]).toUpperCase();
                 if(aux.length() == 1)aux = "0"+aux;
                 output+=" "+aux;
             }
             System.out.println(output);
             
             
         }
         in.close();
         System.exit(0);
     }
}
