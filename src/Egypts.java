/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */
public class Egypts {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           

            while (true) 
            {
                line = in.readLine();
               String[] values = line.split("[ ]+");
               int[] ivalues = {Integer.parseInt(values[0]),Integer.parseInt(values[1]),Integer.parseInt(values[2])};
               if(ivalues[0]==0&&ivalues[1]==0&&ivalues[2]==0)break;
               Arrays.sort(ivalues);
               
               if(ivalues[0]*ivalues[0]+ivalues[1]*ivalues[1]==ivalues[2]*ivalues[2])
                   System.out.println("right");
               else System.out.println("wrong");
              
                
            }

        in.close();
        System.exit(0);
        
    }
}
