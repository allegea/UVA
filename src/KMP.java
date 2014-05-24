/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Arrays;



/**
 *
 * @author allegea
 */
public class KMP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         for(int w=0;w<3;w++){
           char[] line = in.readLine().toCharArray();
           int[] b = new int[line.length+1];
           b[0] = -1;
           int j=-1;
           for(int i=0;i<line.length;i++){
               j=b[i];
               while(j>=0 && j<line.length && i<line.length && line[i]==line[j]){
                 b[i++]=j++;
               }
               b[i]=j++;
              // j=b[i];
//               j=b[i];
             // System.out.println(b[i]);
           }
           
           for(int i=0;i<line.length;i++)
               System.out.print(line[i]+"\t");
           System.out.println();
           
           for(int i=0;i<line.length;i++)
               System.out.print(b[i]+"\t");
           
           Arrays.fill(b, 0);
           int i=0;
           b[0]=-1;
           j=-1;
           
           while(i<line.length){
              
               while(j>=0 && line[i]!=line[j])j=b[j];
               System.out.println(i+" - "+j);
               System.out.println(Arrays.toString(b));
               i++;
               j++;
                b[i]=j;
           }  

           System.out.println();
           
           for(i=0;i<line.length;i++)
               System.out.print(b[i]+"\t");
           
           
          

            b[0] = -1;
        for (i = 0; i < line.length; ++i) {
            b[i + 1] = b[i];
            while (b[i + 1] > -1  && line[b[i + 1]] != line[i])
             b[i+1] = b[b[i+1]];
             
            b[i+1]++;
        }

           System.out.println();
           
           for(i=0;i<line.length;i++)
               System.out.print(b[i]+"\t");
           
           //////////////////////Buscar
           char[] leer = in.readLine().toCharArray();
           j=0;
           for(i=0;i<leer.length;i++)
           {
               while(j>=0 && leer[i]!=line[j]) j=b[j];
               //System.out.println(j);
               if(++j==line.length){
                   System.out.println("Found in "+(i-j+1));
               j=b[j];
               }
               
           }
           System.out.println();
         }
        in.close();
        System.exit(0);
        
    }
}
