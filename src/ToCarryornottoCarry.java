/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;


import java.util.*;

/**
 *
 * @author allegea
 */
public class ToCarryornottoCarry {

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
            while ((line = in.readLine()) != null) 
            {
               StringTokenizer numbers = new StringTokenizer(line);
               long x = Long.parseLong(numbers.nextToken());
               long y = Long.parseLong(numbers.nextToken());
               
               System.out.println(x^y);
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
