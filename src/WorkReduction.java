/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class WorkReduction {

    public static class Pair implements Comparable {

        int pos;
        long value;
        String name;
        Pair(int p, long v, String n){
            this.pos = p;
            this.value = v;
            this.name = n;
        }
        @Override
        public int compareTo(Object o) {
            return (int)(this.value - ((Pair)o).value);
        }
        
    }
    
    static long findMin(int A, int B, int n, int m)
    {
        int a = 0, b = 0;
        
               while(n/2>=m){
                   int aux = (n-n/2); 
                   if(aux>0)
                   if(aux*A<B){
                      // System.out.println("**"+aux+"-"+n);
                       break;
                   }
                   n/=2;
                   b++;
               }
        a = n-m;
       // System.out.println("Find "+A+"-"+B+"-"+a+"-"+b+"-- "+(A*a+b*B));
        return A*a+b*B;
        
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         Pair[] plans;
         TreeSet<String> names;
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               int agen= Integer.parseInt(input[2]);

               plans = new Pair[agen];
               for(int i=0;i<agen;i++)
               {
                   input = in.readLine().split("\\W");
                   plans[i] = new Pair(i, findMin(Integer.parseInt(input[1]), Integer.parseInt(input[2]), n, m),input[0]);
               }
               
              // System.out.println(Arrays.toString(plans));
               Arrays.sort(plans);
               
               System.out.println("Case "+act);
              
                   
               for(int i=0;i<agen;i++)
               {
                   long value = plans[i].value;
                   names =  new TreeSet<String>();
                   names.add(plans[i].name);
                   int j=i+1;
                   while(j<agen)
                   {
                       if(plans[j].value == value)
                       {
                           names.add(plans[j].name);
                           j++;
                       }else break;
                   }   
                   
                   for(String x:names)
                   {
                       System.out.println(x+" "+value);
                   }
                       
                  i=j-1;     
                   
               }
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
