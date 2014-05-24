/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class TheSkylineProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
       //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         int[] calcular = new int[10000];
         int min=Integer.MAX_VALUE;
         int max = 0;
           String line;
          // StringBuilder out = new StringBuilder();
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
               String[] building = line.split("[ ]+");
               int a=Integer.parseInt(building[0]);
               int h=Integer.parseInt(building[1]);
               int b=Integer.parseInt(building[2]);
               
               min=a<min?a:min;
               max=b>max?b:max;
              
               for(int i=a;i<b;i++)
               {
                   if(calcular[i]<h)calcular[i]=h;
               }
                
            }
            
            int ch=calcular[min];
            System.out.print(min+" "+ch);
            for(int i=min+1;i<=max;i++)
            {
                if(ch!=calcular[i]){
                    ch=calcular[i];
                    System.out.print(" "+i+" "+ch);
                }

            }
            
              System.out.println();
        in.close();
        System.exit(0);
        
    }
}
