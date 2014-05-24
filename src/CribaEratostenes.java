/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.math.BigInteger;
import java.util.BitSet;



/**
 *
 * @author allegea
 */
public class CribaEratostenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
          
          // int n = Integer.parseInt(in.readLine());
           BitSet numbers = new BitSet();
           
           
           
          int n = 1000000;
           for(int i=2;i*i<=n;i++)
               if(!numbers.get(i))
                   for(int j=i+i;j<=n;j=j+i)
                       numbers.set(j);
                 
           int prim = 0;
           int i=2;
           while(prim<10001&&i<numbers.length())
           {
               if(!numbers.get(i)){
                   prim++;
                   System.out.println(prim+" - "+i);
                           }
               i++;
           }

        in.close();
        System.exit(0);
        
    }
}
