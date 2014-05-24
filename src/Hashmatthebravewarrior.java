/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;


/**
 *
 * @author allegea
 */
public class Hashmatthebravewarrior {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) /*throws IOException*/ {
        //Scanner in = new Scanner(new File("pruebas.txt"));
  
        Scanner in = new Scanner(System.in);
        
        try{
        String line = in.nextLine();
        while(!line.isEmpty())
        {
            StringTokenizer dates = new StringTokenizer(line);
            long a = Long.parseLong(dates.nextToken());
            long b = Long.parseLong(dates.nextToken());
            
            System.out.println(Math.abs(a-b));
            
            line = in.nextLine();

        }
        }
        catch(java.util.NoSuchElementException e)
        {
            
        }
        
        System.exit(0);

    }
    
}
