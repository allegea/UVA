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
public class OrderingTasks {
public static boolean[] explored;
public static int label;
public static int[] topological;

public static void DFS_topological(ArrayList[] nodes, int s)
{
    
    explored[s] = true;
    if(nodes[s]!=null)
    {
        for(Object i:nodes[s])
        {
            int v = Integer.parseInt(i.toString());
            if(!explored[v])
                DFS_topological(nodes, v);
        }
        
    }
    
    topological[label--] = s;
}

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               if(n==0 && m==0)
                   break;
               
               label=n;
               ArrayList[] nodes = new ArrayList[n+1];
               explored = new boolean[n+1];
               topological = new int[n+1];
               
               for(int i=0;i<m;i++)
               {
                   input = in.readLine().split("[ ]+");
                    int u= Integer.parseInt(input[0]);
                    int v= Integer.parseInt(input[1]);
                    if(nodes[u]==null)
                        nodes[u] = new ArrayList<Integer>();
                    nodes[u].add(v);
               }
               
               for(int i=1;i<=n;i++)
               {
                   if(!explored[i])
                       DFS_topological(nodes, i);
               }
               
               for(int i=1;i<n;i++)
                   System.out.print(topological[i]+" ");
               System.out.println(topological[n]);
                
            }

        in.close();
        System.exit(0);
        
    }
}
