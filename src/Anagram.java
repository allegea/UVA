/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Alejandro E. Garces
 */
public class Anagram {

    public static char[] letters; 
    //public static boolean[] visited;
    static long visited;
    public static StringBuilder out;
    static int position = 0;
    public static Set<String> hash;
    static int n;
   
    static void swap(char[] x, int i, int j)
    {
        char a = x[i];
        x[i] = x[j];
        x[j] = a;
    }
    
    static boolean nextPermutation(char[] c) {
        int n = c.length;
        int k = -1;
        for (int i = n - 2; i >= 0; --i) {
            if (c[i] < c[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return false;
        }
        int l = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (c[k] < c[i]) {
                l = i;
                break;
            }
        }
        swap(c, k, l);
        for (int i = k + 1; i < (n + k + 1) / 2; ++i) {
            swap(c, i, n + k - i);
        }
        return true;
    }
    public static void permute(char[] numbers, int size)
    {
           if(size == n)
           {
               String aux = String.valueOf(numbers);
               out.append(aux).append("\n");
               return;
           }
               
               for(int i=0;i<n;i++)
               {
                   //if(!visited[i])
                   if(((1<<i)&visited) == 0)
                   {
                    
                       visited|=(1<<i);
                      // visited[i] = true;
                      // numbers[size] = start[i];
                        numbers[size] = letters[i];
                       permute(numbers, size+1);
                      // visited[i] = false;
                       visited^=(1<<i);
                       
                   }
               }
           
    }

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         //boolean[] x = new boolean[2];
         //System.out.println(x[0]);
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                letters = in.readLine().toCharArray();
                Arrays.sort(letters);
                n = letters.length;
                //visited = new boolean[n];
                visited = 0;
                out = new StringBuilder();
                do{
                    out.append(String.valueOf(letters)).append("\n");
                }while(nextPermutation(letters));
                System.out.print(out);
                /*for(int i=0;i<letters.length;i++)
                    start[i] = i;*/
               /* out = new StringBuilder();
                permute(new char[n], 0);
                    System.out.print(out);*/
                
            }

        in.close();
        System.exit(0);
        
    }
}
