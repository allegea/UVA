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
public class CrazyKing {

    static int N;
    static int M;
    static boolean[][] visited;
    static char[][] grid;
    static int[] dxKing = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dyKing = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dxHorse = {-1, 1, -2, 2, -2, -1, 1, 2};
    static int[] dyHorse = {2, 2, 1, 1, -1, -2, -2, -1};
    
    static boolean checkInsideK(int i, int j)
    {
        return i>=0 && i<N && j>=0 && j<M && !visited[i][j] && grid[i][j] != 'Z' && grid[i][j] != 'X'; 
    }
    
    static boolean checkInsideH(int i, int j)
    {
        return i>=0 && i<N && j>=0 && j<M && grid[i][j] == '.'; 
    }
    static void pathOfHorse(int i,int j)
    {
        
        for(int h = 0;h<dxHorse.length;h++)
        {
            int u = i + dxHorse[h];
            int v = j + dyHorse[h];
            if(checkInsideH(u, v))
                grid[u][v] = 'X';
        }
    }
    
    static void print()
    {
        System.out.println("*************");
        for(int i=0;i<grid.length;i++)
            System.out.println(grid[i]);
        System.out.println("*************");
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
           
           int[][] lenghts;
           Queue<Integer> qX;
           Queue<Integer> qY;
            while (act++<cases) 
            {
                String[] input = in.readLine().split("[ ]+");
               N = Integer.parseInt(input[0]);
               M = Integer.parseInt(input[1]);
               visited = new boolean[N][M];
               grid = new char[N][M];
               lenghts = new int[N][M];
               for(int i=0;i<N;i++)
                   grid[i] = in.readLine().toCharArray();
               
               int answer = 0;
               int ii=-1, jj=-1;
               for(int i=0;i<N;i++)
                   for(int j=0;j<M;j++)
                       if(grid[i][j] == 'A')
                       {
                           ii = i;
                           jj = j;
                       }else if(grid[i][j] == 'Z')
                           pathOfHorse(i, j);
               
               qX = new LinkedList<Integer>();
               qY = new LinkedList<Integer>();
               qX.offer(ii);
               qY.offer(jj);
              
               //print();
               
               visited[ii][jj] = true;
               while(!qX.isEmpty())
               {
                   ii = qX.poll();
                   jj = qY.poll();
                   if(grid[ii][jj]=='B')
                   {
                       answer = lenghts[ii][jj];
                       break;
                   }
                   
                   for(int i=0;i<dxKing.length;i++)
                   {
                       int u = ii + dxKing[i];
                       int v = jj + dyKing[i];
                       if(checkInsideK(u, v))
                       {
                           visited[u][v] = true;
                           qX.offer(u);
                           qY.offer(v);
                           lenghts[u][v] = lenghts[ii][jj]+1;
                       }
                   }
               }
               
              /* for(int i=0;i<N;i++)
                   System.out.println(Arrays.toString(lenghts[i]));*/
               if(answer == 0)
               System.out.println("King Peter, you can't go now!");
               else System.out.println("Minimal possible length of a trip is "+answer); 
                
            }

        in.close();
        System.exit(0);
        
    }
}
