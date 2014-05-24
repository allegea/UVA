/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uva.StringP;
import java.io.*;
import java.util.Arrays;
import java.util.TreeMap;



/**
 *
 * @author allegea
 */
public class StringB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        BufferedReader in   = new BufferedReader(new FileReader("ex1.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           StringBuilder out = new StringBuilder();
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (in.ready()) 
            {
                String[] x = in.readLine().split("[ [.]]");
                Arrays.sort(x);
                int i=0;
               for(i=0; i<x.length;i++)
                   System.out.println(x[i]);
                   
               
               
               
            }
            TreeMap<Integer,Integer> w=new TreeMap<Integer,Integer>();

            System.out.print(out.toString());
        in.close();
        System.exit(0);
        
    }
}
