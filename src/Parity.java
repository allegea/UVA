/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;



/**
 *
 * @author allegea
 */
public class Parity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        
         
           StringBuilder out = new StringBuilder();
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
               
               int x = Integer.parseInt(in.readLine());
               if(x==0)break;
               String binary = Integer.toBinaryString(x);
              int count = 0;
               for(int i=0;i<binary.length();i++)
                   if((x&(1<<i))!=0)count++;

               out.append("The parity of ").append(binary).append(" is ").append(count).append(" (mod 2).\n");
               /*out.append("The parity of ").append(binary).append(" is ").append(Integer.bitCount(x)).append(" (mod 2).\n");*/
                
            }

            System.out.print(out.toString());
        in.close();
        System.exit(0);
        
    }
}
