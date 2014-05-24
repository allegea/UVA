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
public class GCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) /*throws IOException*/{
        try{
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


           
            while(true)
            {
                
                int n= Integer.parseInt(in.readLine());
                if(n==0)break;
                
                int gcd = 0;
                for(int i=1;i<n;i++)
                    for(int j=i+1;j<=n;j++)
                        gcd+=gcd(i,j);
                
                System.out.println(gcd);
                
                
            }
        }
        catch(IOException e)
        {
            System.exit(0);
        }

        
        System.exit(0);


    }
    
    static int gcd(int i,int j)
    {
        
        if(i<j)
        {
            int aux = i;
            i=j;
            j=aux;
                    
        }
        
        while(j!=0)
        {
            int aux=j;
            j=i%j;
            i=aux;
        }
        
        return i;
    }
}
