/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */
public class BasicRamains {

  
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         //int cases =  Integer.parseInt(in.readLine());
        // String line;
            while (true) 
            {
                String[] read = in.readLine().split("[ ]+");
                if(read[0].equals("0"))break;
                
                BigInteger a = new BigInteger(read[1],Integer.parseInt(read[0]));
                BigInteger b = new BigInteger(read[2],Integer.parseInt(read[0]));
                
                System.out.println((a.mod(b)).toString(Integer.parseInt(read[0])));
                
               /* int base = Integer.parseInt(read[0]);
                int len = read[2].length()+1;
                int lenb = read[1].length();
                long a = Long.parseLong(read[1].substring(Math.max(0, lenb-len), lenb),base);
                long b = Long.parseLong(read[2],base);*/
                
               // System.out.println(Long.toString(a%b, base));
               
               
                   
                
            }

        in.close();
        System.exit(0);
        
    }
}
