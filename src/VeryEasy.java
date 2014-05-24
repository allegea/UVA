/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class VeryEasy {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         String line;
            while ((line = in.readLine())!=null) 
            {
               String[] input = line.split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               if(n==0 && m==0)
                   break;
               
               BigInteger sum = new BigInteger("0");
               //BigInteger ii = new BigInteger("1");
               BigInteger aa = new BigInteger(String.valueOf(m));
               for(int i=1;i<=n;i++)
               {
                   sum = sum.add(aa.pow(i).multiply(new BigInteger(String.valueOf(i))));
               }
               
               
               System.out.println(sum.toString());
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
