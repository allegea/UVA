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
public class StationBalance {

    public static class pair implements Comparable{

        int pos = -1;
        int value = -1;
        
        pair(int p, int v)
        {
            pos = p;
            value = v;
        }
        @Override
        public int compareTo(Object o) {
            return this.value - ((pair)o).value;
        }
        
        
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         pair[] mass;
         pair[] print;
         double avg;
         double inva;
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           int cases = 1;
            while ((line = in.readLine()) != null) 
            {
                String[] input = line.split("[ ]+");
               int c= Integer.parseInt(input[0]);
               int s= Integer.parseInt(input[1]);
               avg = 0;
               
               int m = s/2;
               mass = new pair[s];
               print = new pair[c];
               
               input = in.readLine().split("[ ]+");
               for(int i=0;i<input.length;i++)
               {
                   mass[i] = new pair(i,Integer.parseInt(input[i]));
                   avg+=mass[i].value;
               }
               
               avg/=c;
               
               Arrays.sort(mass);
               inva = 0;
               
               if(c<s){
               for(int i=0;i<m;i++)
               {
                   //System.out.println(mass[i].value+" - "+mass[2*m-1-i].value+" - "+Math.abs(mass[i].value+mass[2*m-1-i].value-avg));
                   inva+=Math.abs(mass[i].value+mass[2*m-1-i].value-avg);
                   int pos = Math.min(mass[i].pos, mass[2*m-1-i].pos);
                   
                   if(pos == mass[i].pos)
                   print[pos] = new pair(mass[i].value, mass[2*m-1-i].value);
                   else
                   print[pos] = new pair( mass[2*m-1-i].value, mass[i].value);
               }
               
               if(2*m < s){
                  // System.out.println(mass[2*m].value+" | "+Math.abs(mass[2*m].value-avg));
                   print[mass[2*m].pos] = new pair(mass[2*m].value, -1);
                   inva+=Math.abs(mass[2*m].value-avg);
               }
               }
               else
               {
                   for(int i=0;i<c;i++)
                   {
                       if(i<s){
                       print[mass[i].pos] = new pair(mass[i].value,-1);
                       inva+=Math.abs(mass[i].value-avg);
                       }else
                       {
                            print[i] = new pair(-1,-1);
                            inva+=avg;
                       }
                   }
                  
               }
               
              // System.out.println("Inva = "+inva+" , avg = "+avg);
                
               System.out.println("Set #"+(cases++));
               int ch = 0;
               for(int i=0;i<c;i++)
                   if(print[i]!= null)
                   {
                       if(print[i].pos == -1){
                         System.out.println(" "+(ch++)+":");  
                         continue;
                       }
                       if(print[i].value != -1)
                       System.out.println(" "+(ch++)+": "+print[i].pos+" "+print[i].value);
                       else System.out.println(" "+(ch++)+": "+print[i].pos); 
                   }
              
               System.out.printf("IMBALANCE = %.5f\n\n", inva);
            }

        in.close();
        System.exit(0);
        
    }
}
