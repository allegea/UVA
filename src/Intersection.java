/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class Intersection {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
           Rectangle2D.Double rect =  new Rectangle2D.Double();
           Line2D.Double lin = new Line2D.Double();
           
            while (act++<cases) 
            {
                String[] input = in.readLine().split("[ ]+");
               int xT= Integer.parseInt(input[0]);
               int yT= Integer.parseInt(input[1]);
               int xE= Integer.parseInt(input[2]);
               int yE= Integer.parseInt(input[3]);
               int xL= Integer.parseInt(input[4]);
               int yTo= Integer.parseInt(input[5]);
               int xR= Integer.parseInt(input[6]);
               int yB= Integer.parseInt(input[7]);
                rect.setFrameFromDiagonal(xL, yTo, xR, yB);
               //rect = new Rectangle2D.Double (xL, yB, xR -xL, yTo-yB );
               lin = new Line2D.Double(xT, yT, xE, yE);
              // System.out.println(rect);
              // System.out.println(lin.getP1());
               //System.out.println(lin.getP2());
              // System.out.println(rect.intersectsLine(lin));
              // System.out.println(rect.getCenterX());
               //System.out.println(rect.getCenterY());
               System.out.println(rect.intersectsLine(lin)?"T":"F");
               
              
                
            }

        in.close();
        System.exit(0);
        
    }
}
