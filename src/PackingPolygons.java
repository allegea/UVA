/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.geom.Point2D;
import java.io.*;

a

import java.util.*;

/**
 *
 * @author allegea
 */
public class PackingPolygons {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
         
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                int vertix = Integer.parseInt(in.readLine());
                if(vertix==0)break;
                
                Point2D[] points = new Point2D[vertix];
                
                if(vertix==1)
                {
                    System.out.println("The polygon can be packed in the circle.");
                    in.readLine();
                    in.readLine();
                    continue;
                }
                
                double max=0;
                for(int i=0;i<vertix;i++)
                {
                    StringTokenizer locations = new StringTokenizer(in.readLine());
                    
                    double x = Double.parseDouble(locations.nextToken());
                    double y = Double.parseDouble(locations.nextToken());
                    //System.out.println("---"+x+"   --- "+y+" - "+i);
                    points[i] = new Point2D.Double(x,y);
                     
                        
                }
                double r = Double.parseDouble(in.readLine());
                boolean res = true;
                for(int i=0;i<vertix;i++)
                {
                    for(int j=0;j<vertix;j++)
                    {

                        if(i==j)continue;
                        double dist =points[i].distance(points[j]);
                        max=max<dist?dist:max;
                        if(dist>2*r)
                        {
                            res = false;
                            break;
                        }
                   
                    }
                    
                    if(!res)break;
                }
                
                
               //System.out.println(2*r+" "+max);
                if(res)
                {
                    System.out.println("The polygon can be packed in the circle.");
                }
                else System.out.println("There is no way of packing that polygon.");
               
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
