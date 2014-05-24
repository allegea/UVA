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
public class ForeignExchange {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         HashMap<String, Integer> count;
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
               int n= Integer.parseInt(in.readLine());
               if(n == 0)break;
               
               
               count = new HashMap<String, Integer>();
               for(int i=0;i<n;i++)
               {
                   line = in.readLine();
                   String[] read = line.split("[ ]+");
                   int u = Integer.parseInt(read[0]);
                   int v = Integer.parseInt(read[1]);
                   String aux = v+" "+u;
                  // System.out.println(count);
                   if(count.containsKey(aux))
                   {
                       int fre = count.get(aux);
                       fre--;
                       if(fre == 0)
                       count.remove(aux);
                       else count.put(aux, fre);
                   }else{
                       
                       int fre = 1;
                       if(count.containsKey(line))
                           fre += count.get(line);
                       count.put(line, fre);
                       
                   }
               }

               System.out.println(count.size()==0?"YES":"NO");
            }

        in.close();
        System.exit(0);
        
    }
}

/*
 * //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         LinkedHashMap<Integer,LinkedHashMap<Integer, Integer>> nodes;
         LinkedHashMap<Integer, Integer> aux;
         
           String line;

            while (true) 
            {
               int n= Integer.parseInt(in.readLine());
               if(n == 0)break;
               
               nodes = new LinkedHashMap<Integer,LinkedHashMap<Integer, Integer>>();
               
               for(int i=0;i<n;i++)
               {
                   String[] read = in.readLine().split("[ ]+");
                   int u = Integer.parseInt(read[0]);
                   int v = Integer.parseInt(read[1]);
                   
                   if(nodes.containsKey(u))
                   {
                       aux = nodes.get(u);
                       if(aux.containsKey(v))
                        {
                            int frec = aux.get(v);
                            aux.put(v, ++frec);
                        }else aux.put(v, 1);
                       nodes.put(u, aux);
                   }else{
                       aux = new LinkedHashMap<Integer, Integer>();
                       aux.put(v, 1);
                       nodes.put(u, aux);
                   }
               }
               
               boolean answer = true;

               for(int i:nodes.keySet())
               {

                   for(int j:nodes.get(i).keySet())
                   {
                      // System.out.println(i+" - "+j+" - "+nodes);
                       if(nodes.get(i).get(j) == 0)continue;
                       
                      // aux2 = nodes.get(j);
                       if(nodes.containsKey(j) && nodes.get(j).containsKey(i) && nodes.get(j).get(i) > 0)
                       {
                           if(nodes.get(j).get(i) == nodes.get(i).get(j))
                           {
                               nodes.get(j).put(i, 0);
                               nodes.get(i).put(j, 0);
                           }else answer = false;
     
                       }else answer = false;
                       
                       if(!answer)break;
                   }
                   if(!answer)break;
               }
               
               System.out.println(answer?"YES":"NO");
            }

        in.close();
        System.exit(0);
 */