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
public class P6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
       int n = 100;
       int sum = n*(n+1)/2;
       int sum2 = (n*(n+1)*(2*n+1))/6;
       
       int answer = sum*sum-sum2;
       
       System.out.println(answer);
        
    }
}
