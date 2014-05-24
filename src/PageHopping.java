/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Alejandro E. Garces
 */
public class PageHopping {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         int[][] adj;
           String line;
           ArrayList<Integer> nodes;
           Set<Integer> amountNodes; 
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           int act = 1;
            while (true) 
            {
                String[] input = in.readLine().split("[ ]+");
                int pos = 0;
                nodes = new ArrayList<Integer>();
                amountNodes = new HashSet<Integer>();
                int n = 0;
                while(pos<input.length)
                {
                    int u = Integer.parseInt(input[pos++]);
                    int v = Integer.parseInt(input[pos++]);
                    if(u == 0 && v == 0)break;
                    
                    nodes.add(u);
                    nodes.add(v);
                    amountNodes.add(u);
                    amountNodes.add(v);
                    n = Math.max(n, Math.max(u,v));
                }
             //   System.out.println(nodes);
                if(nodes.isEmpty())break;
                
                //int n = amountNodes.size();
                adj = new int[n+1][n+1];
                int INF = Integer.MAX_VALUE/2;
                for(int i = 1;i<=n;i++)
                    Arrays.fill(adj[i], INF);
                
                for(int i=0;i<nodes.size();i++)
                {
                    int u = nodes.get(i++);
                    int v = nodes.get(i);
                    adj[u][v] = 1;
                }
                
               // for(int i=0;i<=n;i++)
                  //  System.out.println(Arrays.toString(adj[i]));
                
                for(int k=1;k<=n;k++)
                    for(int i=1;i<=n;i++)
                        for(int j=1;j<=n;j++)
                            adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
              
                //for(int i=0;i<=n;i++)
                  //  System.out.println(Arrays.toString(adj[i]));
                
                int count = 0;
                int amount = 0;
                for(int i=1;i<=n;i++)
                    for(int j=1;j<=n;j++)
                    {
                        if(i == j)continue;
                        if(adj[i][j] == INF)continue;
                        count++;
                        amount+=adj[i][j];
                    }
                float answer = amount/(float)count;
                System.out.printf("Case %d: average length between pages = %.3f clicks\n",act,answer);
                        act++;
                //System.out.println("**** "+count+" - "+amount+" - "+(amount/(double)count));
                
            }

        in.close();
        System.exit(0);
        
    }
}
