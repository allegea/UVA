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
public class SquareNumber {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         
            while (true) 
            {
               String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               if(n==0 && m==0)
                   break;
               
               System.out.println((int)Math.sqrt(m)-(int)Math.sqrt(n-1));
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
