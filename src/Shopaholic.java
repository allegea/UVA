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
public class Shopaholic {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         int[] values;
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
               
               int n= Integer.parseInt(in.readLine());
               values = new int[n];
               String[] read = in.readLine().split("[ ]+");
               for(int i=0;i<read.length;i++)
                   values[i] = Integer.parseInt(read[i]);
               
               Arrays.sort(values);
              // System.out.println(Arrays.toString(values));
               int answer = 0;
               for(int i=n-3;i>=0;i-=3)
               {
                   
                   //System.out.println( values[i]+" - "+values[i+1]+" - "+values[i+2]);
                   answer += values[i];
               }
                System.out.println(answer);
            }

        in.close();
        System.exit(0);
        
    }
}
