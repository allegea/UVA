/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class BasicallySpeaking {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         

         //System.out.println(Long.parseLong("12",10));
         
           String line;
           String spaces = "       ";
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           StringBuilder output = new StringBuilder();
            while ((line = in.readLine()) != null) 
            {
                
                String[] read = line.trim().split("[ ]+");
                //System.out.println(read[0]+"-"+read[1]+"-"+read[2]);
                BigInteger x = new BigInteger(read[0],Integer.parseInt(read[1]));
                
                
                //System.out.println(x.toString());
                
                String y = x.toString(Integer.parseInt(read[2]));
 
                if(y.length()>7)
                output.append("  ERROR").append("\n");
                else
                output.append(spaces.substring(0,7-y.length())).append(y.toUpperCase()).append("\n");
            }
            
            System.out.print(output);

        in.close();
        System.exit(0);
        
    }
}
