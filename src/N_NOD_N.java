/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
a

import java.util.*;

/**
 *
 * @author allegea
 */
public class N_NOD_N {

    public static int[] divisors = new int[70000];
    public static int[] cantidades = new int[1000001];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
         divisors();
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      
           int cases = Integer.parseInt(in.readLine());
           
           int act = 0;
            while (act++<cases) 
            {
               //int amount = 0;
               StringTokenizer numbers = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(numbers.nextToken());
                int b = Integer.parseInt(numbers.nextToken());
                
                /*int i=0;
                while(divisors[i]<a)i++;
                
                while(divisors[i]<=b)
                {
                    amount++;
                    i++;
                }*/
                int upper = cantidades[b-1];
                int lower= a==1?0:cantidades[a-2];
                System.out.println("Case "+act+": "+(upper-lower));
                
                
            }

        in.close();
        System.exit(0);
        
    }
    
    static void divisors()    
    {
        
        int i=0;
        divisors[i++]=1;
        divisors[i]=2;
        
        while(divisors[i]<1000000)
        {
            int x = divisors[i];
            int div = 1;
            for(int p=2;p*p<=x;p++)
            {
                int cant=0;
                while(x%p==0)
                {
                    x/=p;
                    cant++;
                }
                div*=cant+1;
            }
            
            if(x>1)div*=2;
            i++;
            divisors[i]=div+divisors[i-1];
            
        }
        
        cantidades[0]=1;
        cantidades[1]=2;
        int j=2;
        for(int h=2;h<1000000;h++)
        {
            while(divisors[j]>(h+1)&& h<1000000)
            {
             cantidades[h]=cantidades[h-1]; 

             h++;
            }
            cantidades[h]=cantidades[h-1]+1;   
            j++;
        }
        


    }
}
