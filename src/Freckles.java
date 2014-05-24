/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 *
 * @author Alejandro E. Garces
 */
public class Freckles {

    
    public static class Disjoint {
        
        int Sets;
        int[] id;
        int[] size;
        int n;
        
        Disjoint(int m)
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
        
        int root(int i)
        {
            return id[i] == i?i:(id[i] = root(id[i]));
        }
        boolean same(int i, int j)
        {
            return root(i) == root(j);
        }
        
        void union(int i, int j)
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
        
        int sets()
        {
            return Sets;
        }
    }
    
    public static class Edge implements Comparable {

        public Edge(double w, int a, int b) {
            this.we = w;
            this.a = a;
            this.b = b;
        }
        
        double we;
        int a, b;
        
        

        @Override
        public int compareTo(Object o) {
           return Double.compare(we, ((Edge)o).we);
        }

        @Override
        public String toString() {
            return we+"**"+a+"**"+b;
        }
        
        
         
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         PriorityQueue<Edge> queue;
         Point2D.Double[] points;
         Disjoint unionFind;
         Edge aux;
         int n;
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
           boolean first = true;
            while (act++<cases) 
            {
                in.readLine();
                
                n= Integer.parseInt(in.readLine());
                points = new Point2D.Double[n];
                queue = new PriorityQueue<Edge>();
                unionFind = new Disjoint(n);
                
                for(int i=0;i<n;i++)
                {
                    String[] read = in.readLine().split("[ ]+");
                    double x = Double.parseDouble(read[0]);
                    double y = Double.parseDouble(read[1]);
                    points[i] = new Point2D.Double(x, y);
                }
                
               // System.out.println(Arrays.toString(points));
                for(int i=0;i<n;i++)
                    for(int j=i+1;j<n;j++)
                        queue.offer(new Edge(points[i].distance(points[j]), i, j));
                
                double answer = 0.0;
                while(!queue.isEmpty() && unionFind.sets()>1)
                {
                    aux = queue.poll();
                    //System.out.println(aux);
                    if(unionFind.same(aux.a, aux.b))continue;
                    answer+=aux.we;
                    unionFind.union(aux.a, aux.b);
                    
                }
                if(!first)System.out.println();
                first = false;
                System.out.printf("%.2f\n", answer);
            }

        in.close();
        System.exit(0);
        
    }
}
