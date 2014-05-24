/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Alejandro E. Garces
 */
public class TheDieIsCast {

    static boolean[][] visited;
    static char[][] map;
    static int w,h, count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean check(int fil, int col)
    {
        return fil>=0 && fil <h && col>=0 && col<w && !visited[fil][col] && map[fil][col]!='.';
    }
    
    static void DFSX(int fil, int col)
    {
        for(int i=0; i<dx.length;i++)
        {
            int idx = fil+dx[i];
            int jdy = col+dy[i];
           // System.out.println(idx+"-"+jdy);
            if(check(idx, jdy))
            {
                //System.out.println(idx+"*"+jdy);
                if(map[idx][jdy] == 'X')
                {
                    visited[idx][jdy] = true;
                    DFSX(idx, jdy);
                }
            }
        }
    }
    static void DFS(int fil, int col)
    {
        if(map[fil][col]=='X')
        {
            count++;
            DFSX(fil, col);
        }
        for(int i=0; i<dx.length;i++)
        {
            int idx = fil+dx[i];
            int jdy = col+dy[i];
           // System.out.println(idx+"-"+jdy);
            if(check(idx, jdy))
            {
                //System.out.println(idx+"*"+jdy);
                visited[idx][jdy] = true;
                DFS(idx, jdy);
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
           //boolean nofirst = false;
           int cases = 1;
           while ((line = in.readLine()) != null) 
            {
                String[] input = line.split("[ ]+");
               w = Integer.parseInt(input[0]);
               h = Integer.parseInt(input[1]);
               if(w == 0 && h == 0)
                   break;
               ArrayList<Integer> dies = new ArrayList<Integer>();
               visited = new boolean[h][w];
               map = new char[h][w];
               
              /* if(nofirst)System.out.println();
               nofirst = true;*/
               
               for(int i=0;i<h;i++)
                   map[i] = in.readLine().toCharArray();
               
               for(int i=0;i<h;i++)
               {
                   for(int j=0;j<w;j++)
                   {
                       if(check(i,j))
                       {
                           //System.out.println(i+" - "+j);
                           count = 0;
                           visited[i][j] = true;
                           DFS(i, j);
                          // System.out.println(count);
                           dies.add(count);
                       }
                   }
               }
               
               Collections.sort(dies);
               StringBuilder out = new StringBuilder("Throw");
               out.append(" ").append(cases).append("\n");
               cases++;
               for(int i=0;i<dies.size()-1;i++)
                   out.append(dies.get(i)).append(" ");
               out.append(dies.get(dies.size()-1));
               System.out.println(out+"\n");
                
            }

        in.close();
        System.exit(0);
        
    }
}
