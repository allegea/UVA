/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author Alejandro E. Garces
 */
public class SendingEmail {
    
    public static class Edge implements Comparable{

       public long weight;
       public int v;
        
        public Edge(int vI, long we)
        {
            v= vI;
            weight = we;
        }

        @Override
        public int compareTo(Object o) {
            return (int)(this.weight - ((Edge)o).weight);
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
         ArrayList[] nodes;
         boolean[] explored;
         long[] distance;
         PriorityQueue<Edge> queue;
         Edge auxU;
         Edge auxV;
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               int s= Integer.parseInt(input[2]);
               int t= Integer.parseInt(input[3]);
               int u,v,we;
               nodes = new ArrayList[n];
               explored = new boolean[n];
               distance = new long[n];
               Arrays.fill(distance, Long.MAX_VALUE);
               
               queue = new PriorityQueue<Edge>();
               queue.offer(new Edge(s,0));
               distance[s]=0;
               
                for (int i = 0; i < m; i++) 
                {
                    input = in.readLine().split("[ ]+");
                    u = Integer.parseInt(input[0]);
                    v = Integer.parseInt(input[1]);
                    we = Integer.parseInt(input[2]);
                    if(nodes[u]==null)
                        nodes[u] = new ArrayList<Edge>();
                    if(nodes[v]==null)
                        nodes[v] = new ArrayList<Edge>();
                    
                    nodes[u].add(new Edge(v,we));
                    nodes[v].add(new Edge(u,we));
                    


                }
                
                while(!queue.isEmpty())
                {
                    auxU = queue.poll();
                    
                    if(!explored[auxU.v] && nodes[auxU.v]!=null)
                    {
                        for(int j=0;j<nodes[auxU.v].size();j++)
                        {
                            auxV = (Edge)nodes[auxU.v].get(j);
                            if(distance[auxV.v]>distance[auxU.v]+auxV.weight)
                            {
                                distance[auxV.v] = distance[auxU.v]+auxV.weight;
                                queue.offer(new Edge(auxV.v,distance[auxV.v]));
                                
                            }
                        }
                    }
                    
                }
                
                if(distance[t]==Long.MAX_VALUE)
                    System.out.println("Case #"+act+": unreachable");
                else System.out.println("Case #"+act+": "+distance[t]);
            }

        in.close();
        System.exit(0);
        
    }
}
