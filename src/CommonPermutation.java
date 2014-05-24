/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class CommonPermutation {

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
            while (in.ready()) 
            {
               int[] alpha = new int[26];
                int[] alpha1 = new int[26];
                int[] alpha2 = new int[26];
                char[] a = in.readLine().toCharArray();
                char[] b = in.readLine().toCharArray();
                
                for(int i=0;i<a.length;i++)
                   if(Character.isLetter(a[i]))
                       alpha1[a[i]-97]++;
                
               for(int i=0;i<b.length;i++)
                   if(Character.isLetter(b[i]))
                   alpha2[b[i]-97]++;
               
               /*for(int i=0;i<26;i++)
               {
                   alpha[i]=alpha1[i]+alpha2[i];
                   System.out.println((char)(97+i)+" - "+alpha[i]);
               }*/
               /*
               int fre = 0;
               for(int i=0;i<26;i++)
                   if(alpha[i]>fre)
                       fre=alpha[i];*/
               

               for(int i=0;i<26;i++)
//                   if(alpha[i]==fre)
//                       if(alpha1[i]!=0 && alpha2[i]!=0)
                           for(int j=0;j<Math.min(alpha1[i], alpha2[i]);j++)
                           System.out.print((char)(97+i));
               
               System.out.println();
            }

            
        in.close();
        System.exit(0);
        
    }
}
