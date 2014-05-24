/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.BitSet;



/**
 *
 * @author allegea
 */
public class PrimeFrecuency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
        
        BitSet criba = new BitSet();
        criba.set(0);
        criba.set(1);
        //criba.set(2);
        for(int i=2;i*i<=2001;i++)
            if(!criba.get(i))
                for(int j=2*i;j<=2001;j+=i)
                    criba.set(j);
       
        
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                StringBuilder out = new StringBuilder();
               int[] numbers = new int[10];
               int[] Uletters = new int[26];
               int[] Lletters = new int[26];
               
               char[] read = in.readLine().toCharArray();
               for(int i=0;i<read.length;i++){
                   if(Character.isDigit(read[i]))
                       numbers[read[i]-48]++;
                   if(Character.isLowerCase(read[i]))
                       Lletters[read[i]-97]++;
                   if(Character.isUpperCase(read[i]))
                       Uletters[read[i]-65]++;
               }
               
               int count=0;
               out.append("Case ").append(act).append(": ");
               for(int i=0;i<10;i++){
                   if(!criba.get(numbers[i])){
                       out.append(i);
                       count++;
                       
                   }
               }
               
               for(int i=0;i<26;i++){
                   if(!criba.get(Uletters[i])){
                       out.append((char)(65+i));
                       count++;
                       
                   }
               }
               
               for(int i=0;i<26;i++){
                   if(!criba.get(Lletters[i])){
                       out.append((char)(97+i));
                       count++;
                       
                   }
               }
               
               if(count==0)
                   out.append("empty");
               
               System.out.println(out);
                
                
            }

           
        in.close();
        System.exit(0);
        
    }
}
