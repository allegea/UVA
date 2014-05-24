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
public class Newspaper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
           while (act++<cases) 
            {
           int paids = Integer.parseInt(in.readLine());
           HashMap<Character,Integer> dicc = new HashMap<Character,Integer>();
           
           for(int i=0;i<paids;i++)
           {
               StringTokenizer news = new StringTokenizer(in.readLine().trim());
               dicc.put(news.nextToken().charAt(0), Integer.parseInt(news.nextToken()));
               
           }
           long paid=0;
            
               int lines = Integer.parseInt(in.readLine());
               paid=0;
               for(int i=0;i<lines;i++)
               {
                   char[] letters = in.readLine().toCharArray();
                   
                   for(int j=0;j<letters.length;j++){
                       if(dicc.containsKey(letters[j])){
                          paid+=dicc.get(letters[j]); 
                       }
                           
                           
                   }
                   
               }
                System.out.printf(Locale.ENGLISH,"%1.2f$\n",(paid)/100.0);
                
            }
            

        in.close();
        System.exit(0);
        
    }
}
