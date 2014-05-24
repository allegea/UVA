/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class CD {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         
            while (true) 
            {
               String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               if(n==0 && m==0)
                   break;
               
               BitSet cds1 = new BitSet();
               BitSet cds2 = new BitSet();
               for(int i=0;i<n;i++)
                   cds1.set(Integer.parseInt(in.readLine()));
               
               for(int i=0;i<m;i++)
                   cds2.set(Integer.parseInt(in.readLine()));
               
               cds1.and(cds2);
               System.out.println(cds1.cardinality());
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
