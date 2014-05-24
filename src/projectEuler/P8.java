/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uva.projectEuler;
import java.io.*;
import java.math.BigInteger;



/**
 *
 * @author allegea
 */
public class P8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
       
        BufferedReader in   = new BufferedReader(new FileReader("P8.txt"));
        int max = 0;
        int prod = 1;
        while(in.ready()){
            
            char[] numbers = in.readLine().toCharArray();
            for(int i=0;i<numbers.length-5;i++){
                prod = 1;
                for(int j=i;j<5+i;j++)
                    prod*=(numbers[j]-48);

                if(prod>max)max=prod;
            }
        }
        
        System.out.println(max);
        
      
        
    }
}
