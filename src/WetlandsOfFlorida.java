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
public class WetlandsOfFlorida {
WA
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int count, n, m;
    static boolean[][] visited;
    static char[][] grid;
    
    static boolean check(int i, int j)
    {
        return i>=0 && i<n && j>=0 && j<m && !visited[i][j] && grid[i][j] == 'W';
    }
    
    static void DFS(int i, int j)
    {
        for(int h = 0; h<dx.length;h++)
        {
            int u = i + dx[h];
            int v = j + dy[h];
            if(check(u,v))
            {
                visited[u][v] = true;
                //grid[u][v] = '.';
                count++;
                DFS(u,v);
            }
        }
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
           in.readLine();
            while (act++<cases) 
            {
                
                grid = new char[200][200];
                n = 0;
                while(!Character.isDigit((line = in.readLine()).charAt(0)))
                {
                    grid[n++] = line.toCharArray();
                }

                m = grid[0].length;
                visited = new boolean[n][m];
                
                while(true)
                {    
                    String[] read = line.split("[ ]+");
                    int i = Integer.parseInt(read[0])-1;
                    int j = Integer.parseInt(read[1])-1;
                    count = 0;
                    visited = new boolean[n][m];
                    //System.out.println("*** "+line+" - "+i+" - "+j);
                    if(check(i, j))
                    DFS(i, j);

                    /*for(int p=0;p<n;p++)
                    System.out.println(grid[p]);*/
                    System.out.println(count);
                    
                    line = in.readLine();
                    if(line != null && line.length()==0)break;
                }
                System.out.println();
                if(act==cases-1)
                    break;
                
                //System.out.println("***"+act);
            }

        in.close();
        System.exit(0);
        
    }
}
