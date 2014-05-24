/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */
public class Continents {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M, count;
    static boolean[][] visited;
    static char[][] grid;
    static char character;
    static boolean check(int i, int j)
    {
        return i>=0 && i<M && !visited[i][j] && grid[i][j] == character; 
    }
    
    static void DFS(int i, int j)
    {
        if(!check(i, j))return;
        visited[i][j] = true;
        count++;
        
        for(int h = 0;h<dx.length;h++)
        {
            int u = i + dx[h];
            int v = (j + dy[h]+N)%(N);
            
            DFS(u, v);
        }
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
                String[] input = line.split("[ ]+");
               M= Integer.parseInt(input[0]);
               N= Integer.parseInt(input[1]);
               visited = new boolean[M][N];
               grid = new char[M][N];
               
               for(int i=0;i<M;i++)
                   grid[i] = in.readLine().toCharArray();
               
               input = in.readLine().split("[ ]+");
               int u= Integer.parseInt(input[0]);
               int v= Integer.parseInt(input[1]);
               
               //System.out.println(u+"-"+v);
               character = grid[u][v];
               count = 0;
               DFS(u, v);
               
               //for(int i=0;i<M;i++)
               //System.out.println(Arrays.toString(visited[i]));
               
               int answer = 0;
               for(int i=0;i<M;i++)
                   for(int j=0;j<N;j++)
                       if(!visited[i][j] && grid[i][j] == character)
                       {
                           count = 0;
                           DFS(i, j);
                           answer = Math.max(count, answer);
                       }
               
               //for(int i=0;i<M;i++)
               //System.out.println(Arrays.toString(visited[i]));
               
               System.out.println(answer);
               in.readLine();
                
            }

        in.close();
        System.exit(0);
        
    }
}
