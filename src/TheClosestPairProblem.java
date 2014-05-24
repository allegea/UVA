/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class TheClosestPairProblem {

    public static final double MAX_DIS = 10000.0000;
    public static final double INF = Double.MAX_VALUE;
    public static class Pair implements Comparable<Pair>{
        
        double x;
        double y;
        Pair(double xx, double yy)
        {
            x = xx;
            y = yy;
        }
        @Override
        public int compareTo(Pair o)
        {
            if(this.x == o.x)return Double.compare(this.y, o.y);
            return Double.compare(this.x, o.x);
        }
        
        double dist(Pair o)
        {
            return (double)((x - o.x) * (x - o.x)   + (y - o.y) * (y - o.y));
        }
        
        public String toString()
        {
            return x + " - " + y; 
        }
        
    }
    
    public static double solve(int L, int R, Pair[] points)
    {
        if(L >= R)return INF;
        if(R - L == 1)return points[L].dist(points[R]);
        int mid = (L + R) / 2;
       // System.out.println("* " +L + " - " + mid + " - " + R);
        double d1 = solve(L, mid, points);
       // System.out.println(L + " - " + mid + " - " + d1);
        double d2 = solve(mid + 1, R, points);
       // System.out.println((mid + 1) + " - " + R + " - " + d2);
        double min = Math.min(d2, d1);
       // for(int i = mid - 1; i >= L && points[mid].x - points[i].x < min; i--)
         //for(int j = mid + 1; j <= R && points[j].x - points[mid].x < min; j++)
        for(int i = L; i <= mid; i ++)
            for( int j = mid + 1; j <= R && j <= mid + 7; j++)
                min = Math.min(min, points[i].dist(points[j]));
        return min;
    }
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
       /*DecimalFormatSymbols s = new DecimalFormatSymbols();
        s.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.0000", s);*/
         Pair[] points;
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         while(true)
         {
             int N = Integer.parseInt(in.readLine());
             if(N == 0)break;
             points = new Pair[N];
             for(int i = 0; i < N; i++)
             {
                 st = new StringTokenizer(in.readLine());
                 points[i] = new Pair(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
             }
             Arrays.sort(points);
             //System.out.println(Arrays.toString(points));

             double minDist = Math.sqrt(solve(0, N - 1, points));
             if(minDist >= MAX_DIS)System.out.println("INFINITY");
             else System.out.printf("%5.4f\n", minDist);
            // else System.out.println(df.format(minDist));
             
         }
         
         
         in.close();
         System.exit(0);
     }
}
