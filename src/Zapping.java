/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class Zapping {

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
               if(a==-1 && b==-1)
                   break;
               int min = Math.min(100-Math.abs(b-a), Math.abs(b-a));
               System.out.println(min);
                
            }

        in.close();
        System.exit(0);
        
    }
}
