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
public class GCD_LCM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) /*throws IOException*/{
        try{
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         int cases = Integer.parseInt(in.readLine());
           int act=0;
            while(act++<cases)
            {
                
                String line = in.readLine();
                StringTokenizer numbers = new StringTokenizer(line);
               long g= Long.parseLong(numbers.nextToken());
               long l= Long.parseLong(numbers.nextToken());
               
               if(l%g!=0) System.out.println(-1);
               else 
               {
                   /*int h=1;
                   for(long i=g;i<=l;i=h*g)
                   {
                       
                       for(long j=l;j>=i;j--)
                       {
                          
                           if(i*j==g*l&&i%g==0&&l%i==0)System.out.println(i+" "+j);
                       }
                       h++;
                   }*/
                   System.out.println(g+" "+l);
                   /*if(g*2==l)System.out.println(g+" "+l);
                   else System.out.println(g*2+" "+((g*l)/(g*2)));*/
                           
               }

                  
                   
               
                
            }
        }
        catch(IOException e)
        {
            System.exit(0);
        }

        
        System.exit(0);


    }

}
