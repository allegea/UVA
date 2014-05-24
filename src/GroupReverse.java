/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class GroupReverse {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         double p = Math.pow(10,18);
         System.out.println(p);
         
            while (true) 
            {
               String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               
               if(n==0)
                   break;
               StringBuilder output = new StringBuilder();
               n=input[1].length()/n;
               for(int i=0;i<input[1].length();i+=n)
                   output.append(new StringBuilder(input[1].substring(i, i+n)).reverse());
               System.out.println(output);
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
