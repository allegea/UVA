/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */
public class OilDeposits {

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    
    static boolean check(int i, int j, int n, int m, char[][] grid, boolean[][] visited)
    {
        return i>=0 && i<n && j>=0 && j<m && !visited[i][j] && grid[i][j] == '@';
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
          Queue<Integer> qX;
          Queue<Integer> qY;
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               if(n == 0 && m == 0)break;
               char[][] grid  = new char[n][m];
               boolean[][] visited = new boolean[n][m];
               int count = 0;
               for(int i=0;i<n;i++)
                   grid[i] = in.readLine().toCharArray();
               
               for(int i=0;i<n;i++)
               {
                   for(int j=0;j<m;j++)
                   {
                       if(!visited[i][j] && grid[i][j]=='@')
                       {
                          qX = new LinkedList<Integer>();
                          qY = new LinkedList<Integer>();
                          visited[i][j] = true;
                          qX.offer(i);
                          qY.offer(j);
                          count++;
                          while(!qX.isEmpty())
                          {
                              int u = qX.poll();
                              int v = qY.poll();
                              
                              for(int h=0;h<dx.length;h++)
                              {
                                  int uu = u + dx[h]; 
                                  int vv = v + dy[h];
                                  if(check(uu, vv, n, m, grid, visited))
                                  {
                                      visited[uu][vv] = true;
                                      qX.offer(uu);
                                      qY.offer(vv);
                                  }
                              }
                          }
                                   
                       }
                   }
               }
               
               System.out.println(count);
                
            }

        in.close();
        System.exit(0);
        
    }
}
