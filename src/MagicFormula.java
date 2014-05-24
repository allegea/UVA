/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class MagicFormula {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         
            while (true) 
            {
               String[] input = in.readLine().split("[ ]+");
               int a= Integer.parseInt(input[0]);
               int b= Integer.parseInt(input[1]);
               int c= Integer.parseInt(input[2]);
               int d= Integer.parseInt(input[3]);
               int l= Integer.parseInt(input[4]);
               if(a==0 && b==0 && c==0 && d==0 && l==0)
                   break;
               
               int count=0;
               for(int i=0;i<=l;i++){
                   if((a*i*i+b*i+c)%d==0)
                       count++;
               }
               
               
               System.out.println(count);
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
