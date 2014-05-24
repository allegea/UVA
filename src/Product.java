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
public class Product {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         StringBuilder out = new StringBuilder();
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
               BigInteger one = new BigInteger(line);
               BigInteger two = new BigInteger(in.readLine());
               out.append((one.multiply(two)).toString()).append("\n");
                
            }

            System.out.print(out);
        in.close();
        System.exit(0);
        
    }
}
