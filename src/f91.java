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
public class f91 {
    public static int[] answers = new int[2000000];
    public static int find(int n)
    {
        if(n >= 101) return n-10;
        if(answers[n]==0)
        {
            return answers[n] = find(find(n+11));
        }else return answers[n];
    }

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
            
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                
               int n= Integer.parseInt(in.readLine());
               if(n == 0)break;
               
               System.out.println("f91("+n+") = "+find(n));
                
            }

        in.close();
        System.exit(0);
        
    }
}
