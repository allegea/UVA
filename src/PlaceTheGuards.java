/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Alejandro E. Garces
 */
public class PlaceTheGuards {

    static boolean[] visited;
    static int[] color;
    static int[] count;
    static boolean bicolor;
    static ArrayList[] nodes;
    
    static void DFS(int u)
    {
        if(!bicolor)return;
        
        //if(nodes[u] != null)
        {
            for(int i=0;i<nodes[u].size();i++)
            {
                int v = Integer.parseInt(nodes[u].get(i).toString());
                if(!visited[v])
                {
                    visited[v] = true;
                    if(nodes[v] == null)continue;
                    color[v] = 1-color[u];
                    count[color[v]]++;
                    DFS(v);
                }
                else{
                    if(color[u] == color[v])
                    {
                        bicolor = false;
                        break;
                    }
                }
            }
        }
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               visited = new boolean[n];
               color = new int[n];
               count = new int[2];
               bicolor = true;
               nodes = new ArrayList[n];
               
               for(int i=0;i<m;i++)
               {
                   input = in.readLine().split("[ ]+");
                    int u= Integer.parseInt(input[0]);
                    int v= Integer.parseInt(input[1]);
                    if(nodes[u] == null)
                        nodes[u] = new ArrayList<Integer>();
                    nodes[u].add(v);
                    if(nodes[v] == null)
                        nodes[v] = new ArrayList<Integer>();
                    nodes[v].add(u);
               }
               int answer = 0;
               for(int i=0;i<n;i++)
               {
                   if(!visited[i])
                   {    visited[i] = true;
                       if(nodes[i] == null)
                       {
                           answer++;
                           continue;
                       }
                       count = new int[2];
                       count[color[i]]++;
                       DFS(i);
                       answer+=Math.min(count[1], count[0]);
                   }
               }
               // System.out.println(Arrays.toString(color));
              //  System.out.println(Arrays.toString(count));
              //  System.out.println(Arrays.toString(visited));
               if(bicolor)
                   System.out.println(answer);
               else System.out.println("-1");
            }

        in.close();
        System.exit(0);
        
    }
}
