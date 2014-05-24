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
public class Bars {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         int n = Integer.parseInt(in.readLine());
         int act=0;
            while (act++<n) 
            {
               long bar= Long.parseLong(in.readLine());
               if(bar==0){
                   in.readLine();
                   in.readLine();
                   System.out.println("YES");
                   continue;
               }
               int m=Integer.parseInt(in.readLine());
               long[] vec = new long[m];
               StringTokenizer x = new StringTokenizer(in.readLine());
               int i=0;
               while(x.hasMoreTokens())
                   vec[i++]=Long.parseLong(x.nextToken());
               
               long sum=0;
               boolean answer=false;
               boolean con = true;
               for(i=0;i<(1<<m) && !answer;i++){
                   sum=0;
                   con=true;
                   for(int j=0;j<m && con;j++){
                       if((i&(1<<j))!=0)
                       {
                           sum+=vec[j];
                           if(sum==bar){
                               answer=true;
                               break;
                           }else if (sum>bar)con=false;
                           
                       }
                   }
               }
                
               if(answer)
                   System.out.println("YES");
               else System.out.println("NO");
                
            }

        in.close();
        System.exit(0);
        
    }
}
