/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Alejandro E. Garces
 */
public class HighPrecisionNumber {

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
                BigDecimal answer = new BigDecimal("0");
                
                
                while(true)
                {
                    BigDecimal add = new BigDecimal(in.readLine());
                    if(add.compareTo((BigDecimal.ZERO))==0)
                        break;
                    answer=answer.add(add);
                }

                 char output [] = answer.toString().toCharArray();
	            int len = output.length - 1;
	             
	            while ( len >= 0 && output [len] == '0' ) len--;
	            if ( len >= 0 && output [len] == '.' ) len--;
	             
	            for ( int i = 0; i <= len; i++ ) System.out.print (output [i]);
	            System.out.println ();
                //System.out.println(answer.stripTrailingZeros().toPlainString());
                
                

            }
            
            

        in.close();
        System.exit(0);
        
    }
}
