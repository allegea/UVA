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
public class PrimeCuts {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BitSet criba = new BitSet();
         criba.set(0);
         int[] num = new int[169];
         int k=0;
         //criba.set(1);
         for(int i=2;i*i<=1000;i++)
             if(!criba.get(i))
                 for(int j=i*2;j<=1000;j+=i)
                     criba.set(j);
         
         for(int i=0;i<=1000;i++)
             if(!criba.get(i))
                 num[k++]=i;
         
         //System.out.println(k);
         
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         System.out.println(Arrays.toString(num));
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
               String[] input = line.split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);

               int i=0;
               for(i=0;i<169;i++)
                   if(num[i]>n)
                       break;
               i++;
               int show=0;
               if(i%2==0)
                   show = Math.min(m*2,i);
               else show = Math.min(m*2-1,i);
               System.out.print(n+" "+m+":");
               for(int h=i/2-show/2;h<=i/2+show/2;h++){
                   System.out.print(" "+num[h]);
               }
               
               System.out.println();
               
              // System.out.println(n+" things taken "+m+" at a time is "+factorial[n].divide(factorial[n-m].multiply(factorial[m]))+" exactly.");
                
                ghj
            }

        in.close();
        System.exit(0);
        
    }
}
