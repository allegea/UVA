/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.math.BigDecimal;


/**
 *
 * @author allegea
 */
public class Exponentiation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           StringBuilder out = new StringBuilder();
            while ((line = in.readLine()) != null) 
            {
               String[] numbers = line.split("[ ][ ]*");
               //System.out.println(numbers[0]+" "+numbers[1]);
               BigDecimal r = new BigDecimal(numbers[0]);
               int n = Integer.parseInt(numbers[1]);
                String res =  r.pow(n).stripTrailingZeros().toPlainString();
                if(res.charAt(0)=='0')
                    out.append(res.substring(1)).append("\n");
                else
                    out.append(res).append("\n");
                           
            }
            
            System.out.print(out.toString());

        in.close();
        System.exit(0);
        
    }
}
