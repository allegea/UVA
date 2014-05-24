/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Alejandro E. Garces
 */
public class TripRouting {

    public static class Routes{
        String from;
        String to;
        String route;
        int miles;
        
        
        public Routes(String from, String to,String route, int miles) {
            this.from = from;
            this.to = to;
            this.miles = miles;
            this.route = route;
        }

        @Override
        public String toString() {
            return addSpaces(from, 21)+addSpaces(to, 21)+addSpaces(route, 11)+addSpacesL(""+miles, 5);
        }
        public String addSpaces(String x, int n)
        {
            String out = x;
            for(int i=0;i<n-x.length();i++)
                out+=" ";
            return out;
        }
        public static String addSpacesL(String x, int n)
        {
            String out = "";
            for(int i=0;i<n-x.length();i++)
                out+=" ";
            return out+x;
        }
        
        
           
    }
    
    static Routes[][] routes;
    static int[][] paths;
    static long total = 0;
    
    public static void printRoute(int i, int j)
    {
        
        System.out.println();
        System.out.println();
        System.out.println("From                 To                   Route      Miles");
        System.out.println("-------------------- -------------------- ---------- -----");
        total = 0;
        route(i,j);
        System.out.println("                                                     -----");
        System.out.println("                                          Total  "+Routes.addSpacesL(""+total, 9));
        
    }
    
    public static void route(int i, int j)
    {
        if(i!=paths[i][j])
        {
            
            route(i,paths[i][j]);
        }
        System.out.println(routes[paths[i][j]][j].toString());
        total+=routes[paths[i][j]][j].miles;
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         HashMap<String,Integer> mapName = new HashMap<String,Integer>();
         int N = 0;
         
         ArrayList<Routes> saveRoutes = new ArrayList<Routes>();
           String line;
           int[][] id;
           
           int INF = Integer.MAX_VALUE/2;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()).length() > 0) 
            {
                String[] input = line.split(",");
                if(!mapName.containsKey(input[0]))
                    mapName.put(input[0], N++);
                if(!mapName.containsKey(input[1]))
                    mapName.put(input[1], N++);
                
                saveRoutes.add(new Routes(input[0], input[1], input[2], Integer.parseInt(input[3])));
            }
          
            routes = new Routes[N][N];
            id = new int[N][N];
            for(int i=0;i<N;i++)
                Arrays.fill(id[i], INF);
            paths = new int[N][N];
            for(Routes x:saveRoutes)
            {
                int u = mapName.get(x.from);
                int v = mapName.get(x.to);
                if(routes[u][v]==null || routes[u][v].miles>x.miles)
                {routes[u][v] = x;
                routes[v][u] = new Routes(x.to,x.from,x.route,x.miles);
                id[u][v] = x.miles;
                id[v][u] = x.miles;
                }
            }
            
           /* System.out.println(saveRoutes);
            System.out.println(mapName);
            for(int i=0;i<N;i++)
               System.out.println(Arrays.toString(id[i]));
            for(int i=0;i<N;i++)
               System.out.println(Arrays.toString(routes[i]));*/
            
            for(int i=0;i<N;i++)
                for(int j=0;j<N;j++)
                    paths[i][j] = i;
            
           for(int k=0;k<N;k++)
            for(int i=0;i<N;i++)
                for(int j=0;j<N;j++)
                {
                    if(id[i][j]>id[i][k]+id[k][j])
                    {
                        id[i][j]=id[i][k]+id[k][j];
                        paths[i][j] = paths[k][j];
                    }
                }
           
           
           
          /* for(int i=0;i<N;i++)
               System.out.println(Arrays.toString(paths[i]));*/
           
           while ((line = in.readLine()) !=null) 
            {
                String[] input = line.split(",");
                int u = mapName.get(input[0]);
                int v = mapName.get(input[1]);
                //System.out.println("***ABOUT***"+u+"-"+v);
                printRoute(u, v);
            }

        in.close();
        System.exit(0);
        
    }
}
