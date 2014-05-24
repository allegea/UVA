/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class LittleNephew {

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
               int c=Integer.parseInt(read[2]);
               int d=Integer.parseInt(read[3]);
               int e=Integer.parseInt(read[4]);

               if(a==0 && b==0 && c==0 && d==0 && e==0)
                   break;
              
               System.out.println((a*b*c*d*d*e*e));
                
            }

        in.close();
        System.exit(0);
        
    }
}
