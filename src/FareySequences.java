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
public class FareySequences {

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
               String[] input = line.split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               
               int k=0;
               int a=0;
               int b=1;
               int p=1;
               int q=n;
               int c=1,d=n;
               for(int i=1;i<m;i++)
               {
                   k=(int)((n+b)/d);
                   p=k*c-a;
                   q=k*d-b;
                   a=c;
                   b=d;
                   c=p;
                   d=q;
               }
               System.out.println(p+"/"+q);
                
            }

        in.close();
        System.exit(0);
        
    }
}
