/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
TLE
/**
 *
 * @author Alejandro E. Garces
 */

public class Airports{
	static int N;
	static int[] ids;
	//static int[] sizes;
	static int sets;
	
	static int root(int i)
	{
		return ids[i] == i?i:(ids[i] = (root(ids[i])));
	}
	
	static boolean inSame(int i, int j)
	{
		return root(i) == root(j);
	}
	
	static void init(int n)
	{
		N = n;
		sets = n;
		//sizes = new int[n+1];
		ids = new int[n+1];
		for(int i=0;i<=n;i++)
		{
			ids[i] = i;
			//sizes[i] = 1;
		}
	}
	
	static void union(int i, int j)
	{
		int u = root(i);
		int v = root(j);
		//if(u == v)return;
		//if(sizes[u] > sizes[v])
		//{
		//	sizes[u]+=sizes[v];
			ids[v] = u;
		/*}else{
			sizes[v]+=sizes[u];
			ids[u] = v;
		}*/
                sets--;
	}
	public static class Edge implements Comparable{
	
		int u;
		int v;
		int w;
		Edge(int uu, int vv, int ww)
		{
			u = uu;
			v = vv;
			w = ww;
		}
		@Override
		public int compareTo(Object o){
			return this.w-((Edge)o).w;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		int curr = 1;
		int tests = Integer.parseInt(in.readLine());
		ArrayList<Edge> edges;
                StringTokenizer x;
		while(tests-->0)
		{
			//String[] read = in.readLine().split("[ ]+");
                        x = new StringTokenizer(in.readLine()); 
			int n = Integer.parseInt(x.nextToken());
			int m = Integer.parseInt(x.nextToken());
			int cost = Integer.parseInt(x.nextToken());
			init(n);
			edges = new ArrayList<Edge>();
			for(int i=0;i<m;i++)
			{
				x = new StringTokenizer(in.readLine()); 
				int u = Integer.parseInt(x.nextToken());
				int v = Integer.parseInt(x.nextToken());
				int w = Integer.parseInt(x.nextToken());
                                if(w >= cost)continue;
				edges.add(new Edge(u, v, w));
			}
			Collections.sort(edges);
			int sum = 0;
			for(Edge xx:edges)
			{
				if(xx.w >= cost)break;
				if(!inSame(xx.u, xx.v))
				{
					sum+=xx.w;
					union(xx.u, xx.v);
				}
			}
                        //System.out.println(sum+" - "+sets);
			//sets--;
			sum+=(sets*cost);
			System.out.println("Case #"+(curr++)+": "+sum+" "+sets);
		
		}
		in.close();
		System.exit(0);
		
	}
}

/*
 * #include <algorithm>
#include <cstdio>
#include <vector>
#include <queue>
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
    int V, E, u, v, w, cost,t,totalCost,airPorts;
    vector< pair<int, ii> > EdgeList;

    scanf("%d", &t);
    for(int i = 0 ; i < t ; i++){
        totalCost = 0;
        scanf("%d %d %d", &V, &E, &cost);
        EdgeList.clear();
        for (int j = 0; j < E; j++) {
            scanf("%d %d %d", &u, &v, &w);
           // if(w >= cost)continue;
            EdgeList.push_back(make_pair(w, ii(u-1, v-1)));
        }
        sort(EdgeList.begin(), EdgeList.end());

        initSet(V);
        int k = 0;
        for (int j = 0; j < E; j++) {
            pair<int, ii> front = EdgeList[j];
            if(front.first >= cost)
               break;
            if (!isSameSet(front.second.first, front.second.second)) {
            totalCost += front.first;
            unionSet(front.second.first, front.second.second);
            V--;
            }
        }

        totalCost+= (cost*V);


         printf("Case #%d: %d %d\n",(i+1),totalCost,V);
    }
    return 0;
}
 */