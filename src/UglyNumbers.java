/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;


import java.util.*;

/**
 *
 * @author allegea
 */
public class UglyNumbers {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws IOException {

        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Long> ugly = new TreeSet<Long>();
        ugly.add(1l);

        
        int can=1;
        while (can++ < 1500) {
            long aux = ugly.pollFirst();
           
            ugly.add(aux*2);
            ugly.add(aux*3);
            ugly.add(aux*5);
            //System.out.println(aux);
         
        }
    

        System.out.println("The 1500'th ugly number is "+ugly.pollFirst()+".");

        in.close();
        System.exit(0);

    }
    
}
