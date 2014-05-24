/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class PrimaryArithmetic {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
      
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           //int[] nV;
          // int[] mV;
            while ((line = in.readLine()) != null) 
            {
                String[] input = line.split("[ ]+");
               long n= Long.parseLong(input[0]);
               long m= Long.parseLong(input[1]);
              
               if(n==0l && m==0l)
                   break;
              // nV = new int[12];
              // mV = new int[12];
               int answer = 0;
               int carr = 0;

              // int mi,ni;
               while(n!=0 || m!=0)
               {
                   if(n%10+m%10+carr>9)
                   {
                       carr=1;
                       answer++;
                   }else carr=0;
                   
                   n/=10;
                   m/=10;
                   //System.out.println(n+" - "+m+" - "+carr);
               }
               
               if(answer==0)
                   System.out.println("No carry operation.");
               else if(answer==1)
                   System.out.println("1 carry operation.");
               else System.out.println(answer+" carry operations.");
                
            }

        in.close();
        System.exit(0);
        
    }
}
