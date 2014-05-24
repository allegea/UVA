/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class TheArtGallery {

    public static int CCW(Point a, Point b, Point c)
    {
        return a.x * b.y - a.y * b.x + a.y * c.x -a.x * c.y + b.x * c.y - c.x * b.y;
        //return (a.x*b.y - b.x*a.y)+(b.x*c.y-c.x*b.y)+(c.x*a.y-a.x*c.y);
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         Point[] polygon;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                
               int n= Integer.parseInt(in.readLine());
               if(n == 0)break;
              
               polygon = new Point[n];
               for(int i=0;i<n;i++)
               {
                   String[] read = in.readLine().split("[ ]+");
                   polygon[i] = new Point(Integer.parseInt(read[0]), Integer.parseInt(read[1]));
               }
               
               boolean answer = true;
               int angule = CCW(polygon[0], polygon[1], polygon[2]);
               boolean isLeft = angule>0?true:false;
               for(int i=1;i<n && answer;i++)
               {
                   boolean turn = CCW(polygon[i], polygon[(i+1)%n], polygon[(i+2)%n])>0?true:false;
                   if(turn!=isLeft)
                       answer = false;
               }
               
               System.out.println(answer?"No":"Yes");
                
            }

        in.close();
        System.exit(0);
        
    }
}
