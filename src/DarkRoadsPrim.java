/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class DarkRoadsPrim {

        static int n;
        static boolean[] visited;
        static ArrayList<Edge>[] nodes;
        static Queue<Edge> q;
        

    
    public static class Edge implements Comparable {

        public Edge(int a, int w) {
            this.w = w;
            this.a = a;
        }
        
        int w;
        int a;

        @Override
        public int compareTo(Object o) {
           return w -((Edge)o).w;
        }

        @Override
        public String toString() {
            return w+"**"+a;
        }
    }
    
    static void process(int u)
    {
        visited[u] = true;
        for(Edge x:nodes[u])
            if(!visited[x.a])
                q.offer(x);
        
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         //PriorityQueue<Edge> edges;
         //ArrayList<Edge> edges;
         //Edge[] edges;
         
         long total;
         long min;
         
         StringBuilder answer = new StringBuilder();
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           StringTokenizer x;
            while (true) 
            {
                x = new StringTokenizer(in.readLine());
               int n= Integer.parseInt(x.nextToken());
               int m= Integer.parseInt(x.nextToken());
               
               if(n == 0 && m == 0)break;
               
               total = 0; 
               min = 0;
               //edges = new Edge[n];
               nodes = new ArrayList[n];
               visited = new boolean[n];
               q = new PriorityQueue<Edge>();
               for(int i=0;i<n;i++)nodes[i] = new ArrayList<Edge>();
               
               for(int i=0;i<m;i++)
               {
                   x = new StringTokenizer(in.readLine());
                   int a = Integer.parseInt(x.nextToken());
                   int b = Integer.parseInt(x.nextToken());
                   int c = Integer.parseInt(x.nextToken());
                   total+=c;
                   nodes[a].add(new Edge(b, c));
                   nodes[b].add(new Edge(a, c));
                   
               }
               
              // System.out.println(Arrays.toString(nodes));
               process(0);
               while(!q.isEmpty())
               {
                   
                  // System.out.println(q);
                   Edge xx = q.poll();
                   if(!visited[xx.a])
                   {
                       min+=xx.w;
                       process(xx.a);
                   } 
               }
               
               answer.append((total-min)).append("\n");
               //System.out.println(total-min);
                
            }

            System.out.print(answer);
        in.close();
        System.exit(0);
        
    }
}

/*
 * #include <algorithm>
#include <cstdio>
#include <vector>
#include <queue>
#include<iostream>
using namespace std;

typedef pair<int, int> ii;
typedef vector<int> vi;

vi pset(200005);
void initSet(int N)
{
    pset.assign(N, 0); for (int i = 0; i < N; i++) pset[i] = i;
}
int findSet(int i)
{
    return (pset[i] == i) ? i : (pset[i] = findSet(pset[i]));
}
bool isSameSet(int i, int j) { return findSet(i) == findSet(j); }
void unionSet(int i, int j) { pset[findSet(i)] = findSet(j); }

int main()
{
    int u, v, w;
    vector< pair<int, ii> > EdgeList;
    long long Cost,Tcost;
    int n, m;

    while(cin>>n>>m)
    {
        if(n == 0 && m == 0)break;
        EdgeList.clear();
        Cost = 0;
        Tcost = 0;
        for (int j = 0; j < m; j++) {
            cin>>u >> v >> w;
            Cost+=w;
           // if(w >= cost)continue;
            EdgeList.push_back(make_pair(w, ii(u, v)));
        }
        sort(EdgeList.begin(), EdgeList.end());

        initSet(n);
        for (int j = 0; j < m && n>=1; j++) {
            pair<int, ii> front = EdgeList[j];
            if (!isSameSet(front.second.first, front.second.second)) {
            Tcost += front.first;
            unionSet(front.second.first, front.second.second);
            n--;
            }
        }
        cout<<(Cost-Tcost)<<endl;
    }
    return 0;
}
 */