/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 *
 * @author allegea
 */
public class SkewBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
            while (!(line = in.readLine()).equals("0")) 
            {
               
                char[] numbers = line.toCharArray();
                int number = 0;
                int tam = line.length();
                for(int i=tam-1;i>=0;i--)
                {
                    number+=(numbers[i]-48)*((2<<(tam-i-1))-1);
                    //System.out.println((1<<(tam-i))-1);
                }
                System.out.println(number);
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
