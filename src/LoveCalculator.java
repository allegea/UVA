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
public class LoveCalculator {

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
            while ((line = in.readLine()) != null) 
            {
                
               int first = 0;
               line=line.toLowerCase();
               char[] aux = line.toCharArray();
               
               for(int i=0;i<aux.length;i++)
               {
                   if(Character.isLetter(aux[i]))
                   {
                       first+=(aux[i]-96);
                       //System.out.println(aux[i]+" - "+(aux[i]-96));
                   }
               }
               
               
               int second = 0;
               String line2=in.readLine();
               line2=line2.toLowerCase();
               char[] aux2 = line2.toCharArray();
               //System.out.println(aux2);
               
               for(int i=0;i<aux2.length;i++)
               {
                   if(Character.isLetter(aux2[i]))
                   {
                       second+=(aux2[i]-96);
                       //System.out.println(aux2[i]+" - "+(aux2[i]-96));
                   }
               }
               
              // System.out.println(first+" "+second);
               int w1 = 0;
               while(true)
               {
                   
                   while(first!=0)
                   {
                      w1+=first%10;
                      first/=10;
                   }
                    //System.out.println(w1);
                   if(w1<10)break;
                   else
                   {
                       
                       first=w1;
                       w1=0;
                   }
                   
               }
               
                int w2 = 0;
               while(true)
               {
                   
                   while(second!=0)
                   {
                      w2+=second%10;
                      second/=10;
                   }
                   // System.out.println(w2);
                   if(w2<10)break;
                   else
                   {
                       
                       second=w2;
                       w2=0;
                   }
                   
               }
               //System.out.println(w1+" "+w2);
              
               System.out.printf(Locale.ENGLISH, "%.2f ",(Math.min(w1,w2)/(float)Math.max(w1, w2))*100);
               System.out.println("%");
               
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
