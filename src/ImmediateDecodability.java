/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;




/**
 *
 * @author allegea
 */
public class ImmediateDecodability {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           
           
           
           StringBuilder out = new StringBuilder();
           
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           int act = 0;
            while (in.ready()) 
            {
                String[] codes = new String[10];
                int n=0;
               while(!"9".equals((line=in.readLine())))
                   codes[n++]=line;
               
               boolean pref = false;
               
               //Arrays.sort(codes, 0, n);
               
               for(int i=0;i<n-1;i++){
                  // System.out.println(codes[i]);
                   for(int j=i+1;j<n;j++)
                       if(codes[i].startsWith(codes[j]) || codes[j].startsWith(codes[i])){
                           pref=true;
                          // System.out.println(codes[i]+" - "+codes[j]);
                           break;
                       }
                   if(pref)
                       break;
                           
               }
               
               if(!pref)System.out.println("Set "+(++act)+ " is immediately decodable");
               else System.out.println("Set "+(++act)+ " is not immediately decodable");
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
