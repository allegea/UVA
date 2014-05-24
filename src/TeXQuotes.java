/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 *
 * @author allegea
 */
public class TeXQuotes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
           String line;
           boolean first = true;
            while ((line = in.readLine()) != null) 
            {
                
               char[] text = line.toCharArray();
               for(int i=0;i<text.length;i++)
               {
                   if(text[i]=='"')
                   {
                       if(first==true) 
                       {
                           text[i]='`';
                           System.out.print('`');
                           first = false;
                       }
                       else
                       {
                           text[i]='\'';
                           System.out.print('\'');
                           first = true;
                       }
                       
                       
                   }
                  System.out.print(text[i]);
                   
                   
               }
               
               /*for(int i=0;i<text.length;i++)
               {
                   if(text[i]=='\'')System.out.print(text[i]);
                   if(text[i]=='`')System.out.print(text[i]);
                   System.out.print(text[i]);
               }*/
               System.out.println();
                
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
