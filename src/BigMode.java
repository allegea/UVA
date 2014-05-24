/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author allegea
 */
public class BigMode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) /*throws IOException*/ {
        //Scanner in = new Scanner(new File("pruebas.txt"));
  
        Scanner in = new Scanner(System.in);
        
        try{
            long b = Long.parseLong(in.nextLine());
            long p = Long.parseLong(in.nextLine());
            long m = Long.parseLong(in.nextLine());
       while(true)
        {
            
           
            long answer = 1;
            
            while(p!=0)
            {
                if(p%2==1) answer=(answer*b)%m;
                b=(b*b)%m;
                p>>=1;
                
            }
            
            
            System.out.println(answer);
            
            in.nextLine();
            b = Long.parseLong(in.nextLine());
            p = Long.parseLong(in.nextLine());
            m = Long.parseLong(in.nextLine());
            
        }
        }catch(Exception e){
            
        }
        
        //System.exit(0);
    }
}
