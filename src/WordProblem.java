/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;



/**
 *
 * @author allegea
 */
public class WordProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
       // BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
    
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           HashMap<Character,Integer> aux;
           ArrayList<HashMap<Character, Integer>> dicc = new ArrayList<HashMap<Character, Integer>>();
           while(!"#".equals(line=in.readLine()))
           {
               int[] fre = new int[26];
               char[] letters = line.toCharArray();
               for(int i=0;i<letters.length;i++)
                   fre[letters[i]-97]++;
               
               aux = new HashMap<Character,Integer>();
               
               for(int i=0;i<26;i++)
                       aux.put((char)(i+97), fre[i]);
               
               dicc.add(aux);
               
               //System.out.println("fff");
               
           }
           
            while(!"#".equals(line = in.readLine()))
            {
                int count = 0;
               int[] fre = new int[26];
               char[] letters = line.toCharArray();
               for(int i=0;i<letters.length;i++)
                   if(Character.isLetter(letters[i]))
                       fre[letters[i]-97]++;
                
               boolean canbe = true;
               for(int i=0;i<dicc.size();i++){
                   canbe=true;
                   aux = new HashMap<Character,Integer>(dicc.get(i));
                   for(int j=0;j<26;j++)
                       if(aux.get((char)(j+97))>fre[j]){
                           canbe=false;
                           break;
                       }
                   if(canbe)
                       count++;
               }
                System.out.println(count);
            }

            
        in.close();
        System.exit(0);
        
    }
}
