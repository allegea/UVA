/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Alejandro E. Garces
 */
public class SimplifyingFactors {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         

         //System.out.println(Long.parseLong("12",10));
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
            while (cases-->0) 
            {
                
                String[] read = in.readLine().split("[ ]+");
                //System.out.println(Arrays.toString(read));
                BigInteger num = new BigInteger(read[0]);
                BigInteger den = new BigInteger(read[2]);
                
                BigInteger gcd = num.gcd(den);
                
                num = num.divide(gcd);
                den = den.divide(gcd);
                
                System.out.println(num.toString()+" / "+den.toString());
                
                

            }
            
            

        in.close();
        System.exit(0);
        
    }
}
