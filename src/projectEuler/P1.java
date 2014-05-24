/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uva.projectEuler;
import java.io.*;



/**
 *
 * @author allegea
 */
public class P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
         //BufferedReader in   = new BufferedReader(new FileReader("triangulo.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int upper = 999;
        int n = upper/3;
        int m = upper/5;
        int l = upper/15;
        
        n = ((n*(n+1))/2)*3;
        m = ((m*(m+1))/2)*5;
        l = ((l*(l+1))/2)*15;
        
        int answer = n+m-l;
        System.out.println(answer);

        
    }
}
