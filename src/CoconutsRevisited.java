/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.TreeSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class CoconutsRevisited {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
          BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        /* BitSet criba = new BitSet();
         criba.set(0);
         criba.set(1);
         for(int i=2;i*i<=1000000;i++)
             if(!criba.get(i))
             {
                 for(int j=i*2;j<=1000000;j+=i)
                     criba.set(j);
             }
          criba.set(2);       */
         //System.out.println(2%2);
         
           String line;
           TreeSet<Integer> divisors;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           int aux=0;
           int i=0;
           int coco = 0;
            while ((line = in.readLine()) != null) 
            {
                String[] input = line.split("[ ]+");
               int n= Integer.parseInt(input[0]);
               if(n<0)break;
               
               coco = n;
               aux=n-1;
              /* if(coco == 0 || !criba.get(aux))
               {
                   System.out.println(n+" coconuts, no solution");
                   continue;
               }
               if(coco==1)
               {
                   System.out.println(coco+" coconuts, 1 people and 1 monkey");
                   continue;
               }*/
               divisors = new TreeSet<Integer>();
               for(i=1;i*i<=aux;i++)
               {
                   if((aux)%i==0){
                      divisors.add(i);
                       divisors.add((aux)/i);
                   }
               }
               //System.out.println(divisors);
               aux = 0;
               int answer=0;
               boolean continu = false;
               while(divisors.size()>1)
               {
                   n=coco;
                   aux=0;
                   answer = divisors.pollLast();
                   while(aux<answer)
                   {
                       aux++;
                      // System.out.println(answer+" - "+n+" - "+aux);
                       if((n)%answer==1)
                           n-=(1+n/answer);
                       else break;
                   }
                   // System.out.println(answer+" - "+n+" - "+aux+"**");
                   if( aux==answer && n%answer==0)
                   {
                       continu = true;
                       break;
                   }
               }
               
               //System.out.println(continu+" - "+divisors.isEmpty());
               if(continu)
                   System.out.println(coco+" coconuts, "+answer+" people and 1 monkey");
               else System.out.println(coco+" coconuts, no solution");
               
               
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
