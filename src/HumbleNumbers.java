/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class HumbleNumbers {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         TreeSet<Long> humble = new TreeSet<Long>();
         //ArrayList<Long> answer = new ArrayList<Long>();
         long[] ans = new long[5843];
         humble.add(1l);
         int count=0;
         long aux=0;
         while(count<5842)
         {
             
             aux = humble.pollFirst();
             //System.out.println(count+" - "+aux);
             ans[count++]=aux;
             //count++;
            // answer.add(aux);
             humble.add(aux*2);
             humble.add(aux*3);
             humble.add(aux*5);
             humble.add(aux*7);
             
         }
    
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                int n = Integer.parseInt(in.readLine());
                if(n==0)break;
                
                //long output = ans[n-1];
                String suf = "";
                long mod10 = n%10;
                long mod100= n%100;
                //System.out.println(mod10+" - "+mod100);
                if(mod10==1 && mod100!=11)
                    suf="st";
                else if(mod10==2 && mod100!=12)
                    suf="nd";
                else if(mod10==3 && mod100!=13)
                    suf="rd";
                else suf="th";
                
                System.out.println("The "+n+suf+" humble number is "+ans[n-1]+".");
            }
        in.close();
        System.exit(0);
        
    }
}
