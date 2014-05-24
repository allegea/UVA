/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
/**
 *
 * @author Alejandro E. Garces
 */
public class ClawDecomposition {

    static boolean[] visited;
    static boolean bicolor;
    static int[] color;
    static ArrayList<Integer>[] nodes;
    
    static void DFS(int u)
    {
        for(int v:nodes[u])
            if(!visited[v])
            {
                visited[v] = true;
                color[v] = 1-color[u];
                DFS(v);
            }else if(color[v] == color[u])
                {
                    bicolor = false;
                    break;
                }
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        

         
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
            while (true) 
            {
               int n = Integer.parseInt(in.readLine());
               if(n == 0)break;
               
               visited = new boolean[n+1];
               bicolor = true;
               color = new int[n+1];
               nodes = new ArrayList[n+1];
              // Queue<Integer> queue;
               for(int i=0;i <= n;i++)
                   nodes[i] = new ArrayList<Integer>();
               
               while(true)
               {
                   String[] read = in.readLine().split("[ ]+");
                   int u = Integer.parseInt(read[0]);
                   int v = Integer.parseInt(read[1]);
                   if(u == 0 && v == 0)break;
                   
                   nodes[u].add(v);
                   nodes[v].add(u);
               }
               
               for(int i=1; i <= n; i++)
                   if(!visited[i])
                   {
                       visited[i] = true;
                       DFS(i);
                   }    

                   System.out.println(bicolor?"YES":"NO");

            }

        in.close();
        System.exit(0);
        
    }
}


/*
 * #include<iostream>
#include<vector>
using namespace std;

bool bicolor;

void DFS(int u, vector< vector<int> > nodes, bool visited[], int color[])
{
    for(int i=0;i<nodes[u].size();i++)
    {
        int v = nodes[u][i];
        if(!visited[v])
        {
            color[v] = 1-color[u];
            visited[v] = true;
            DFS(v, nodes, visited, color);
        }else if(color[v] == color[u])
        {
            bicolor = false;
            break;
        }
    }

}
int main()
{
    while(true)
    {
        int N;
        cin>>N;
        if(N == 0)break;

        vector< vector<int> > nodes(N+1);

        bool visited[N+1];
        int color[N+1];

        for(int i=0;i<=N;i++)
        {
            color[i] = 0;
            visited[i] = false;
        }

        bicolor = true;
        while(true)
        {
            int u, v;
            cin>> u >> v;
            if(u == 0 && v == 0)break;

            nodes[u].push_back(v);
            nodes[v].push_back(u);
        }

        for(int i=1;i<=N;i++)
            {
                if(!visited[i])
                {
                    visited[i] = true;
                    DFS(i, nodes, visited, color);
                }

                //cout<< i << " - " <<color[i]<<endl;
            }

        cout<< (bicolor?"YES":"NO")<<endl;
    }
    return 0;
}

 */