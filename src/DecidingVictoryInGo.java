/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class DecidingVictoryInGo {
    
    public static char[][] grid;
    public static boolean[][] visited;
    public static int N = 9;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static int x, y;
    public static boolean foundEmpty;
    public static boolean foundOtherColor;
    public static int count = 0;
    
    public static boolean canGo(int i, int j)
    {
        return i >= 0 && i < N && j >= 0 && j < N;
    }
    
    public static void DFSCount(int i, int j, char color)
    {
       // if(foundOtherColor)return;
        if(canGo(i, j) && !visited[i][j])
        {
                
                if(grid[i][j] == '.')
                {
                    //System.out.println("DC - " + i + " - "+j);
                    visited[i][j] = true;
                    count++;
                    for(int h = 0; h < dx.length; h++)
                        DFSCount(i + dx[h], j + dy[h], color);
                }else if(grid[i][j] != color)
                    //System.out.println("Other Color - "+i+" - "+j);
                    foundOtherColor = true;
            
        }
        
    }
    
    public static void DFSEmpty(int i, int j, char color)
    {
        if(foundEmpty)return;
        if(canGo(i, j) && !visited[i][j])
        {
            
            if(grid[i][j] == '.')
            {
                x = i;
                y = j;
                foundEmpty = true;
                visited[i][j] = false;
                
            }else{
                if(grid[i][j] == color)
                {   visited[i][j] = true;
                    for(int h = 0; h < dx.length; h++)
                        DFSEmpty(i + dx[h], j + dy[h], color);
                    
                }
            }
            
        }
        
    }
    
    public static int count(char color)
    {
         visited = new boolean[N][N];
             int answer = 0;
             for(int i = 0; i < N; i++)
                 for(int j = 0; j < N; j++)
                 {
                     if(grid[i][j] == color )
                     {
                         answer++;
                         foundEmpty = false;
                         DFSEmpty(i, j, color);
                         if(foundEmpty)
                         {  //System.out.println("BW - "+x+" - "+y);
                             foundOtherColor = false;
                             count = 0;
                             DFSCount(x, y, color);
                            // System.out.println("BW - "+foundOtherColor+" - "+count);
                             if(!foundOtherColor)
                               answer+=count;  
                         }
                         
                     }
                     
                 }
             return answer;
    }
    
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(in.readLine());
         while(n-- > 0)
         {
             int white, black;
             white = black = 0;
             grid = new char[N][N];
             visited = new boolean[N][N];
             for(int i = 0 ; i< N ; i++)
                 grid[i] = in.readLine().toCharArray();
             
            black = count('X');
            white = count('O');
             
            
             System.out.println("Black "+black+" White "+white);
         }

         in.close();
         System.exit(0);
     }
}
