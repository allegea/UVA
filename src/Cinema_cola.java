/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class Cinema_cola {

    public static class Seat{
        boolean left;
        boolean right;

        Seat(boolean l, boolean r)
        {
            left = l;
            right = r;
        }
        Seat()
        {
            left = false;
            right = false;

        }
        
        @Override
        public String toString()
        {
            return left+" - "+right;
        }
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         Seat[][] cinema;
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               
               if(n == 0 && m == 0)break;
               cinema = new Seat[n][m];
               for(int i=0;i<n;i++)
                   for(int j=0;j<m;j++)
                       cinema[i][j] = new Seat();
               
               int nn = Integer.parseInt(in.readLine());
               for(int i=0;i<nn;i++)
               {
                   input = in.readLine().split("[ ]+");
                   int u = input[0].charAt(0)-'A';
                   //int v = input[0].charAt(1)-'1';
                   int v = Integer.parseInt(input[0].substring(1))-1;
                   if(input[1].charAt(0) == '-')
                   {
                       cinema[u][v].left = true;
                       if(v>1)
                        cinema[u][v-1].right = true;   
                   }                       
                   else {
                       cinema[u][v].right = true;
                       if(v<m-1)
                        cinema[u][v+1].left = true; 
                   }
               }
               
              /* for(int i=0;i<n;i++)
                   for(int j=0;j<m;j++)
                       System.out.println(i+" - "+j+" - "+cinema[i][j].toString());*/
               
              // System.out.println("***");
               int mm = Integer.parseInt(in.readLine());
               boolean can = true;
               for(int i=0;i<mm;i++)
               {
                   line = in.readLine();
                   int u = line.charAt(0)-'A';
                  // int v = line.charAt(1)-'1';
                   int v = Integer.parseInt(line.substring(1))-1;
                  // System.out.println(line+" - "+u+" - "+v+" - "+cinema[u][v]);
                   if( !cinema[u][v].left){
                        cinema[u][v].left = true;
                        if(v>1)
                        cinema[u][v-1].right = true;
                   }
                   else if(!cinema[u][v].right){
                       cinema[u][v].right = true;
                       if(v<m-1)
                        cinema[u][v+1].left = true; 
                   }
                   else {
                       can = false;
                       break;
                   }
               }
               
               System.out.println(can?"YES":"NO");
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
