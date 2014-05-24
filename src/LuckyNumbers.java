/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class LuckyNumbers {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

         //System.out.println("-- "+count);
        // System.out.println(Arrays.toString(almost));
         int[] base = new int[31623];
         int[] exp = new int[31623];
         for(int i=1;i*i<=1000000000;i++)
         {
             base[i-1]=i;
             exp[i-1]=i*i;
         }
                     
         
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
           StringBuilder out = new StringBuilder();
           int cases = Integer.parseInt(in.readLine());
           int now = 0;
            while (now++<cases) 
            {
               
                int n = Integer.parseInt(in.readLine());
                TreeSet<Integer> lis = new TreeSet<Integer>();

                for(int i=0;i<base.length;i++){
                    int aux = n-exp[i];
                    if(aux>0){
                        if(aux%base[i]==0)
                            lis.add(aux);
                    }else break;
                }
                
                out.append("Case ").append(now).append(":");
                Iterator answer = lis.iterator();
                while(answer.hasNext())
                {
                    out.append(" ").append(answer.next());
                }
                out.append("\n");
                
            }
          System.out.print(out);
        in.close();
        System.exit(0);
        
    }
}
