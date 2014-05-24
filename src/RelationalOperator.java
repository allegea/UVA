/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro E. Garces
 */
public class RelationalOperator {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                String[] val = in.readLine().split("[ ]+");
                int i = Integer.parseInt(val[0]);
                int j = Integer.parseInt(val[1]);
                if(i>j)System.out.println(">");
                else if(i<j)System.out.println("<");
                else System.out.println("=");
                
              
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
