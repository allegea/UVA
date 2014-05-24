/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Alejandro E. Garces
 */

public class HowManyDependencies {

    static int N, pos, max, count;
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    static int[] DP;

    static void DFS(int i)
    {
        if(visited[i])return;
        visited[i] = true;
        count++;
        
        for(int u:nodes[i])
                DFS(u);
        //max = Math.max(DP[i], max);
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
                
                N = Integer.parseInt(line);
                if(N == 0)break;
                
                pos = N;
                visited = new boolean[N+1];
                nodes = new ArrayList[N+1];
                DP = new int[N+1];
                for(int i=1;i<=N;i++)
                    nodes[i] = new ArrayList<Integer>();
                
                for(int i=1;i<=N;i++)
                {
                    String[] read = in.readLine().split("[ ]+");
                    for(int j=1;j<read.length;j++)
                        nodes[i].add(Integer.parseInt(read[j]));
                }
                
               // System.out.println(Arrays.toString(nodes));
                max = -1;
                int answer = -1;
                for(int i=1;i<=N;i++)
                    {   visited = new boolean[N+1];
                        count = 0;
                        DFS(i);
                        DP[i] = count;
                        if(max<count)
                        {
                            max = count;
                            answer = i;
                        }
                    }
                
                /*System.out.println(Arrays.toString(topSort));
                System.out.println(Arrays.toString(DP)+" - "+max);*/
                

                        System.out.println(answer);

            }
            
            
            
        in.close();
        System.exit(0);
        
    }
}

public class HowManyDependencies {

    static int N, pos, max;
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    static int[] topSort;
    static int[] DP;
    
    static void paths(int i)
    {
        for(int u:nodes[i])
        {
            //if(!visited[u])
            {
                visited[u] = true;
                DP[u]+= DP[i] + 1;
                paths(u);
            }
        }
        max = Math.max(DP[i], max);
    }
    static void DFS(int i)
    {
        
        
        for(int u:nodes[i])
        {
            if(!visited[u])
            {   visited[u] = true;
                //DP[u] = DP[i] + 1;
                DFS(u);
            }
        }
        
        
        topSort[pos--] = i;
        //max = Math.max(DP[i], max);
    }
    

     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

           String line;

            while ((line = in.readLine()) != null) 
            {
                
                N = Integer.parseInt(line);
                if(N == 0)break;
                
                pos = N;
                visited = new boolean[N+1];
                nodes = new ArrayList[N+1];
                topSort = new int[N+1];
                DP = new int[N+1];
                for(int i=1;i<=N;i++)
                    nodes[i] = new ArrayList<Integer>();
                
                for(int i=1;i<=N;i++)
                {
                    String[] read = in.readLine().split("[ ]+");
                    for(int j=1;j<read.length;j++)
                        nodes[Integer.parseInt(read[j])].add(i);
                }
                
               // System.out.println(Arrays.toString(nodes));
                for(int i=1;i<=N;i++)
                    if(!visited[i])
                    {   visited[i] = true;
                        DFS(i);
                    }
                
                
                visited = new boolean[N+1];
                max = Integer.MIN_VALUE;
                //pos = N;
                for(int i=1;i<=N;i++)
                    if(!visited[topSort[i]])
                    {   visited[topSort[i]] = true;
                        DP[topSort[i]] = 0;
                        paths(i);
                    }

                
                for(int i=1;i<=N;i++)
                {
                    if(DP[i] == max){
                        System.out.println(i);
                        break;
                    }
                }
            }
            
            
            
        in.close();
        System.exit(0);
        
    }
}
