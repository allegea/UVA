/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class Fill {
    public static final int M = 3;
    public static int[] cap;
    static StringBuilder out = new StringBuilder();
    public static class Edge implements Comparable<Edge>{
        
        int[] values; 
        int cost;
        Edge(int[] v, int cost)
        {   
            values = new int[M];
            for(int i = 0; i < M; i++)
                values[i] = v[i];
            
            this.cost = cost;
        }
        
         @Override
        public int compareTo(Edge o)
        {
            return this.cost - o.cost;
        }
        
         @Override
         public String toString()
         {
             return cost + " ## " + values[0] + " - " + values[1] + " - " + values[2];
         }
    }

    public static void Dijkstra(int d)
    {
        int cost, answer;
        cost = Integer.MAX_VALUE;
        answer = 0;
        int[][][] dist = new int[cap[0] + 1][cap[1] + 1][cap[2] + 1];
        for(int i = 0; i < cap[0] + 1; i++)
            for(int j = 0; j < cap[1] + 1; j++)
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        queue.offer(new Edge(new int[]{0, 0, cap[2]}, 0));
        dist[0][0][cap[2]] = 0;
        while(!queue.isEmpty())
        {
            Edge u = queue.poll();
            if(dist[u.values[0]][u.values[1]][u.values[2]] < u.cost)continue;
            for(int i = 0; i < M; i ++)
            {
                int diff = d - u.values[i];
                if(diff < 0)continue;
                if(diff < (d - answer))
                {
                    cost = u.cost;
                    answer = u.values[i];
                }else if(diff == (d - answer) && cost > u.cost)
                    cost = u.cost;
            }
           // System.out.println(cost + " - " + answer);
                    
            for(int i = 0; i < M; i++)
            {
                if(u.values[i] == 0)continue;
                for(int j = 0; j < M; j++)
                {
                    if(j == i)continue;
                    int[] newV = new int[M];
                    for(int h = 0; h < M; h++)newV[h] = u.values[h];
                    
                    int diff1 = cap[j] - newV[j];
                     //System.out.println("Diff " + diff1 + " - " + cap[j] + " - " + newV[j]);
                    if(diff1 <= newV[i])
                    {
                        newV[j] += diff1;
                        newV[i] -= diff1;
                    }else{
                         newV[j] += newV[i];
                         diff1 = newV[i];
                        newV[i] = 0;
                        
                    }
                    
                   // System.out.println("* " + u + " ||| " + i + " - " + j);
                    
                    if(dist[u.values[0]][u.values[1]][u.values[2]] + diff1 < dist[newV[0]][newV[1]][newV[2]])
                    {
                        dist[newV[0]][newV[1]][newV[2]] = dist[u.values[0]][u.values[1]][u.values[2]] + diff1;
                        Edge toOffer = new Edge(newV, dist[newV[0]][newV[1]][newV[2]]);
                         //System.out.println("| " + toOffer);
                        queue.offer(toOffer);
                    }
                }
            }    
        }
        
        out.append(cost).append(" ").append(answer).append("\n");
        //System.out.println(cost + " " + answer);
    }
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         int N = Integer.parseInt(in.readLine());
         StringTokenizer st;
         while(N -- > 0)
         {
             st = new StringTokenizer(in.readLine());
             cap = new int[M];
             cap[0] = Integer.parseInt(st.nextToken());
             cap[1] = Integer.parseInt(st.nextToken());
             cap[2] = Integer.parseInt(st.nextToken());
             int d = Integer.parseInt(st.nextToken());
             Dijkstra(d);
         }
         System.out.print(out);
         in.close();
         System.exit(0);
     }
}
