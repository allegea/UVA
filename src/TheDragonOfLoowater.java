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
public class TheDragonOfLoowater {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int[] heads;
         int[] heigths;
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               
               if(n == 0 && m == 0)break;
               
               long answer = 0;
               heads = new int[n];
               heigths = new int[m];
               
               for(int i=0;i<n;i++)
                   heads[i] = Integer.parseInt(in.readLine());
               
               for(int i=0;i<m;i++)
                   heigths[i] = Integer.parseInt(in.readLine());
               
               Arrays.sort(heads);
               Arrays.sort(heigths);
               
               int j = 0, i = 0;
               for(i=0;i<n;i++)
               {
                   while(j<m && heigths[j]<heads[i])j++;
                   
                   if(j<m)answer+=heigths[j++];
                   else break;
               }
               
               System.out.println(i==n?answer:"Loowater is doomed!");
                   
            }

        in.close();
        System.exit(0);
        
    }
}
