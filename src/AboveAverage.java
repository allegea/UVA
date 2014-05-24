/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.text.DecimalFormat;
import java.util.Locale;



/**
 *
 * @author allegea
 */
public class AboveAverage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        Locale.setDefault(Locale.ENGLISH);
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         DecimalFormat salida = new DecimalFormat("0.000");
         
           String line;
  
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                String[] dates = in.readLine().split("[ ]");
               int amount=Integer.parseInt(dates[0]);
               int[] datos = new int[amount];
               float average = 0;
               for(int i=0;i<amount;i++)
               {
                   datos[i]=Integer.parseInt(dates[i+1]);
                   average+=datos[i];
               }

               int count=0;
               for(int i=0;i<amount;i++)
               {
                   if(datos[i]*amount>average)count++;
                   
               }
               double otro = ((double)count*100)/(double)amount;
               System.out.println(salida.format(otro)+"%");
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
