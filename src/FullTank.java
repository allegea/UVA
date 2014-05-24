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
public class FullTank {

    public static int N, M;
    public static int[] prices;
    public static ArrayList<Edge>[] nodes;
    public static class Edge implements Comparable <Edge>{
        
        int v;
        int dist;
        int cost;
        int cap;
        Edge(int vv, int dd, int cc, int ca)
        {
            v = vv;
            dist = dd;
            cost = cc;
            cap = ca;
        }
        
        @Override
        public int compareTo(Edge o)
        {
            return this.cost - o.cost;
        }
        
        @Override
        public String toString()
        {
            return v + " - " + cost +  " - " + cap;
        }
    }
    
    public static int Dijkstra(int s, int e, int Capacity)
    {
        int answer = -1;
        int[][] cost = new int[N][Capacity + 1];
        for(int i = 0; i < N; i++)Arrays.fill(cost[i],Integer.MAX_VALUE);
        boolean[] visited = new boolean[N];
        visited[s] = true;
        cost[s][0] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        queue.offer(new Edge(s, 0, 0, 0));
        while(!queue.isEmpty())
        {
            Edge x = queue.poll();
           // visited[x.v] = true;
            if(x.v == e){
                answer = x.cost;
                break;
            }
            //System.out.println(queue);
            if(cost[x.v][x.cap] < x.cost) continue;
            if(x.cap + 1 <= Capacity && cost[x.v][x.cap + 1] >= x.cost + prices[x.v])
                    {
                        cost[x.v][x.cap + 1] = x.cost + prices[x.v];
                         queue.offer(new Edge(x.v, 0, x.cost + prices[x.v], x.cap + 1));
                    }
            for(Edge y:nodes[x.v])
            {
                if(cost[y.v][x.cap] < x.cost)continue;
                if(y.dist <= x.cap)
                {
                    if(cost[y.v][x.cap - y.dist] > x.cost)
                    {
                        cost[y.v][x.cap - y.dist] = x.cost;
                        queue.offer(new Edge(y.v, 0, x.cost, x.cap - y.dist));
                    }
                }//else 
                
            }
        }
        
        //if(visited[e])answer = cost[e];
        return answer;
    }
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
         String line = "";
         StringTokenizer st = new StringTokenizer(in.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         prices = new int[N];
         st = new StringTokenizer(in.readLine());
         for(int i = 0; i < N; i++)
             prices[i] = Integer.parseInt(st.nextToken());
         
         nodes = new ArrayList[N];
         for(int i = 0; i < N; i++)nodes[i] = new ArrayList<Edge>();
         
         for(int i = 0; i < M; i++)
         {
             st = new StringTokenizer(in.readLine());
             int u = Integer.parseInt(st.nextToken());
             int v = Integer.parseInt(st.nextToken());
             int d = Integer.parseInt(st.nextToken());
             nodes[u].add(new Edge(v, d, 0, 0));
             nodes[v].add(new Edge(u, d, 0, 0));
         }
         
         int Q = Integer.parseInt(in.readLine());
         for(int i = 0; i < Q; i++)
         {
             st = new StringTokenizer(in.readLine());
             int c = Integer.parseInt(st.nextToken());
             int s = Integer.parseInt(st.nextToken());
             int e = Integer.parseInt(st.nextToken());
             int answer = Dijkstra(s, e, c);
             if(answer < 0)System.out.println("impossible");
             else System.out.println(answer);
         }
         
         in.close();
         System.exit(0);
     }
}
