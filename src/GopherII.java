/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Point;
import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class GopherII {

    static ArrayList<Integer> nodes;
    static int[] X, Y;
    static long getDistance(int i, int j)yu
    {
        return ( X[i] - X[j] ) * ( X[i] - X[j] ) +  ( Y[i] - Y[j] ) * ( Y[i] - Y[j] );
    }
   static int MaxFlow(int source, int sink)
   {
       int inFlow = 0;
       return inFlow;
   }
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String line = "";
         StringTokenizer st;
         int N, M, S, V, source, sink;
         Point.Float[] points;
         points[2].d
         while(( line = in.readLine() ) != null && line.length() > 0)
         {
             st = new StringTokenizer(line);
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
             S = Integer.parseInt(st.nextToken());
             V = Integer.parseInt(st.nextToken());
             
         }
         in.close();
         System.exit(0);
     }
}
