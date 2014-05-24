/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class Bee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         long[] answers = new long[1000000];
         long fib1=0,fib2=1,fib3=1;
         long limit = 1l<<32;
         int i=1;
         
         answers[i]=fib3;
         while(answers[i++]<limit){
             answers[i]+=answers[i-1]+fib3;
             fib1=fib2;
             fib2=fib3;
             fib3=fib2+fib1;
            // System.out.println(answers[i]);
             
         }
            //System.out.println(Arrays.toString(answers));
           String line;
           
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line=in.readLine())!=null) 
            {
               int n = Integer.parseInt(line);
               if(n==-1)break;
               System.out.println(answers[n]+" "+answers[n+1]);
                
            }

            //System.out.print(out.toString());
        in.close();
        System.exit(0);
        
    }
}
