/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */
public class IsolatedSegments {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         Line2D.Double[] points;
         boolean[] noIsolate;
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
               
               int n= Integer.parseInt(in.readLine());
               points = new Line2D.Double[n];
               noIsolate = new boolean[n];
               for(int i=0;i<n;i++)
               {
                   String[] read = in.readLine().split("[ ]+");
                   int x1 = Integer.parseInt(read[0]);
                   int y1 = Integer.parseInt(read[1]);
                   int x2 = Integer.parseInt(read[2]);
                   int y2 = Integer.parseInt(read[3]);
                   points[i] = new Line2D.Double(x1, y1, x2, y2);
               }
               
               int answer = 0;
               System.out.println(Arrays.toString(points));
               for(int i=0;i<n-1;i++)
               {
                   if(noIsolate[i])continue;
                   for(int j=i+1;j<n;j++)
                   {
                       System.out.println(i+" - "+j+" - "+points[i].intersectsLine(points[j]));
                       if(points[i].intersectsLine(points[j]))
                       {
                           noIsolate[j] = true;
                           noIsolate[i] = true;
                           break;
                       }
                   }
                   if(!noIsolate[i])answer++;    
               }
                
               System.out.println(answer);
            }

        in.close();
        System.exit(0);
        
    }
}
