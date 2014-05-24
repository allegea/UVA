/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;



/**
 *
 * @author allegea
 */
public class LargestPrimeDivisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int n=10000000;
         int[] lpd = new int[n+1];
         int[] primes = new int[664580];
         primes[0]=1;
         int count=1;
         for(int i=2;i<=n;i++){
             if(lpd[i]==0)
             {   primes[count++]=i;
                 for(int j=2*i;j<=n;j+=i)
                     lpd[j]=i;
             }
         }

            //System.out.println(count);
                    /*for(int i=count-1;i>=count-1000;i--)
                        System.out.println(primes[i]);*/
           String line;
           StringBuilder out = new StringBuilder();
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line=in.readLine())!=null) 
            {
               long xx = Long.parseLong(line);
               long x=xx;
               if(x==0)break;
               long answer;
               int ind = 1;
               x=Math.abs(x);
               xx=Math.abs(xx);
              /* if(x<=n){
                   answer = lpd[(int)x];
               }else{*/
                   
                  // System.out.println(primes[ind]);
               int max=-1;
               TreeSet<Long> set = new TreeSet<Long>();
                   while(x!=1 && ind<664580){
                       if(x%primes[ind]==0)
                       {
                           x/=primes[ind];
                           set.add((long)primes[ind]);
                       }
                       else ind++;
                      // System.out.println(primes[ind]);
                   }
                   if(ind==664580)answer=x;
                   else {
                       if(set.size()<=1)answer=0;
                       else answer = set.last();
                   }
                   
                   if(answer==xx)answer=0;
               //}
               
               if(answer==0 || answer == 1)
                       answer=-1;
                   System.out.println(answer);
                
                
            }

            //System.out.print(out.toString());
        in.close();
        System.exit(0);
        
    }
}
