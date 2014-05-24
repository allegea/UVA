/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class TrianguleWave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String[] salida = new String[9];
               
               
               for(int i=1;i<=9;i++){
                   salida[i-1]="";
                   for(int j=0;j<i;j++)
                       salida[i-1]+=""+i;
                   
                   //System.out.println(out);
               }
           String line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
           StringBuilder out = new StringBuilder();
            while (act++<cases) 
            {
                
                in.readLine();
                
                if(act>1)out.append("\n");
                
               int amp = Integer.parseInt(in.readLine());
               int fr = Integer.parseInt(in.readLine());
               
               
               
               for(int i=0;i<fr;i++)
               {
                   for(int j=0;j<amp;j++)
                       out.append(salida[j]).append("\n");
                      
                   
                   for(int j=amp-2;j>=0;j--)
                       out.append(salida[j]).append("\n");
                       
                   if(i<fr-1)
                   out.append("\n");
               }
                
            }

            System.out.print(out);
        in.close();
        System.exit(0);
        
    }
}
