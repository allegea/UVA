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
public class MazeExploration {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static char[][] grid;
    static int n;
    
    static boolean check(int i, int j)
    {
        //System.out.println(i+" - "+j + " - "+grid[i][j]);
        return i<0 || i ==n || j<0 || grid[i].length == j || visited[i][j] || (grid[i][j] != '*' && grid[i][j] != ' ');
    }
    static void DFS(int i, int j)
    {
        if(check(i, j))return;
        
        visited[i][j] = true;
        
        grid[i][j] = '#';
        for(int u=0;u<dx.length;u++)
            DFS(i+dx[u],j+dy[u]);
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         
           String line, separate;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                grid = new char[50][100];
                visited = new boolean[50][100];
                n = 0;

                while(true)
                {
                    line = in.readLine();
                    if(line.charAt(0)=='_')
                    {
                        separate = line;
                        break;
                    }
                    visited[n] = new boolean[line.length()];
                    grid[n++] = line.toCharArray();
                }

                
                for(int i=0;i<n;i++)
                    for(int j=0;j<grid[i].length;j++)
                        if(grid[i][j]=='*')
                            DFS(i, j);
                
                for(int i=0;i<n;i++)
                    System.out.println(grid[i]);
                System.out.println(separate);
                
            }

        in.close();
        System.exit(0);
        
    }
}
