/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro E. Garces
 */
public class AddAll {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
         PriorityQueue<Long> set;
         long answer = 0;
         long aux=0;
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                int n = Integer.parseInt(in.readLine());
                if(n==0)break;
                
                answer = 0;
                aux=0;
                set = new PriorityQueue<Long>();
                StringTokenizer read = new StringTokenizer(in.readLine());
                for(int i=0;i<n;i++)
                    set.offer(Long.parseLong(read.nextToken()));
                
                while(set.size()>1)
                {
                    aux = set.poll()+set.poll();
                    answer+=aux;
                    set.offer(aux);
                    //System.out.println(set+" - "+aux+" - "+answer);
                }
                System.out.println(answer);
            }

        in.close();
        System.exit(0);
        
    }
}
