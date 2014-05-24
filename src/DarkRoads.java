/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
TLE
/**
 *
 * @author Alejandro E. Garces
 */
public class DarkRoads {

    static int Sets;

        static int[] id;
        static int[] size;
        static int n;
        
        public static void init(int m)
        {
            n = m;
            id = new int[n];
            size = new int[n];
            Sets = n;
            for(int i=0;i<n;i++)
            {
                id[i] = i;
                size[i] = 1;
            }
        }
        
        static int root(int i)
        {
            return id[i] == i?i:(id[i] = root(id[i]));
        }
        static boolean same(int i, int j)
        {
            return root(i) == root(j);
        }
        
        static void union(int i, int j)
        {
            int u = root(i);
            int v = root(j);
            
            if(u == v)return;
            
            if(size[u]<size[v])
            {
                id[u] = v;
                size[v]+=size[u];
            }else{
                id[v] = u;
                size[u]+=size[v];
            }
            Sets--;
        }
    
    
    public static class Edge implements Comparable {

        public Edge(int w, int a, int b) {
            this.w = w;
            this.a = a;
            this.b = b;
        }
        
        int w;
        int a, b;

        @Override
        public int compareTo(Object o) {
           return w -((Edge)o).w;
        }

        @Override
        public String toString() {
            return w+"**"+a+"**"+b;
        }
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         //PriorityQueue<Edge> edges;
         //ArrayList<Edge> edges;
         Edge[] edges;
         
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
                //String[] input = in.readLine().split("[ ]+");
                x = new StringTokenizer(in.readLine());
               int n= Integer.parseInt(x.nextToken());
               int m= Integer.parseInt(x.nextToken());
               
               if(n == 0 && m == 0)break;
               
               total = 0; 
               min = 0;
               edges = new Edge[m];
               init(n);
               
               for(int i=0;i<m;i++)
               {
                   //input = in.readLine().split("[ ]+");
                   x = new StringTokenizer(in.readLine());
                   int a = Integer.parseInt(x.nextToken());
                   int b = Integer.parseInt(x.nextToken());
                   int c = Integer.parseInt(x.nextToken());
                   total+=c;
                   edges[i] = new Edge(c, a, b);
               }
               
               Arrays.sort(edges);
               for(Edge aux: edges)
               {
                  // System.out.println(aux);
                   if(!same(aux.a, aux.b))
                   {
                    
                    min+=aux.w;
                    union(aux.a, aux.b);
                    //if(Sets<=1)break;
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