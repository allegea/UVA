/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro E. Garces
 */
public class PasswordSearch {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         Scanner inputLine = new Scanner (System.in);
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (inputLine.hasNext()) 
            {
                //StringTokenizer x = new StringTokenizer(line);
               //int n= Integer.parseInt(x.nextToken());
                int n=inputLine.nextInt();
               
               String input="";
               input=inputLine.next();
               /*
               if(x.hasMoreTokens()){
                   input= x.nextToken();
               }else{
                   System.out.println(input);
                   continue;
               }*/
               
               
               HashMap<String,Integer> pass = new HashMap<String,Integer>();
               int aux=1;
               int max = 0;
               String fre = "";
               String sub = "";
               for(int i=0;i<=input.length()-n;i++)
               {
                   sub = input.substring(i, i+n);
                   aux=1;
                   if(pass.containsKey(sub)){
                      aux= pass.get(sub)+1;
                   }
                   pass.put(sub, aux);
                   if(max<aux){
                       max=aux;
                       fre=sub;
                   }
                       
               }

               System.out.println(fre);
               
            }

        inputLine.close();
        System.exit(0);
        
    }
}
