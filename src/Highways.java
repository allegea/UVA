/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;



/**
 *
 * @author Alejandro E. Garces
 */
public class Highways {


        static final int M_INF = Integer.MIN_VALUE/2;
    
    public static class Edge implements Comparable {

        public Edge(int u, int v, int w) {
            this.w = w;
            this.u = u;
            this.v = v;
        }
        
        int w;
        int u;
        int v;

        @Override
        public int compareTo(Object o) {
            return w - ((Edge)o).w;
           
        }

        @Override
        public String toString() {
            return w+"**"+u+"***"+v;
        }
    }
    

    static class Point{
        
        int x, y;
        Point(int xx, int yy)
        {
            x = xx;
            y = yy;
        }
        int distance(Point w)
        {
            int a = x - w.x;
            int b = y - w.y;
            return a*a + b*b;
        }
    }
    
    static int N;
	static int[] ids;
	static int[] sizes;
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
		sizes = new int[n+1];
		ids = new int[n+1];
		for(int i=0;i<=n;i++)
		{
			ids[i] = i;
			sizes[i] = 1;
		}
	}
	
	static void union(int i, int j)
	{
		int u = root(i);
		int v = root(j);
		if(u == v)return;
		if(sizes[u] > sizes[v])
		{
			sizes[u]+=sizes[v];
			ids[v] = u;
		}else{
			sizes[v]+=sizes[u];
			ids[u] = v;
		}
		sets--;
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("edges.txt"));
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        int c = Integer.parseInt(in.readLine());
        Point[] points;
        StringTokenizer st;
        StringBuilder output;
        boolean noFirst = false;
        StringBuilder answer = new StringBuilder();
        ArrayList<Edge> edges;
        while(c-- > 0)
        {
            if(noFirst)answer.append("\n");
            noFirst = true;
            output = new StringBuilder();
            in.readLine();
            int m = Integer.parseInt(in.readLine());

            points = new Point[m + 1];
            edges = new ArrayList<Edge>();

            init(m+1);

            for(int i = 0; i < m; i++)
            {
                st = new StringTokenizer(in.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                points[i] = new  Point(u, v);
            }
            
            int n = Integer.parseInt(in.readLine());
           
            for(int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                
               // edges.add(new Edge(u, v, M_INF));
                //nodes[v].add(new Edge(u, v, M_INF));
                 union(u, v);
            }
            
            for(int i = 0; i < m; i++)
                for(int j = i + 1; j < m; j++)
                {
                    int dist = points[i].distance(points[j]);
                   // nodes[i].add(new Edge(j, i, dist));
                     edges.add(new Edge(i, j, dist));
                    //nodes[j].add(new Edge(i, j, dist));
                }
            
            
             int count = 0;
             
             Collections.sort(edges);
            for(Edge x:edges)
            {
                    if(!inSame(x.u, x.v))
                    {
                           
                                count++;
                                output.append(x.v + 1).append(" ").append(x.u + 1).append("\n");

                            union(x.u, x.v);
                            if(sets<=1)break;
                    }
            }

           // System.out.println("--"+count+" - "+m);
            if(count == 0)
            {
                answer.append("No new highways need\n");
                //System.out.println("No new highways need");
                
            }else //System.out.print(output);
                answer.append(output);
             
        }
            
        System.out.print(answer);
        System.exit(0);
        in.close();
    }
}
