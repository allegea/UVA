

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;



/**
 *
 * @author allegea
 */
public class KnightMoves {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         Queue<Integer> x;
         Queue<Integer> y;
         
           String line;
           boolean[][] visited;
           
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
               char[] info = line.toCharArray();
               int oRow = info[0]-97;
               int dRow = info[3]-97;
               int oCol = info[1]-49;
               int dCol = info[4]-49;
               visited = new boolean[8][8];
               x = new LinkedList<Integer>();
               y = new LinkedList<Integer>(); 
               visited[oRow][oCol]=true;
               x.offer(oRow);
               y.offer(oCol);
               int dist = 0;
               int procesar = 1;
               int nPro = 0;
               int cXa;
               int cYa;
               boolean end = false;
               while(!x.isEmpty())
               {
                   int h=0;
                   while(h++<procesar)
                   {
                       int cX = x.poll();
                       int cY = y.poll();
                       if(cX==dRow && cY==dCol){
                           end = true;
                           break;
                       }
                       cXa = cX+2;
                       cYa = cY+1;
                       if(cXa<8 && cYa<8){
                           if(!visited[cXa][cYa]){
                               x.offer(cXa);
                               y.offer(cYa);
                               visited[cXa][cYa]=true;
                               nPro++;
                           }
                       }
                       
                       cXa = cX+2;
                       cYa = cY-1;
                       if(cXa<8 && cYa>=0){
                           if(!visited[cXa][cYa]){
                               x.offer(cXa);
                               y.offer(cYa);
                               visited[cXa][cYa]=true;
                               nPro++;
                           }
                       }
                       
                       cXa = cX-2;
                       cYa = cY+1;
                       if(cXa>=0 && cYa<8){
                           if(!visited[cXa][cYa]){
                               x.offer(cXa);
                               y.offer(cYa);
                               visited[cXa][cYa]=true;
                               nPro++;
                           }
                       }
                       
                       cXa = cX-2;
                       cYa = cY-1;
                       if(cXa>=0 && cYa>=0){
                           if(!visited[cXa][cYa]){
                               x.offer(cXa);
                               y.offer(cYa);
                               visited[cXa][cYa]=true;
                               nPro++;
                           }
                       }
                       
                       cXa = cX+1;
                       cYa = cY+2;
                       if(cXa<8 && cYa<8){
                           if(!visited[cXa][cYa]){
                               x.offer(cXa);
                               y.offer(cYa);
                               visited[cXa][cYa]=true;
                               nPro++;
                           }
                       }
                       
                       cXa = cX-1;
                       cYa = cY+2;
                       if(cXa>=0 && cYa<8){
                           if(!visited[cXa][cYa]){
                               x.offer(cXa);
                               y.offer(cYa);
                               visited[cXa][cYa]=true;
                               nPro++;
                           }
                       }
                       
                       cXa = cX+1;
                       cYa = cY-2;
                       if(cXa<8 && cYa>=0){
                           if(!visited[cXa][cYa]){
                               x.offer(cXa);
                               y.offer(cYa);
                               visited[cXa][cYa]=true;
                               nPro++;
                           }
                       }
                       
                       cXa = cX-1;
                       cYa = cY-2;
                       if(cXa>=0 && cYa>=0){
                           if(!visited[cXa][cYa]){
                               x.offer(cXa);
                               y.offer(cYa);
                               visited[cXa][cYa]=true;
                               nPro++;
                           }
                       }
                   }
                   
                   procesar=nPro;
                   nPro=0;
                   if(end)break;
                   dist++;
                   
                   
               }
               System.out.println("To get from "+info[0]+info[1]+" to "+info[3]+info[4]+" takes "+dist+" knight moves.");
            }

            
        in.close();
        System.exit(0);
        
    }
}

/*
import java.util.*;


import java.io.*;

public class KnightMoves {

    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

    static boolean inside(int r, int c) {
        return r >= 0 && c >= 0 && r < 8 && c < 8;
    }

    static int[][] bfs(int r, int c) {
        int[][] distance = new int[8][8];
        boolean[][] visited = new boolean[8][8];
        for (int i = 0; i < 8; ++i) {
            Arrays.fill(distance[i], -1);
        }
        Queue<Integer> Qr = new LinkedList<Integer>();
        Queue<Integer> Qc = new LinkedList<Integer>();
        distance[r][c] = 0;
        visited[r][c] = true;
        Qr.offer(r);
        Qc.offer(c);
        while (!Qr.isEmpty()) {
            int i = Qr.poll();
            int j = Qc.poll();
            for (int d = 0; d < 8; ++d) {
                int nr = i + dr[d];
                int nc = j + dc[d];
                if (inside(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    distance[nr][nc] = distance[i][j] + 1;
                    Qr.offer(nr);
                    Qc.offer(nc);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] squares = line.split("[ ]");
            int c1 = squares[0].charAt(0) - 'a';
            int r1 = squares[0].charAt(1) - '1';
            int c2 = squares[1].charAt(0) - 'a';
            int r2 = squares[1].charAt(1) - '1';
            int[][] distance = bfs(r1, c1);
            System.out.println("To get from " + squares[0] + " to " + squares[1]
                    + " takes " + distance[r2][c2] + " knight moves.");
        }
    }
}*/