/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.math.BigInteger;


/**
 *
 * @author allegea
 */
public class Integer_Inquiry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           BigInteger sum = new BigInteger("0");
            while (!(line = in.readLine()).equals("0")) 
            {
                
               sum = sum.add(new BigInteger(line));
                
                
            }
            
            System.out.println(sum.toString());

        in.close();
        System.exit(0);
        
    }
}
