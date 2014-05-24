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
public class TheRascalTriangle {

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
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int x= Integer.parseInt(input[1]);
               int y= Integer.parseInt(input[2]);
               if(x == 0) {
                   System.out.println(n+" 1");
                   continue;
               }
               int[] aux = new int[x+1];
                        
                int pos = 1;
                aux[0] = 1;
                aux[pos++] = x;
                int res = x-3;
                while(res>=0)
                {
                    aux[pos]=aux[pos-1]+res;
                    pos++;
                    res-=2;
                }
               
               // System.out.println(Arrays.toString(aux)+" - "+pos);
                if(y>x/2)
                    System.out.println(n+" "+(aux[x-y]));
                else System.out.println(n+" "+(aux[y]));
                
            }

        in.close();
        System.exit(0);
        
    }
}
