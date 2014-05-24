/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro E. Garces
 */
public class AgeSort {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         StringBuilder output = new StringBuilder();
         boolean count=false;
            while (true) 
            {
                
               int n= Integer.parseInt(in.readLine());
               if(n==0)break;
               
               if(count){
                   output.append("\n");
               }
               count=true;
               int[] numbers = new int[n];
               int i=0;
               StringTokenizer x = new StringTokenizer(in.readLine());
               while(x.hasMoreTokens()){
                   numbers[i++]=Integer.parseInt(x.nextToken());
               }
               
               Arrays.sort(numbers);
               
               output.append(numbers[0]);
                if (n != 1) {

                    for (i = 1; i < n; i++) {
                        output.append(" ").append(numbers[i]);
                    }
                }
    
            }
            
            System.out.println(output);

        in.close();
        System.exit(0);
        
    }
}
