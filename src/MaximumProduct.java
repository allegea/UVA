/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro E. Garces
 */
public class MaximumProduct {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           int cases = 1;
            while ((line = in.readLine()) != null) 
            {
               int n= Integer.parseInt(line);
               int[] numbers = new int[n];
               StringTokenizer x = new StringTokenizer(in.readLine());
               for(int i=0;i<n;i++)
               numbers[i]=Integer.parseInt(x.nextToken());
               
               //System.out.println(Arrays.toString(numbers));
               long max = 0;
                for (int k = 0; k < n; k++) {
                    for (int i = 0; i <= k; i++) {
                        long maxA = 1;
                        for (int j = i; j <= k; j++) {
                            maxA *= numbers[j];
                        }
                        max = Math.max(max, maxA);
                    }
                }
               
               System.out.println("Case #"+(cases++)+": The maximum product is "+max+".\n");
                
                in.readLine();
            }

        in.close();
        System.exit(0);
        
    }
}
