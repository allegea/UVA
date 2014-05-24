/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;


/**
 *
 * @author allegea
 */
public class BaudotDataCommunicationCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
        
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         char[] ctsu = in.readLine().toCharArray();
         char[] ctsl = in.readLine().toCharArray();
         
         String up = "11111";
         String down = "11011";
         //boolean ups = true;
         
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
                 boolean ups = true;
               for(int i=0;i<line.length();i+=5)
               {
                   String sub = line.substring(i, i+5);
                   if(sub.equals(up))
                   {
                       ups=false;
                       continue;
                   }
                   if(sub.equals(down))
                   {
                       ups=true;
                       continue;
                   }
                   
                   if(ups)
                       System.out.print(ctsu[Integer.parseInt(sub, 2)]);
                   else
                       System.out.print(ctsl[Integer.parseInt(sub, 2)]);
 
               }
                System.out.println();
                
            }

        in.close();
        System.exit(0);
        
    }
}
