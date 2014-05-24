/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class Friends {

    static int[] size;
    static int[] id;
    static int MAX = Integer.MIN_VALUE;
    static int N;
    
    static void init()
    {
        MAX = Integer.MIN_VALUE;
        size = new int[N+1];
        id = new int[N+1];
        for(int i=1;i<=N;i++)
        {
            id[i] = i;
            size[i] = 1;
        }
    }
    
    static int root(int i)
    {
        if(id[i] == i)return i;
        else return id[i] = root(id[i]);
    }
    
    static void union(int i, int j)
    {
        int u = root(i);
        int v = root(j);
        
        if(u == v)return;
        
        if(size[u]<size[v])
        {
            id[u] = v;
            size[v] += size[u];
            MAX = Math.max(MAX, size[v]);
        }else{
            id[v] = u;
            size[u] += size[v];
            MAX = Math.max(MAX, size[u]);
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
               N = Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               
               init();
               for(int i=0;i<m;i++)
               {
                   input = in.readLine().split("[ ]+");
                   int u = Integer.parseInt(input[0]);
                   int v = Integer.parseInt(input[1]);
                   union(u, v);
               }
               
               System.out.println(MAX);
                
            }

        in.close();
        System.exit(0);
        
    }
}
