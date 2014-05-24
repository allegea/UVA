/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */
public class AirportSetup {
Dijkstra
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         ArrayList<Integer>[] nodos;
         boolean[] alreadyHave;
         boolean[] visited;
         long[] lengths;
         Queue<Integer> queue;
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               int k= Integer.parseInt(input[2]);
               n++;
               nodos = new ArrayList[n];
               alreadyHave = new boolean[n];
               visited = new boolean[n];
               
               for(int i=1;i<n;i++)
                   nodos[i] = new ArrayList<Integer>();
               
               input = in.readLine().split("[ ]+");
               
               for(int i=0;i<input.length;i++)
               alreadyHave[Integer.parseInt(input[i])] = true;
               
               System.out.println(Arrays.toString(alreadyHave));
               for(int i=0;i<m;i++)
               {
                   input = in.readLine().split("[ ]+");
                   int u = Integer.parseInt(input[0]);
                   int v = Integer.parseInt(input[1]);
                   nodos[u].add(v);
                   nodos[v].add(u);
               }
               
               int q = Integer.parseInt(in.readLine());
               
               for(int i=0;i<q;i++)
               {
                   long answer = Integer.MAX_VALUE;
                   visited = new boolean[n];
                   lengths = new long[n];
                   
                   input = in.readLine().split("[ ]+");
                   int u = Integer.parseInt(input[0]);
                   int v = Integer.parseInt(input[1]);
                   queue = new LinkedList<Integer>();
                   
                   queue.offer(u);
                   visited[u] = true;
                   if(!alreadyHave[u])lengths[u] = 1;
                   
                   while(!queue.isEmpty())
                   {
                       u = queue.poll();
                       System.out.println(u+" --");
                       if(u == v)
                       {
                           answer = Math.min(lengths[u], answer);
                           continue;
                       }
                       
                       for(int x:nodos[u])
                       {
                           if(!visited[x])
                           {
                               visited[x] = true;
                               lengths[x] = lengths[u];
                               if(!alreadyHave[x]) lengths[x]++;
                               queue.offer(x);
                           }
                       }
                   }
                   System.out.println(Arrays.toString(lengths));
                   System.out.println(answer);
               }
               
               
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
