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
public class WordScramble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
            while ((line = in.readLine()) != null) 
            {
               StringTokenizer words = new StringTokenizer(line);
               
               int one = 1;
               while(words.hasMoreTokens())
               {
                   if(one!=1)System.out.print(" ");
                   one=0;
                   char[] s = words.nextToken().toCharArray();
                   for(int i=s.length-1;i>=0;i--)
                       System.out.print(s[i]);
               }
               System.out.println();
                               
            }
            

        in.close();
        System.exit(0);
        
    }
}
