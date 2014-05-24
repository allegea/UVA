/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class Babelfish {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         HashMap<String, String> dictionary = new HashMap<String, String>();
         String line = "";
         StringTokenizer st;
         while(( line = in.readLine()) !=null && line.length() > 0)
         {
             st = new StringTokenizer(line);
             String u = st.nextToken();
             String v = st.nextToken();
             dictionary.put(v, u);
         }
         
         while(( line = in.readLine()) !=null && line.length() > 0)
         {
             if(dictionary.containsKey(line))
                 System.out.println(dictionary.get(line));
             else System.out.println("eh");
         }
             
         
         in.close();
         System.exit(0);
     }
}
