/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;



/**
 *
 * @author allegea
 */
public class Tellmethefrequencies {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         

           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           int act =0;
            while (in.ready()) 
            {
                if(act++>0)System.out.println();
                
                int[] ascii = new int[1000];
                
               char[] read = in.readLine().toCharArray();
               
               for(int i=0;i<read.length;i++)
                ascii[read[i]]++;             
          
              
               TreeMap<Integer,TreeSet<Integer>> frex = new TreeMap<Integer,TreeSet<Integer>>();
               
               TreeSet<Integer> aux;
               
               for(int i=0;i<1000;i++)
               {
                   if(frex.containsKey(ascii[i]))
                       frex.get(ascii[i]).add(i);
                       else{
                       
                       aux = new TreeSet<Integer>();
                       aux.add(i);
                       frex.put(ascii[i], aux);
                   }
               }
               
              Entry<Integer,TreeSet<Integer>> aux1;
               
               while(!frex.isEmpty()){
                   aux1 = frex.pollFirstEntry();
                   int key = aux1.getKey();
                   if(key!=0){
                       aux = new TreeSet<Integer>(aux1.getValue());
                       while(!aux.isEmpty())
                         System.out.println(aux.pollLast()+" "+key);  
                   }
                       
               }
                
                
            }

            
        in.close();
        System.exit(0);
        
    }
}
