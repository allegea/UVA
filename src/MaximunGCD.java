/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class MaximunGCD {

    public static int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           StringBuilder out = new StringBuilder();
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
               String[] read = in.readLine().split("[ ]+");
               int n=read.length;
               int[] vector = new int[n];
               for(int i=0;i<n;i++){
                   vector[i]=Integer.parseInt(read[i]);
               }
               
               int max = Integer.MIN_VALUE;
               for(int i=0;i<n;i++)
                   for(int j=i+1;j<n;j++)
                       max=Math.max(max, gcd(vector[i],vector[j]));
                
                System.out.println(max);
            }

            
        in.close();
        System.exit(0);
        
    }
}
