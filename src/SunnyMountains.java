/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */
public class SunnyMountains {

    public static class MyPoint implements Comparable {

        int x;
        int y;
        MyPoint(int _x, int _y)
        {
            x = _x;
            y = _y;
        }
        @Override
        public int compareTo(Object o) {
            return ((MyPoint)o).x-x;
        }
        
        double dist(MyPoint second){
            int _x = x-second.x;
            int _y = y-second.y;
            return Math.sqrt(_x*_x+_y*_y);
        }
        double dist(double XX, double YY){
            double _x = (double)x-XX;
            double _y = (double)y-YY;
            return Math.sqrt(_x*_x+_y*_y);
        }
        
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         MyPoint[] points;
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                
               int n= Integer.parseInt(in.readLine());
               points = new MyPoint[n];
               for(int i=0;i<n;i++)
               {
                   String[] read = in.readLine().split("[ ]+");
                   points[i] = new MyPoint(Integer.parseInt(read[0]), Integer.parseInt(read[1]));
               }
               Arrays.sort(points);
               double answer = 0;
               int posMaxY = 0;
               for(int i=1;i<n;i++)
               {
                   if(points[i].y>points[posMaxY].y)
                   {
                       int mA = points[i].y-points[i-1].y, mB = points[i].x-points[i-1].x;
                       double B = points[i].y-((mA*points[i].x)/(double)mB);
                       double dis = points[i].dist(((points[posMaxY].y-B)*mB)/mA, points[posMaxY].y);
                       answer+=(dis);
                       posMaxY = i;
                   }
               }
               System.out.printf("%.2f\n",answer);
                
            }

        in.close();
        System.exit(0);
        
    }
}
