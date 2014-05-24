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
public class HowManyPointsOfIntersection {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         int curr = 1;
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                String[] input = in.readLine().split("[ ]+");
               long n= Long.parseLong(input[0]);
               long m= Long.parseLong(input[1]);
               if(n == 0 && m == 0)break;
               
               long answer = ((n*(n-1))/2)*((m*(m-1))/2);
               System.out.println("Case "+curr+": "+answer);
               curr++;
                
            }

        in.close();
        System.exit(0);
        
    }
}
