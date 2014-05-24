/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class DigitSum {

    public static long digits(int i)
    {
        long sum = 0;
        while(i!=0)
        {
            sum+=i%10;
            i/=10;
        }
        return sum;
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         int n = 100;
         long[] sums = new long[n];
         long[] inter = new long[n];
         for(int i=0;i<n;i++)
         {     sums[i]=digits(i);
                System.out.println(sums[i]);
         }
        System.out.println("************");
         
         for(int i=1;i<n;i++)
         {
            inter[i]=inter[i-1]+ sums[i];
                System.out.println(inter[i]+" - "+i);
         }
         
         System.out.println(inter[50]-inter[0]);
        
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
                String[] input = line.split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
                
            }

        in.close();
        System.exit(0);
        
    }
}
