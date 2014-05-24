/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uva.projectEuler;
import java.io.*;
import java.util.StringTokenizer;



/**
 *
 * @author allegea
 */
public class P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
         //BufferedReader in   = new BufferedReader(new FileReader("triangulo.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           long seed1 = 1;
           long seed2 = 2;
           long curr = seed1 + seed2;
           long sum = 2;
           
           while(curr<4000000){
               seed1=seed2;
               seed2=curr;
               curr=seed1+seed2;
               
               if(curr%2==0)sum+=curr;
               
           }
           
           System.out.println(sum);
                
            

        
    }
}
