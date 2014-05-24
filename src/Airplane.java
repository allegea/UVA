/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class Airplane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
            while (true) 
            {
               int n = Integer.parseInt(in.readLine());
               if(n==0)break;
               
               System.out.println("1/2");
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
