/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 *
 * @author allegea
 */
public class RotatingSentences {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           char[][] characters = new char[100][100];
           int c=0;
           int mayor = 0;
            while ((line = in.readLine()) != null) 
            {
               
                characters[c++] = line.toCharArray();
               mayor = line.length()>mayor?line.length():mayor;
                
            }
            
            for(int i=0;i<mayor;i++)
            {
                for(int j=c-1;j>=0;j--)
                {
                    if(characters[j].length>i)
                    System.out.print(characters[j][i]);
                    else System.out.print(' ');
                
                    
                }
                System.out.println();
                
            }


        in.close();
        System.exit(0);
        
    }
}
