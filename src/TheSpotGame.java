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
public class TheSpotGame {
    
    static String toString(int[][] board, int n)
    {
        StringBuilder output = new StringBuilder();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                output.append(board[i][j]);
        //System.out.println(output);
        return output.toString();
    }
    
    static int[][] rotate(int[][] board, int n)
    {
        int[][] rot = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            rot[n-1-j][i] = board[i][j];
        return rot;
    }
   public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int[][] board;
         HashSet<String> visited;
         int[][] aux;
         String a, b, c, d;

         while(true)
         {
             int n = Integer.parseInt(in.readLine());
             visited = new HashSet<String>();
             if(n == 0)break;
             board = new int[n][n];
             visited.add(toString(board, n));
             boolean noWin = true;
             int player = 0;
             int i = 0;
             String line = "";
            // boolean noAdd;
             for(i=0;i<2*n;i++)
             {
                 line = in.readLine();
                 if(!noWin)continue;
                 
                 String[] read = line.split("[ ]+");
                 int u = Integer.parseInt(read[0])-1;
                 int v = Integer.parseInt(read[1])-1;
                 if(read[2].charAt(0) == '+') board[u][v] = 1;
                 else board[u][v] = 0;
                 
                 a = toString(board,n);
                 if(visited.contains(a)){
                     noWin = false;
                     System.out.println("Player "+(2-player)+" wins on move "+(i+1));
                     continue;
                 }
                 
                 aux = rotate(board, n);
                 b = toString(aux,n);
                /* if(visited.contains(b)){
                     noWin = false;
                     break;
                 }*/
                 aux = rotate(aux, n);
                 c = toString(aux,n);
                /* if(visited.contains(c)){
                     noWin = false;
                     break;
                 }*/
                 aux = rotate(aux, n);
                 d = toString(aux,n);
                 /*if(visited.contains(d)){
                     noWin = false;
                     break;
                 }*/
                 
                     visited.add(a);
                     visited.add(b);
                     visited.add(c);
                     visited.add(d);
                 player = 1-player;
             }
             
             if(noWin) System.out.println("Draw");
            
         }
         in.close();
         System.exit(0);
     }
}
