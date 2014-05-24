/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Alejandro E. Garces
 */
public class GoldbachsConjecture {

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
           String line;

            while (true) 
            {

                int num = Integer.parseInt(in.readLine());
                if(num ==0)break;
                if(!criba.get(num)){
                     System.out.println("Goldbach's conjecture is wrong.");
                     continue;
                }
                    
                int i=1;
                boolean found = false;
                while(i<num && !found){
                    System.out.println("* "+i);
                    while(criba.get(i))i++;
                    if(!criba.get(num-i)){
                        System.out.println(num+" = "+Math.min(num-i, i)+" + "+Math.max(num-i, i));
                        found = true;
                        break;
                    }
                    i++;
                //System.out.println("**");    
                }
                //System.out.println("*");
                if(!found)
                    System.out.println("Goldbach's conjecture is wrong.");
                
              
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
