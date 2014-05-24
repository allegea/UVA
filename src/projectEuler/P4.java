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
public class P4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
         //BufferedReader in   = new BufferedReader(new FileReader("triangulo.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           
        long number = 600851475143l;
       
        
        for(int i=2;i*i<=number;i++){
            while(number%i==0){
                number/=i;
                System.out.println(i);
            }
        }
        
        if(number>1)System.out.println(number);
           
           
                
            

        
    }
}
