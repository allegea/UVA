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
public class WERTYU {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         char[] le = "wqewretrytuyiuoipo[p][sadsfdgfhgjhkjlk;lxzcxvcbvnbmn,m.,/.';213243546576879809-0=-".toUpperCase().toCharArray();
         Map<Character,Character> werty = new HashMap<Character,Character>();
         for(int i=0;i<le.length-1;i+=2)
             werty.put(le[i], le[i+1]);

         werty.put(' ',' ');
         //System.out.println(werty);
         
           String line;
           
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
                StringBuilder out = new StringBuilder();
               char[] mess = line.toCharArray();
               for(int i=0;i<mess.length;i++)
               {
                  out.append(werty.get(mess[i]));
               }
                
               System.out.println(out);
                
            }

            
        in.close();
        System.exit(0);
        
    }
}
