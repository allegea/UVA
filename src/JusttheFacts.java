/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;



/**
 *
 * @author allegea
 */
public class JusttheFacts {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
          
            while ((line = in.readLine()) != null) 
            {
               int fact = Integer.parseInt(line);
               int answer = 1;
               
               for(int i=2;i<=fact;i++)
               {
                   answer*=i;
                   while(answer%10==0)
                       answer/=10;
                   answer%=100000;
               }
               
               for(int i=0;i<5-line.length();i++)
               {
                   System.out.print(" ");
               }
               
               System.out.println(fact+" -> "+answer%10);
                
            }

        in.close();
        System.exit(0);
        
    }
}
