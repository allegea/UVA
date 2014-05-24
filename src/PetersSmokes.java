/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class PetersSmokes {

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
                String[] input = line.split("[ ]+");
               long n= Long.parseLong(input[0]);
               long k= Long.parseLong(input[1]);

               long answer = n;
               long ash = n;
               
               while(ash>=k)
               {
                   answer+=(ash/k);
                   ash= ash/k+ash%k;
               }
               System.out.println(answer);
                
            }

        in.close();
        System.exit(0);
        
    }
}
