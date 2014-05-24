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
public class IsthistheEasiestProblem {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                String[] input = in.readLine().split("[ ]+");
                long[] sides = new long[3];
               boolean pos = true;
               for(int i=0;i<3;i++)
               {
                   sides[i] = Long.parseLong(input[i]);
                   if(sides[i]<=0)pos =false;
               }
               
               if(!pos){
                   System.out.println("Case "+act+": Invalid");
                   continue;
               }
               int equals = 0;
               Arrays.sort(sides);
               if(sides[0]+sides[1]<=sides[2] || sides[2]+sides[1]<=sides[0] || sides[0]+sides[2]<=sides[1])
               {
                   System.out.println("Case "+act+": Invalid");
                   continue;
               }
               
               if(sides[0] == sides[1])equals++;
               if(sides[2] == sides[1])equals++;
               if(sides[2] == sides[0])equals++;
               
               if(equals == 0)System.out.println("Case "+act+": Scalene");
               if(equals == 1)System.out.println("Case "+act+": Isosceles");
               if(equals == 2 || equals == 3)System.out.println("Case "+act+": Equilateral");
               
               
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
