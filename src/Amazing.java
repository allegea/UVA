/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class Amazing {

     static char[][] board;
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    
    static boolean canGo(int i, int j)
    {
        return i>=0 && i<n && j>=0 && j<m && board[i][j] != '1';
    }
    
    static boolean wallOnRight(int i, int j)
    {
        //System.out.println("Wall? " + i+" - "+j);
        return !(i>=0 && i<n && j>=0 && j<m && board[i][j] != '1');
    }
    static void Simulate()
    {
        int[][] in = new int[n][m];
        int[][] out = new int[n][m];
        int[] count  = new int[5];
        
        int x = n-1;
        int y = 0;
        int dir = 0;
        while(true)
        {
            if(x == n-1 && y == 0 && in[x][y] == 1 && out[x][y] == 1)break;
            //System.out.println(x+" - "+y+" - "+dir);
                int u = x+dx[dir];
                int v = y+dy[dir];
                if(canGo(u, v))
                {
                    in[u][v]++;
                    out[x][y]++;
                    x = u;
                    y = v;
                    if(!wallOnRight(x+dx[(dir+1)%4],y+dy[(dir+1)%4]))
                    {
                        dir = (dir+1)%4;
                        //System.out.println("No Wall");
                    }
                    
                }else{
                    dir = (dir-1+4)%4;
                     //System.out.println("Rotate");
                }
            
        }
      
            
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(board[i][j] != '1')
                    count[Math.min(in[i][j], out[i][j])]++;
        
        System.out.printf("%3d%3d%3d%3d%3d\n",count[0],count[1],count[2],count[3],count[4]);
    }
    
    public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         while(true)
         {
             String[] read = in.readLine().split("[ ]+");
             n = Integer.parseInt(read[0]);
             m = Integer.parseInt(read[1]);
             if(n == 0 && m == 0)break;
             board = new char[n][m];
             for(int i=0;i<n;i++)
                 board[i] = in.readLine().toCharArray();
             
             Simulate();
             
         }
         in.close();
         System.exit(0);
     }
     

}
