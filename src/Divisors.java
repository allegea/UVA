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
public class Divisors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           int cases = Integer.parseInt(in.readLine());
           int act = 0;
            while (act++<cases) 
            {
               StringTokenizer numbers = new StringTokenizer(in.readLine());
               
               long l = Long.parseLong(numbers.nextToken());
               long u = Long.parseLong(numbers.nextToken());
               long max=0;
               long number=l;
               
               for(long i=l;i<=u;i++)
               {
                   long divi = divisors(i);
                   if(max<divi)
                   {
                       max=divi;
                       number=i;
                   }
               }
               
               System.out.println("Between "+l+" and "+u+", "+number+" has a maximum of "+max+" divisors.");
                
                
            }

        in.close();
        System.exit(0);
        
    }
    
    static long divisors(long x)
    {
        long div = 1;
        
        for(int i=2;i*i<=x;i++)
        {
            int conta = 0;
            while(x%i==0)
            {
                conta++;
                x/=i;
            }
            div*=conta+1;
            
        }
        
        if(x>1) div*=2;

        return div;
    }
}
