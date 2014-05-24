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
public class MontescoVsCapuleto {

    static boolean[] visited;
    static int[] color;
    static int[] count;
    static boolean bicolor;
    static ArrayList[] nodes; 
    static void DFS(int u)
    {
       // if(!bicolor)return;
        
        if(!nodes[u].isEmpty())
        {
            for(int i=0;i<nodes[u].size();i++)
            {
                int v = Integer.parseInt(nodes[u].get(i).toString());
                if(!visited[v])
                {
                    visited[v] = true;
                    color[v] = 1-color[u];
                    count[color[v]]++;
                    DFS(v);
                }
                else{
                    if(color[u] == color[v])
                    {
                        bicolor = false;
                        //break;
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
                in.readLine();
               int n = Integer.parseInt(in.readLine());
              
               visited = new boolean[n+1];
               color = new int[n+1];
               
               nodes = new ArrayList[n+1];
               bicolor = true;
               
               for(int i=1;i<=n;i++)
               {
                   if(nodes[i] == null)
                   nodes[i] = new ArrayList<Integer>();
                   String[] read = in.readLine().split("[ ]+");
                   int m = Integer.parseInt(read[0]);
                   for(int j=1;j<=m;j++)
                   {
                       int v = Integer.parseInt(read[j]);
                       if(v>n)continue;
                       nodes[i].add(v);
                       if(nodes[v]==null)
                           nodes[v] = new ArrayList<Integer>();
                       nodes[v].add(i);
                   }
               }
               
               //System.out.println(Arrays.toString(nodes)+"---");
               int answer = 0;
               for(int i=1; i<=n;i++)
               {
                   if(!visited[i])
                   {
                     //  System.out.println(i+"--"+answer+"-"+Arrays.toString(visited));
                       visited[i] = true;
                      /* if(nodes[i].size() == 0){
                           answer++;
                           continue;
                       }*/
                       
                       count = new int[2];
                       count[color[i]]++;
                       DFS(i);
                      // System.out.println(i+"--"+answer+" -- "+bicolor);
                       if(bicolor)
                       answer+=Math.max(count[0], count[1]);
                       bicolor = true;
                       
                   }
               }
               //System.out.println("--"+answer);
             //  if(bicolor)
                   System.out.println(answer);
              // else System.out.println("0");
             //  System.out.println(Arrays.toString(nodes)+"---");
                
            }

        in.close();
        System.exit(0);
        
    }
}
