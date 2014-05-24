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
public class CodeRefactoring {

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
                
               int n= Integer.parseInt(in.readLine());

               int count = 0;
               String answer = "Case #"+act+": "+n;
               for(int i=2;i*i<n && count!=2;i++)
               {
                   if(n%i==0)
                   {
                       answer+=" = "+i+" * "+n/i;
                       count++;
                   }
               }
               System.out.println(answer);
                
            }

        in.close();
        System.exit(0);
        
    }
}
