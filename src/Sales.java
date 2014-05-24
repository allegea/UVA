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
public class Sales {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         int cases = Integer.parseInt(in.readLine());
            while (cases-->0) 
            {
               int n= Integer.parseInt(in.readLine());
               int[] sales = new int[n];
               
               String[] read = in.readLine().split("[ ]+");
               
               for(int i=0;i<n;i++)
               sales[i] = Integer.parseInt(read[i]);
               
               int[] b = new int[n];
               
               for(int i=1;i<n;i++){
                   for(int j=i-1;j>=0;j--)
                   {
                       if(sales[i]>=sales[j])
                           b[i]++;
                   }
               }
               //System.out.println(Arrays.toString(b));
               long sum=0l;
               for(int i=0;i<n;i++)
               sum+=b[i];
               
               System.out.println(sum);
               /*for(int i=1;i<n;i++)
               {
                   if(sales[i]>=sales[i-1])
                       b[i]=b[i-1]+1;
                   else{
                       for(int j=i-2;j>=0;j--)
                       {
                           if(sales[i]>=sales[j])
                           {  b[i]=b[j]+1;
                              break;
                           }
                       }
                   }
               }*/
               
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
