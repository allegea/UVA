/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class The3nplus1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           
           
           //System.out.println(2>>1);
            while (!(line = in.readLine()).equals("")) 
            {
               String[] entrada = line.split("[ ]+");
               long i = Long.parseLong(entrada[0]);
               long j = Long.parseLong(entrada[1]);
               
               long max = 1;
               boolean cambio = false;
               if(i>j){
                   long aux = i;
                   i=j;
                   j=aux;
                   cambio =true;
               }
               for(long k=i;k<=j;k++){
                   //System.out.println(k);
                   long cicle = 1;
                   long h = k;
                   while(h!=1){
                       if(h%2==0)h>>=1;
                       else h=3*h+1;
                       cicle++;
                   }
                   max=Math.max(max,cicle);
               }
               
               if(cambio){
                   long aux = i;
                   i=j;
                   j=aux;
               }
               System.out.println(i+" "+j+" "+max);

            }

   
        in.close();
        System.exit(0);
        
    }
}
