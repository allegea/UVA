/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class FillTheContainers {
    
    public static int[] cont;
    public static int N, M, count;
    
    
    public static long BS()
    {
        long answer = 0;
        int L = 0;
        int R = 1000000000;

        while( L <= R)
        {
            int mid = (L + R) / 2;
            boolean retu = simulate(mid);
            //System.out.println(L + " - " + mid + " - " + R + " - "+retu + " - "+count);
            if(retu){

                    answer = mid;
                    R = mid - 1;
                
            }else L = mid + 1;
           
        }
        
        return answer;
    }
    
    public static boolean simulate(int x)
    {
        count = 1;
        int sum = cont[0];
        for(int i = 1; i < N; i++)
        {
           //System.out.println(sum);
           if(sum > x)return false;
           else if(sum == x || sum + cont[i] > x)
            {
                count++;
                sum = cont[i];
            } else sum+=cont[i];
            
        }
        if(sum > x)return false;
        return count <= M;
        
    }

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         String line = "";
         while( (line = in.readLine() ) != null)
         {
             st = new StringTokenizer(line);
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
             cont = new int[N];
             st = new StringTokenizer(in.readLine());
             for(int i = 0; i < N; i++)
                 cont[i] = Integer.parseInt(st.nextToken());
                 
             System.out.println(BS());
             
         }
         in.close();
         System.exit(0);
     }
}
