/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Alejandro E. Garces
 */
public class ExpensiveSubway {

    static int Sets;

        static int[] id;
        static int[] size;
        static int n;
        
        public static void init(int m)
        {
            n = m;
            id = new int[n];
            size = new int[n];
            Sets = n;
            for(int i=0;i<n;i++)
            {
                id[i] = i;
                size[i] = 1;
            }
        }
        
        static int root(int i)
        {
            return id[i] == i?i:(id[i] = root(id[i]));
        }
        static boolean same(int i, int j)
        {
            return root(i) == root(j);
        }
        
        static void union(int i, int j)
        {
            int u = root(i);
            int v = root(j);
            
            if(u == v)return;
            
            if(size[u]<size[v])
            {
                id[u] = v;
                size[v]+=size[u];
            }else{
                id[v] = u;
                size[u]+=size[v];
            }
            Sets--;
        }
    
    
    public static class Edge implements Comparable {

        public Edge(int w, int a, int b) {
            this.w = w;
            this.a = a;
            this.b = b;
        }
        
        int w;
        int a, b;

        @Override
        public int compareTo(Object o) {
           return w -((Edge)o).w;
        }

        @Override
        public String toString() {
            return w+"**"+a+"**"+b;
        }
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         //PriorityQueue<Edge> edges;
         //ArrayList<Edge> edges;
         Edge[] edges;
         HashMap<String, Integer> mapNames;

         long min;
         

           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               
               if(n == 0 && m == 0)break;

               edges = new Edge[m];
               init(n);
               mapNames = new HashMap<String, Integer>();
               min = 0;
               for(int i=0;i<n;i++)
               mapNames.put(in.readLine(),i);
                   
               for(int i=0;i<m;i++)
               {
                   input = in.readLine().split("[ ]+");
                   int a = mapNames.get(input[0]);
                   int b = mapNames.get(input[1]);
                   int c = Integer.parseInt(input[2]);
                   edges[i] = new Edge(c, a, b);
               }
               
               Arrays.sort(edges);
               in.readLine();
               for(Edge aux: edges)
               {
                  // System.out.println(aux);
                   if(!same(aux.a, aux.b))
                   {
                    
                    min+=aux.w;
                    union(aux.a, aux.b);
                    if(Sets<=1)break;
                   }
               }
               
               if(Sets>1)System.out.println("Impossible");
               else System.out.println(min);
               
               //System.out.println(total-min);
                
            }

        in.close();
        System.exit(0);
        
    }
}
