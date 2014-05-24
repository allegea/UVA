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
public class ThePrimaryProblem {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BitSet criba = new BitSet();
         criba.set(0);
         criba.set(1);
         for(int i=2;i*i<=1000000;i++)
             if(!criba.get(i))
                 for(int j=i*2;j<=1000000;j+=i)
                     criba.set(j);

         
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 

         
            while (true) 
            {
               int n= Integer.parseInt(in.readLine());
               if(n==0)
                   break;
               
               boolean found = true;
               System.out.println(n+":");
               for(int i=2;i<=n/2 && found;i++){
                   if(!criba.get(i))
                   {
                       if(!criba.get(n-i))
                       {
                           System.out.println(i+"+"+(n-i));
                           found=false;
                           
                       }
                   }
               }
               
               if(found)
                   System.out.println("NO WAY!");
              
                
            }

        in.close();
        System.exit(0);
        
    }
}
