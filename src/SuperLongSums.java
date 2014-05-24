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
public class SuperLongSums {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                in.readLine();
                int size =  Integer.parseInt(in.readLine());
                char[][] numbers = new char[3][size];
                
                
                for(int i=0;i<size;i++)
                {
                    StringTokenizer aux = new StringTokenizer(in.readLine());
                    numbers[0][i]=aux.nextToken().charAt(0);
                    numbers[1][i]=aux.nextToken().charAt(0);
                    
                }
     
                int acca = 0;
                
                for(int i=size-1;i>=0;i--)
                {
                    int num = (numbers[0][i]-48)+(numbers[1][i]-48)+acca;
                    numbers[2][i]=(char)(num%10+48);
                    acca=num/10;
                    //System.out.println(numbers[2][i]+" "+acca);
                    
                }
                
                System.out.println(numbers[2]);
                if(act!=cases)System.out.println();
               
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
