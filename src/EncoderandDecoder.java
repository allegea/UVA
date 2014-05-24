/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;



/**
 *
 * @author allegea
 */
public class EncoderandDecoder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        aa
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           //System.out.println((char)(122));
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
                StringBuilder out = new StringBuilder();
               char[] ms = line.toCharArray();
               int aux=0;
               StringBuilder reve;
                if (Character.isDigit(ms[0])) {
                     for (int i = line.length() - 1; i >= 0; i-=2){
                         if(ms[i]=='1')
                         {
                             char con = (char)((ms[i]-48)*100+(ms[i-1]-48)*10+(ms[i-2]-48));
                            // System.out.println(con);
                             i--;
                             out.append(con);
                         }
                         else
                         {
                             char con = (char)((ms[i]-48)*10+(ms[i-1]-48));
                             //System.out.println(con);
                             out.append(con);
                         }
                     }
                    
                } else {
                    for (int i = line.length() - 1; i >= 0; i--) {
                        aux = ms[i];
                        reve = new StringBuilder(Integer.toString(aux));
                        //System.out.println(reve);
                        out.append(reve.reverse());

                    }
                    
                }
                System.out.println(out);
               
            }

            
            
        in.close();
        System.exit(0);
        
    }
}
