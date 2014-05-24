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
public class Multipleof17 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         
            while (true) 
            {
               String input = in.readLine();
               if(input.length()==1 && input.equals("0"))
                   break;
               
               int answer = 0;
               for(int i=0;i<input.length();i++)
               answer=(answer*10+(input.charAt(i)-'0'))%17;
               
               if(answer==0)
                   System.out.println("1");
               else System.out.println("0");
                
            }

        in.close();
        System.exit(0);
        
    }
}
