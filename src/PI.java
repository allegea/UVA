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
public class PI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

           String line;

            while (!(line = in.readLine()).equals("0")) 
            {
               int size = Integer.parseInt(line);
               int[] numbers = new int[size];
               for(int i=0;i<size;i++)
               {
                   numbers[i]=Integer.parseInt(in.readLine());
               }
                
               int count = 0;
              for(int i=0;i<size-1;i++)
              {
                  for(int j=i+1;j<size;j++)
                      if(gcd(numbers[i],numbers[j])==1)count++;
              }
              
              if(count==0)
              {
                  System.out.println("No estimate for this data set.");
                  continue;
              }
              size=(size*(size-1))/2;
              //System.out.println(cases+" "+count);
              System.out.printf(Locale.ENGLISH,"%.6f\n",Math.sqrt((double)(size*6)/((double)(count))));
               //System.out.printf(Locale.ENGLISH,"%f6\n",0);
               
            }

        in.close();
        System.exit(0);
        
    }
    
    static int gcd(int a, int b)
    {
        int aux;

        
        while(a%b!=0)
        {
            aux = a;
            a=b;
            b=aux%b;
        }
        
        return b; 
    }
}
