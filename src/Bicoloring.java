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
public class Bicoloring {

    static boolean[] visited;
    static int[] color;
    static ArrayList[] nodes;
    static boolean bicolor;
    
    static void DFS(int u)
    {
        if(!bicolor)return;
        
        if(nodes[u] != null)
        {
            for(int i=0;i<nodes[u].size();i++)
            {
                //System.out.println("** "+nodes[u].get(i).toString());
                int h = Integer.parseInt(nodes[u].get(i).toString());
                if(!visited[h])
                {
                    color[h] = 1- color[u];
                    visited[h] = true;
                    DFS(h);
                }else
                {
                    if(color[u] == color[h])
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
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
                
               int n= Integer.parseInt(line);
               if(n == 0)break;
               visited = new boolean[n];
               color = new int[n];
               nodes = new ArrayList[n];
               bicolor = true;
               int m = Integer.parseInt(in.readLine());
               
               for(int i=0;i<m;i++)
               {
                   String[] read = in.readLine().split("[ ]+");
                   int u = Integer.parseInt(read[0]);
                   int v = Integer.parseInt(read[1]);
                   if(nodes[u] == null)
                       nodes[u] = new ArrayList<Integer>();
                   nodes[u].add(v);
                   
                   if(nodes[v] == null)
                       nodes[v] = new ArrayList<Integer>();
                   nodes[v].add(u);
               }
               
               visited[0] = true;
               DFS(0);
               if(bicolor)
                   System.out.println("BICOLORABLE.");
               else System.out.println("NOT BICOLORABLE.");
            }

        in.close();
        System.exit(0);
        
    }
}
