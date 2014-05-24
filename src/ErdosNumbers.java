/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
fsfsd
/**
 *
 * @author Alejandro E. Garces
 */
public class ErdosNumbers {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         HashMap<String, Integer> map;
         ArrayList<String> mapPos;
         boolean[] visited;
         ArrayList<ArrayList<Integer>> nodes;
         Queue<Integer> queue;
         int[] dist;
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
           int u,v;
            while (act++<cases) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
                
               map = new HashMap<String, Integer>();
               nodes = new ArrayList<ArrayList<Integer>>();
               mapPos = new ArrayList<String>();
               int pos = 0;
               for(int i=0;i<n;i++)
               {
                   String[] read = in.readLine().split("[.][,]");
                    if(read.length == 1)
                        read[0] = read[0].substring(0, read[0].indexOf(":"));
                    else{
                        for(int j=0;j<read.length-1;j++)
                            read[j] = read[j].trim()+".";
                        read[read.length-1] = read[read.length-1].trim().substring(0, read[read.length-1].indexOf(":")-1);
                    }
                    
                    ArrayList<String> aux = new ArrayList<String>();
                    
                    for(int j = 0;j<read.length;j++)
                    {
                        if(map.containsKey(read[j]))
                        {
                            u = map.get(read[j]);
                        }else
                        {
                            map.put(read[j], pos);
                            mapPos.add(read[j]);
                            pos++;
                        }
                        aux.add(read[j]);
                    }
                   /* System.out.println(aux);
                    System.out.println(map);
               System.out.println(mapPos);*/
                    for(int j = 0;j<aux.size();j++)
                    {
                        int p = map.get(aux.get(j));
                        //System.out.println("Size="+nodes.size()+", p="+p);
                        if(nodes.size()<=p)
                                nodes.add(new ArrayList<Integer>());
                    }
                       
                    
                    for(int j = 0;j<aux.size()-1;j++)
                        for(int h = j+1;h<aux.size();h++)
                        {
                           /* System.out.println(aux.get(j)+"-"+map.get(aux.get(j))+"***");
                            System.out.println(aux.get(h)+"-"+map.get(aux.get(h))+"|||");*/
                            nodes.get(map.get(aux.get(j))).add(map.get(aux.get(h)));
                            nodes.get(map.get(aux.get(h))).add(map.get(aux.get(j)));
                        }
               }
               
               
               System.out.println("Scenario "+act);
               for(int i=0;i<m;i++)
               {
                   dist = new int[pos];
                   visited = new boolean[pos];
                   u = map.get("Erdos, P.");
                   v = map.get(in.readLine().trim());
                   queue = new LinkedList<Integer>();
                   queue.offer(u);
                   visited[u] = true;
                   
                   while(!queue.isEmpty())
                   {
                       //System.out.println(queue);
                       int uu = queue.poll();
                       if(uu == v)break;
                       
                       for(int j = 0;j<nodes.get(uu).size();j++)
                       {
                           int vv = nodes.get(uu).get(j);
                           if(visited[vv]) continue;
                           visited[vv] = true;
                           dist[vv] = dist[uu]+1;
                           queue.offer(vv);
                       }
                   }
                   
                   String answer = mapPos.get(v);
                   if(dist[v] == 0)
                       answer+=" infinity";
                   else answer+=" "+String.valueOf(dist[v]);
                   System.out.println(answer);
               }
              /* System.out.println(nodes);
               System.out.println(map);
               System.out.println(mapPos);*/
            }

        in.close();
        System.exit(0);
        
    }
}

