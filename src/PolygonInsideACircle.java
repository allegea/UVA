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
public class PolygonInsideACircle {

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
                StringTokenizer dates = new StringTokenizer(line);
                double radio = Double.parseDouble(dates.nextToken());
                int sides = Integer.parseInt(dates.nextToken());
               
                double area =  ((sides*radio*radio*(Math.sin(2*Math.PI/(double)sides)))/2);
                
                System.out.printf(Locale.ENGLISH,"%.3f\n",area);
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
