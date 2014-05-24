/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.HashSet;



/**
 *
 * @author allegea
 */
public class ProfessorLazy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     
            while (true) 
            {
               String[] read = in.readLine().split("[ ]+");
               int a=Integer.parseInt(read[0]);
               int b=Integer.parseInt(read[1]);
               long c=Long.parseLong(read[2]);

               if(a==0 &&b==0 &&c==0l)
                   break;

               long w = c%5;
               if(w==0)
                 System.out.println(a);
               else if(w==1)
                 System.out.println(b);
               else if(w==2)
                 System.out.println((int)(1+b)/(a));
               else if(w==3)
                 System.out.println((int)(a+b+1)/(a*b));
               else if(w==4)
                 System.out.println((int)(1+a)/(b));
                
            }

        in.close();
        System.exit(0);
        
    }
}
