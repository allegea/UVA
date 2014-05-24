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
public class BacktoHighSchoolPhysics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) /*throws IOException*/{
        //Scanner in = new Scanner(new File("pruebas.txt"));
  
        Scanner in = new Scanner(System.in);
        

        
        
        try{
        String line = in.nextLine();
        while(!line.isEmpty())
        {
            StringTokenizer dates = new StringTokenizer(line);
            long a = Long.parseLong(dates.nextToken());
            long b = Long.parseLong(dates.nextToken());
            
            System.out.println((a*b*2));
            
            line = in.nextLine();

        }
        }
        catch(java.util.NoSuchElementException e)
        {
            
        }
        
        System.exit(0);

    }
    
}
/*
 * public static void main(String[] args) {
        
        try{

        BufferedReader in = new BufferedReader(new FileReader("pruebas.txt"));

        
        
        
        
        String line = in.readLine();
        while(!line.isEmpty())
        {
            StringTokenizer dates = new StringTokenizer(line);
            long a = Long.parseLong(dates.nextToken());
            long b = Long.parseLong(dates.nextToken());
            
            System.out.println((a*b*2));
            
            line = in.readLine();

        }
        }
        catch(IOException e)
        {
            System.exit(0);
        }
        
        System.exit(0);

    }*/