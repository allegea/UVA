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
public class Lakes {

    public static char[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1,  0, -1};
    public static int M, M2;
    public static boolean canGo(int i, int j)
    {
        return i >= 0 && i < M && j >= 0 && j < M2 && grid[i][j] == '0' && !visited[i][j];   
    }
    
    public static int DFS(int i, int j)
    {
        if(!canGo(i, j))return 0;
        visited[i][j] = true;
        int count = 1;
        for(int h = 0; h < dx.length; h++)
            count+=DFS(i + dx[h], j + dy[h]);
        return count;        
    }
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         int N = Integer.parseInt(in.readLine().trim());
         StringTokenizer st;
         ArrayList<String> input;
         boolean noFirst = false;
         in.readLine();
         while(N-- > 0)
         {
             //in.readLine();
             if(noFirst)System.out.println();
             noFirst = true;
             
             st = new StringTokenizer(in.readLine().trim());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());
            // System.err.println(x + " - "  + y);
             input = new ArrayList<String>();
             String line = "";
             while(true)
             {
                 if((line = in.readLine()) == null)break;
                 line = line.trim();
                 //System.out.println(line + " - " +line.length());
                 if(line.length() == 0)break;
                 input.add(line);
                 
             }
                 
             
             //System.out.println(input);
             M = input.size();
             M2 = input.get(0).length();
            // System.err.println(M + " * "  + M2);
             grid = new char[M][M2];
             visited = new boolean[M][M2];

             for(int i = 0; i < M; i++)
                 grid[i] = input.get(i).toCharArray();
            // System.err.println(x + " - "  + y);
             System.out.println(DFS(x - 1, y - 1));
             
         }
         in.close();
         System.exit(0);
     }
}
