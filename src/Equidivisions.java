/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class Equidivisions {

    static int[] dX = {0, -1, 0, 1};
    static int[] dY = {1, 0, -1, 0};
    static int N;
    static boolean[][] visited;
    static int[][] grid;
    static int currentValue, count;
    
    static boolean check(int i, int j)
    {
        return i>=1 && i<=N && j>=1 && j<=N && !visited[i][j] && grid[i][j] == currentValue;
    }
    
    static void DFS(int i, int j)
    {
        if(!check(i, j))return;
        count++;
        visited[i][j] = true;
        for(int h = 0;h<dX.length;h++)
            DFS(i+dX[h], j+dY[h]);
        
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
         int[] posX, posY;
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
               N = Integer.parseInt(in.readLine());
               if(N == 0)break;
               if(N==1)
               {
                   System.out.println("good");
                   continue;
               }
               visited = new boolean[N+1][N+1];
               grid = new int[N+1][N+1];
               posX = new int[N];
               posY = new int[N];
               
               int i;
               String[] read = null;
               for(i=0;i<N-1;i++)
               {
                   read = in.readLine().split("[ ]+");
                   if(read[0].length() == 0)break;
                  // System.out.println(Arrays.toString(read)+"**"+read[0].length());
                   int u=0, v=0;
                   for(int j=0; j<read.length;j+=2)
                   {
                       u = Integer.parseInt(read[j]);
                       v = Integer.parseInt(read[j+1]);
                       grid[u][v] = i+1;
                   }
                   posX[i] = u;
                   posY[i] = v;
               }
               if(read[0].length() == 0)
               {
                   System.out.println("wrong");
                   continue;
               }
               boolean nofound = true;
               for(int ii =1;ii<=N && nofound;ii++)
                   for(int j= 1;j<=N && nofound;j++)
                       if(grid[ii][j]==0)
                       {
                           posX[i] = ii;
                           posY[i] = j;
                           nofound = false;
                       }
               
              /* for(int j = 0;j<=N;j++)
                   System.out.println(Arrays.toString(grid[j]));
               
               System.out.println(Arrays.toString(posX));
               System.out.println(Arrays.toString(posY)+"\n***");*/
               
               currentValue = 1;
               boolean answer = true;
               for(i = 0;i<N && answer;i++)
               {
                   count = 0;
                   DFS(posX[i], posY[i]);
                   if(count != N) answer = false;
                   currentValue = (currentValue+1)%N;
               }
               
               if(answer)
                   System.out.println("good");
               else System.out.println("wrong");
            }

        in.close();
        System.exit(0);
        
    }
}
