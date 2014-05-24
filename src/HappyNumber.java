/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.HashSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class HappyNumber {

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

               HashSet<String> check = new HashSet<>(); 
               String or = in.readLine();
               String n = or;
               while(!n.equals("1") && check.add(n)){
                   
                   char[] aux = n.toCharArray();
                   long au = 0l;
                   long k=0;
                   for(int i=0;i<aux.length;i++)
                   {
                       k=aux[i]-'0';
                       au+=k*k;
                   }
                   
                   n=String.valueOf(au);
               }
               
               //System.out.println(check);
               
               if(n.equals("1"))
               System.out.println("Case #"+act+": "+or+" is a Happy number.");
               else
               System.out.println("Case #"+act+": "+or+" is an Unhappy number.");
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
