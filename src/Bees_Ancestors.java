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
public class Bees_Ancestors {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         long[] fib = new long[82];
         fib[0]=1l;
         fib[1]=2l;
         for(int i=2;i<=81;i++)
             fib[i]=fib[i-1]+fib[i-2];
        // System.out.println(Arrays.toString(fib));
        
            while (true) 
            {
                int n=Integer.parseInt(in.readLine());
                if(n==0)break;
                
                System.out.println(fib[n-1]);
                
            }

        in.close();
        System.exit(0);
        
    }
}
