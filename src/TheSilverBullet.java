/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class TheSilverBullet {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         HashSet<Point2D.Double> pos;
         ArrayList<Point2D.Double> points;
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
               int n= Integer.parseInt(in.readLine());
               int p = 0;
               pos = new HashSet<Point2D.Double>();
               points = new ArrayList<Point2D.Double>();
               Point2D.Double aux;
               for(int i=0; i<n; i++)
               {
                   String[] read = in.readLine().split("[ ]+");
                   double u = Double.parseDouble(read[0]);
                   double v = Double.parseDouble(read[1]);
                   aux = new Point2D.Double(u, v);
                   if(pos.add(aux))
                   {
                       points.add(aux);
                   }
               }
               
               int count = 0;
               int size = points.size();
               if(size == 1)
               {
                   System.out.println("Data set #"+act+" contains a single gnu.");
                   continue;
               }
               Line2D.Double lin;

               //System.out.println(points);
               for(int i=0;i<size-1;i++)
               {
                   for(int j=i+1;j<size;j++)
                   {
                       int cou = 0;
                       lin = new Line2D.Double(points.get(i), points.get(j));
                       for(int h=0;h<size;h++)
                       {
                           if(h == j || h == i)continue;
                           //System.out.println(i+" - "+j+" - "+h+" - "+lin.relativeCCW(points.get(h)));
                           if(lin.relativeCCW(points.get(h)) == 0)
                           {
                               cou++;
                           }
                       }
                       count = Math.max(count, cou);
                   }
               }

               count+=2;
               System.out.println("Data set #"+act+" contains "+size+" gnus, out of which a maximum of "+count+" are aligned.");
            }

        in.close();
        System.exit(0);
        
    }
}
