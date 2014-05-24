/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 *
 * @author Alejandro E. Garces
 */
public class PermutationArray {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         

         //System.out.println(Long.parseLong("12",10));
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           boolean first = true;
            while (cases-->0) 
            {
                in.readLine();
                if(!first)
                {
                    System.out.println();
                }
                
                first = false;
                
                TreeMap<Integer,String> numbers = new TreeMap<Integer,String>();
                String[] position = in.readLine().split("[ ]+"); 
                String[] permut = in.readLine().split("[ ]+");
                
                for(int i=0;i<position.length;i++){
                    numbers.put(Integer.parseInt(position[i]),permut[i]);
                }
                Entry<Integer,String> out;
                while(!numbers.isEmpty()){
                    out = numbers.pollFirstEntry();
                    System.out.println(out.getValue());
                }
                
                

            }
            
            

        in.close();
        System.exit(0);
        
    }
}
