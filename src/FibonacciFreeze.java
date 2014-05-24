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
public class FibonacciFreeze {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         BigInteger[] fibo = new BigInteger[5001];
         fibo[0]= new BigInteger("0");
         fibo[1]= new BigInteger("1");
         for(int i=2;i<5001;i++)
             fibo[i]= fibo[i-1].add(fibo[i-2]);

         
           String line;
           
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
               StringBuilder out = new StringBuilder("The Fibonacci number for ");
                int pos = Integer.parseInt(line);
                out.append(pos).append(" is ").append(fibo[pos].toString());
                System.out.println(out);
                
            }

            
        in.close();
        System.exit(0);
        
    }
}
