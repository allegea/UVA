/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */
public class SpreadingTheNews {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         int n = Integer.parseInt(in.readLine());
         ArrayList<Integer>[] nodes  = new ArrayList[n];
         boolean[] visited;
         int[] days;
         int[] lenght;
         Queue<Integer> queue;
         for(int i=0;i<n;i++)
         {
             nodes[i] = new ArrayList<Integer>();
             String[] read = in.readLine().split("[ ]+");
             for(int j=1;j<read.length;j++)
                 nodes[i].add(Integer.parseInt(read[j]));
         }
        
         //System.out.println(Arrays.toString(nodes));
         int m = Integer.parseInt(in.readLine());
         for(int j=0;j<m;j++)
         {
             int maxLeng = 0;
             int u = Integer.parseInt(in.readLine());
             visited = new boolean[n];
             days = new int[n];
             lenght = new int[n];
             queue = new LinkedList<Integer>();
             queue.offer(u);
             visited[u] = true;
             //boolean firstOut = true;
             while(!queue.isEmpty())
             {
                 int v = queue.poll();
                 //System.out.println("** "+v+" - "+queue.size());
                 
                 for(int x:nodes[v])
                 {
                     if(visited[x])continue;
                     lenght[x] = lenght[v]+1;
                     days[lenght[x]]++;
                     queue.offer(x);
                     visited[x] = true;
                     maxLeng = Math.max(maxLeng, lenght[x]);
                 }
             }
             
            /* System.out.println(Arrays.toString(visited));
             System.out.println(Arrays.toString(lenght));
             System.out.println(Arrays.toString(days));*/
             if(maxLeng == 0)
                 System.out.println(0);
             else{
                 int posAns = 0;
                 for(int i=1;i<=maxLeng;i++)
                 {
                     if(days[posAns]<days[i])
                         posAns = i;
                 }
                 System.out.println(days[posAns]+" "+posAns);
             }
             
         }

        in.close();
        System.exit(0);
        
    }
}
