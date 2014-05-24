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
public class P16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
         //BufferedReader in   = new BufferedReader(new FileReader("triangulo.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BigInteger two = new BigInteger("2");
        two = two.pow(1000);
        
        System.out.println(two);
        char[] numbers = two.toString().toCharArray();
        
        int sum = 0;
        for(int i=0;i<numbers.length;i++)
            sum+=(numbers[i]-48);
        
        System.out.println(sum);

        
    }
}
