/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.awt.Polygon;
import java.util.StringTokenizer;



/**
 *
 * @author allegea
 */
public class PolygonE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           StringBuilder out = new StringBuilder();
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                int vertix = Integer.parseInt(in.readLine());
                if(vertix==0)break;
                Polygon pol = new Polygon();
                for(int i=0;i<vertix;i++){
                    StringTokenizer point = new StringTokenizer(in.readLine());
                    int x = Integer.parseInt(point.nextToken());
                    int y = Integer.parseInt(point.nextToken());
                    pol.addPoint(x, y);
                }
                
                StringTokenizer inside = new StringTokenizer(in.readLine());
                    int x = Integer.parseInt(inside.nextToken());
                    int y = Integer.parseInt(inside.nextToken());
                    if(pol.contains(x, y))out.append("T\n");
                    else out.append("F\n");
                
            }

            System.out.print(out);
        in.close();
        System.exit(0);
        
    }
}
