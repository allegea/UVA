/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;
a
/**
 *
 * @author allegea
 */
public class The3n1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) /*throws FileNotFoundException*/ {
        //Scanner in = new Scanner(new File("pruebas.txt"));
        Scanner in = new Scanner(System.in);
        try {
        String line = in.nextLine();
        while(!line.equals(""))
        {

                
                String[] dates = line.split("[ ]");
                long i = Long.parseLong(dates[0]);
                long j = Long.parseLong(dates[1]);

                long io=i;
                long jo=j;
                if(i>j)
                {
                    long aux = i;
                    i=j;
                    j=aux;
                }
                long max = 0;
                
                for(long n=i;n<=j;n++)
                {
                    long aux = n;
                    long length = 1;
                    while(true)
                    {
                        
                        if(aux==1)break;
                        if(aux%2!=0)aux=3*aux+1;
                        else aux=aux>>1;
                        length++;
                        
                    }
                    
                    if(max<length)max = length;
                    
                    
                }
                System.out.println(io+" "+jo+" "+max);
                line = in.nextLine();
                
            
        }
         } catch (Exception e) {
           System.exit(0);
       }
    }
}
