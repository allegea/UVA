/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;



/**
 *
 * @author allegea
 */
public class WordAmalgamation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

       HashMap<String, TreeSet<String>> map = new HashMap<String,TreeSet<String>>();
            String line="";
            char[] words;
            String initial="";
            TreeSet<String> aux;
            while (!(line=in.readLine()).equals("XXXXXX")) 
            {
              words = line.toCharArray();
              Arrays.sort(words);
              initial = "";
              for(int i=0;i<words.length;i++)
              initial+=words[i];
              System.out.println(initial);
              if(map.containsKey(initial)){
                  map.get(initial).add(line);
              }else {
                  aux = new TreeSet<String>();
                  aux.add(line);
                  map.put(initial,aux);
              }
                  
                  
            }
            
            while (!(line=in.readLine()).equals("XXXXXX")) 
            {
              words = line.toCharArray();
              Arrays.sort(words);
              initial = "";
              for(int i=0;i<words.length;i++)
              initial+=words[i];
              if(map.containsKey(initial)){
                  
                  aux = map.get(initial);
                  for(String x:aux){
                      System.out.println(x);
                  }
                  
              }else {
                  System.out.println("NOT A VALID WORD");
                 }
               System.out.println("******");
            }
            
            
            //System.out.println(map);
              

            //System.out.print(out.toString());
        in.close();
        System.exit(0);
        
    }
}
