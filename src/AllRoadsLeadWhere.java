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
public class AllRoadsLeadWhere{

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        WA
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         HashMap<String, Integer> map;
         char[] mapPos;
         ArrayList<Integer>[] nodes;
         Queue<Integer> queue;
         String[] paths;
         boolean[] visited;
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
           int pos = 0;
           int u,v;
           //in.readLine();
            while (act++<cases) 
            {
                in.readLine();
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               nodes = new ArrayList[2*n];
               mapPos = new char[2*n];
               for(int i=0;i<2*n;i++)
                   nodes[i] = new ArrayList<Integer>();
               
               pos = 0;
               map = new HashMap<String, Integer>();

               for(int i=0;i<n;i++)
               {
                   input = in.readLine().split("[ ]+");
                   
                   if(map.containsKey(input[0]))
                     u = map.get(input[0]);
                   else {
                       map.put(input[0], pos);
                       mapPos[pos] = input[0].charAt(0);
                       u = pos++;
                   }
                   
                   if(map.containsKey(input[1]))
                     v = map.get(input[1]);
                   else {
                       map.put(input[1], pos);
                       mapPos[pos] = input[1].charAt(0);
                       v = pos++;
                   }
                   
                   nodes[u].add(v);
                   nodes[v].add(u);
               }
               
              // System.out.println(Arrays.toString(nodes));
               
               for(int i=0;i<m;i++)
               {
                   String answer = "";
                   paths = new String[map.size()];
                   for(int w = 0;w<map.size();w++)
                       paths[w] = "";
                   visited = new boolean[map.size()];
                   queue = new LinkedList<Integer>();
                   input = in.readLine().split("[ ]+");
                   u = map.get(input[0]);
                   v = map.get(input[1]);
                   visited[u] = true;
                   queue.offer(u);
                   paths[u] += mapPos[u];
                   
                   while(!queue.isEmpty())
                   {
                       int uu = queue.poll();
                       if(uu == v)
                           answer = paths[uu];
                       
                       for(int h:nodes[uu])
                       {
                           if(visited[h])continue;
                           visited[h] = true;
                           paths[h] = paths[uu]+mapPos[h];
                           queue.offer(h);
                       }
                   }
                 //  System.out.println(Arrays.toString(paths));
                   System.out.println(answer);
                   
               }
               System.out.println();
                
            }

        in.close();
        System.exit(0);
        
    }
}
