/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;



/**
 *
 * @author allegea
 */
public class LCMCardinality {

    public static long gcd(long a,long b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           StringBuilder out = new StringBuilder();

            while ((line = in.readLine())!=null) 
            {
               long x = Integer.parseInt(line);
               if(x==0)break;
               
               HashSet<Long> set = new HashSet<Long>();
               
               for(long i=1;i*i<=x;i++){
                   if(x%i==0){
                       set.add(i);
                       set.add(x/i);
                   }
               }
               
               long[] numbers = new long[set.size()];
               int i=0;
               for(Long w:set)
                   numbers[i++]=w;
               
               long gcd = 0;
               long count=0;
               for(i=0;i<numbers.length;i++){
                   for(int j=i+1;j<numbers.length;j++){
                       //if(i==j)continue;
                       gcd = gcd(numbers[i],numbers[j]);
                       if(numbers[i]*numbers[j]/gcd==x){
                           count++;
                         //  System.out.println(numbers[i]+" - "+numbers[j]);
                       }
                   }
               }
               
               //System.out.println(Arrays.toString(numbers));
               System.out.println(x+" "+(count+1));
            }

            
        in.close();
        System.exit(0);
        
    }
}
