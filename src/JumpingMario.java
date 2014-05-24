/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro E. Garces
 */
public class JumpingMario {

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
            while (act++<cases) 
            {
                int up=0,down=0;
               int n = Integer.parseInt(in.readLine());
               line = in.readLine();
               if(n==1){
                   System.out.println("Case "+act+": 0 0");
                   continue;
               }
               StringTokenizer read = new StringTokenizer(line);
               int prev = -1;
               int now = 0;
               while(read.hasMoreTokens())
               {
                   now = Integer.parseInt(read.nextToken());
                   if(prev==-1){
                       prev=now;
                       continue;
                   }
                   
                   if(now-prev>0)up++;
                   if(now-prev<0)down++;
                   
                   prev=now;
                   
               }
               System.out.println("Case "+act+": "+up+" "+down);
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
