/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.BitSet;



/**
 *
 * @author allegea
 */
public class PrimeFrequency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         BitSet primos = new BitSet();
         primos.set(0);
         primos.set(1);
         
         for(int i=2;i*i<=2000;i++)
             if(!primos.get(i))
                 for(int j=2*i;j<=2000;j+=i)
                     primos.set(j);
         
         /*for(int i=0;i<=2000;i++)
             if(!primos.get(i))System.out.println(i);
         */
           String line;
           
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
               StringBuilder out = new StringBuilder();
                int[] numbers = new int[10];
                int[] LettMa = new int[26];
                int[] LettMi = new int[26];

                char[] linea = in.readLine().toCharArray();
                for (int i = 0; i < linea.length; i++) {
                    if (Character.isDigit(linea[i])) {
                        numbers[linea[i]-48]++;
                        continue;
                    }
                    if (Character.isLetter(linea[i])) {
                        if (Character.isLowerCase(linea[i])) 
                            LettMi[linea[i]-97]++;
                         else LettMa[linea[i]-65]++;



                    }

                       //System.out.println(linea[i]);
                }
                
                

                    out.append("Case ").append(act).append(": ");
                    
                    int total=0;
                    for(int i=0;i<10;i++)
                      if(!primos.get(numbers[i])){out.append(i);
                        total++;
                    }
                    
                    for(int i=0;i<26;i++)
                      if(!primos.get(LettMa[i])){out.append((char)(65+i));
                        total++;
                    }
                    
                    for(int i=0;i<26;i++)
                       if(!primos.get(LettMi[i])){out.append((char)(97+i));
                        total++;
                    }
                    
                    if(total==0) out.append("empty");
                    System.out.println(out);
                
                
            }
            
        in.close();
        System.exit(0);
        
    }
    
}
