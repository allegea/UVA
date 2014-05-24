/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro E. Garces
 */
public class BigBigRealNumbers {

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
               String[] read = in.readLine().split("[ ]+"); 
               BigDecimal a = new BigDecimal(read[0]);
               BigDecimal b = new BigDecimal(read[1]);
               String aux = a.add(b).toString();
              /*if(aux.indexOf(".")==-1)
                  aux+=".0";*/
               if(aux.indexOf('.')!=-1){
                   
                   char[] array = aux.toCharArray();
                   int n = aux.length()-1;
                   while(n>=0 && array[n]=='0')n--;
                   
                   if(array[n]=='.')
                       aux = aux.substring(0, n+1)+"0";
                   else aux = aux.substring(0,n+1);
                   
               }else aux+=".0";
               System.out.println(aux);
                
            }

        in.close();
        System.exit(0);
        
    }
}
