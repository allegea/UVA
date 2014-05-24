/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class FactorialFrequencies {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         BigInteger[] factorial = new BigInteger[367];
         factorial[0] = new BigInteger("1");
         factorial[1] = new BigInteger("1");
         
         for(int i=2;i<=366;i++)
         factorial[i]=factorial[i-1].multiply(new BigInteger(String.valueOf(i)));

         
         
         
           String line;
            StringBuilder print = new StringBuilder();
           String spaces="    ";
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
               int n = Integer.parseInt(in.readLine());
               if(n==0)break;
               int i;
               char[] vector = factorial[n].toString().toCharArray();
               int[] count = new int[10];
               for(i=0;i<vector.length;i++)
                   count[vector[i]-'0']++;
               
              
               String number = String.valueOf(count[0]);
               
               print.append(n).append("! --").append("\n").append("   (0)").append(spaces.substring(0, 5-number.length())).append(number);
               
               for(i=1;i<5;i++){
                   number = String.valueOf(count[i]);
                   print.append(spaces).append("(").append(i).append(")").append(spaces.substring(0, 5-number.length())).append(number);
               }
               
               number = String.valueOf(count[5]);
               
               print.append("\n").append("   (5)").append(spaces.substring(0, 5-number.length())).append(number);
               
               for(i=6;i<10;i++){
                   number = String.valueOf(count[i]);
                   print.append(spaces).append("(").append(i).append(")").append(spaces.substring(0, 5-number.length())).append(number);
               }
               print.append("\n");
               
                   
                
                
            }
            System.out.print(print);

        in.close();
        System.exit(0);
        
    }
}
