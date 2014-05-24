/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */
public class Permutations {

   static boolean nextPermutation(char[] c) {
        int n = c.length;
        int k = -1;
        for (int i = n - 2; i >= 0; --i) {
            if (c[i] < c[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1)
            return false;
        int l = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (c[k] < c[i]) {
                l = i;
                break;
            }
        }
        char tmp = c[k];
        c[k] = c[l];
        c[l] = tmp;
        for (int i = k + 1; i < (n + k + 1) / 2; ++i) {
            tmp = c[i];
            c[i] = c[n + k - i];
            c[n + k - i] = tmp;
        }
        return true;
    }gdfd
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         long x = 2432902008176640000l;
         //int cases =  Integer.parseInt(in.readLine());
         int cases = 1;
            while (cases-->0) 
            {
               //char[] input = in.readLine().toCharArray();
                char[] input = "abcde".toCharArray();
               Arrays.sort(input);
               
               //long n = Long.parseLong(in.readLine());
               long n = 122;
               System.out.println(input);
               System.out.println("***");
               
               for(long i=0;i<n;i++){
                   System.out.println(i+" - "+String.valueOf(input));
                   nextPermutation(input);
                   
                   
               }
               
               
               
                   
                
            }

        in.close();
        System.exit(0);
        
    }
}
