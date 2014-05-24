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
public class BoxOfBricks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           int sets = 1;
            while (!(line = in.readLine()).equals("0")) 
            {
               int numbers = Integer.parseInt(line);
               int[] num = new int[numbers];
               int promedio = 0;
               StringTokenizer dates = new StringTokenizer(in.readLine());
               for(int i=0;i<numbers;i++)
               {
                   num[i]=Integer.parseInt(dates.nextToken());
                   promedio+=num[i];
               }
               
               promedio/=numbers;
               
               int total = 0;
               
               for(int i=0;i<numbers;i++)
                   if(num[i]>promedio) total+=num[i]-promedio;

               System.out.println("Set #"+sets+"\nThe minimum number of moves is "+total+".\n");
               sets++;
                
            }

        in.close();
        System.exit(0);
        
    }
}
