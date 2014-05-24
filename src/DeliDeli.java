/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.HashMap;



/**
 *
 * @author allegea
 */
public class DeliDeli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
       // BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           String[] input = in.readLine().split("[ ]+");
           
           int n = Integer.parseInt(input[0]);
           HashMap<String, String> irregular = new HashMap<String,String>();
           
           String[] aux;
           for(int i=0;i<n;i++){
               aux = in.readLine().split("[ ]+");
               irregular.put(aux[0], aux[1]);
           }
           
           n = Integer.parseInt(input[1]);
           String read;
           for(int i=0;i<n;i++){
                read = in.readLine();
                if(irregular.containsKey(read)){
                    System.out.println(irregular.get(read));
                    continue;
                }
                int length = read.length();
                if(read.charAt(length-1)=='y' && read.charAt(length-2)!='a' && read.charAt(length-2)!='e' && read.charAt(length-2)!='i'&& read.charAt(length-2)!='o' && read.charAt(length-2)!='u' ){
                   System.out.println(read.substring(0, length-1)+"ies");
                }
                else if(read.charAt(length-1)=='o' || read.charAt(length-1)=='s' || read.endsWith("ch") || read.endsWith("sh") || read.charAt(length-1)=='x')
                System.out.println(read+"es");
                else System.out.println(read+"s");
                    
           }
               

        in.close();
        System.exit(0);
        
    }
}
