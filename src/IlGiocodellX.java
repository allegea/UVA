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
public class IlGiocodellX {

    private static int max;
    private static int size;
    private static char[][] board;
    private static boolean[][] visited;
    private static boolean found;
    private static int[] dx = {-1, 0, 1, -1, 0, 1};
    private static int[] dy = {-1, -1, 0, 0, 1, 1};
    
    public static boolean check(int fil, int col)
    {
        return fil>=0 && fil<size && col>=0 && col<size && !visited[fil][col] &&  board[fil][col]=='b';
    }
    public static void DFS(int fil, int col)
    {
        if(found)return;
        max = Math.max(max, fil);
       
        if(max == size -1)
            found = true;
        for(int i=0;i<dx.length;i++)
        {
            if(check(fil+dx[i], col+dy[i]))
            {
                visited[fil+dx[i]][col+dy[i]] = true;
                DFS(fil+dx[i], col+dy[i]);
                //visited[fil+dx[i]][col+dy[i]] = false;
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
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           int game = 1;
            while ((line = in.readLine()) != null) 
            {
               int n= Integer.parseInt(line);
               if(n==0)break;
               size = n;
               board = new char[n][n];
               visited = new boolean[n][n];
               for(int i=0;i<n;i++)
                   board[i] = in.readLine().toCharArray();

               found = false;
               for(int i=0;i<n && !found;i++)
               {   
                   max = 0;
                   if(!check(0,i))continue;
                   visited[0][i] = true;
                   DFS(0, i);

               }
               //System.out.println(Arrays.deepToString(visited));
               if(found)
                   System.out.println(game+" B");
               else System.out.println(game+" W");
               game++;
                
            }

        in.close();
        System.exit(0);
        
    }
}
