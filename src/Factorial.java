/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.math.BigInteger;



/**
 *http://poj.org/problem?id=1401
 * @author allegea
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
   
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                
                
                BigInteger fact = new BigInteger("1");
                long val = Long.parseLong(in.readLine());
                for(long i = 2;i<val;i++)
                   fact= fact.multiply(BigInteger.valueOf(i));
                
                System.out.println(fact.toString());
              /* long factorial = 1;
               long val = Long.parseLong(in.readLine());
               long i=1;
               int count = 0;
               while(i<=val){
                   
                   factorial=factorial*i;
                   factorial%=10000000000000000l;
                   while(factorial%10==0){
                       factorial/=10;
                       count++;
                   }
                   
                   i++;
                   
                   //System.out.println(i);
                  
               }
               
                
                System.out.println(count);*/
            }

            
        in.close();
        System.exit(0);
        
    }
}
