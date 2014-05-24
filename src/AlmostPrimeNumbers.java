/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class AlmostPrimeNumbers {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
         BitSet criba = new BitSet();
         criba.set(0);
         criba.set(1);
         for(int i=2;i*i<=20000000;i++)
             if(!criba.get(i))
                 for(int j=i*2;j<=20000000;j+=i)
                     criba.set(j);
         System.out.println(criba.cardinality());
         int count = 0;
         
         long[] almost = new long[80070];
         
         for(long i=2;i<=1000000l;i++)
             if(!criba.get((int)i))
                 for(long j=i*i;j<=1000000000000l;j*=i)
                     almost[count++]=j;

         Arrays.sort(almost);
         //System.out.println("-- "+count);
        // System.out.println(Arrays.toString(almost));
         
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
           String line;

           int cases = Integer.parseInt(in.readLine());
           int now = 0;
            while (now++<cases) 
            {
                String[] read = in.readLine().split("[ ]+");
                long a = Long.parseLong(read[0]);
                long b = Long.parseLong(read[1]);

                int ans = 0;
                for(int i=0;i<almost.length;i++){
                    if(almost[i]>=a && almost[i]<=b)
                        ans++;
                    else if(almost[i]>b)break;
                   // System.out.println("-- "+almost[i]);
                }
                System.out.println(ans);
                
              
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
