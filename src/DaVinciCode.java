/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;



/**
 *
 * @author allegea
 */
public class DaVinciCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        
        
         int lim = (1<<31)-1;
         long fi1,fi2,fi;
         int count;
         fi1=1;
         fi2=2;
         HashMap<Long,Integer> fibo = new HashMap<Long,Integer>();
         fibo.put(fi1, 1);
         fibo.put(fi2, 2);
         count=3;
         fi=fi1+fi2;
         while(fi<=lim){
             fibo.put(fi, count);
             fi1=fi2;
             fi2=fi;
             fi=fi2+fi1;
             count++;
             // System.out.println(fi);
         }
         //System.out.println(fibo.get(89l));
        // BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
           String line;
           
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
               int num = Integer.parseInt(in.readLine());
               String[] fibon = in.readLine().split("[ ]");
               char[] letters = in.readLine().toCharArray();
               char[] mess = new char[101];
               Arrays.fill(mess, ' ');
               int j=0;
                for (int i = 0; i < num&&j<letters.length; i++) {
                    if (fibo.get(Long.parseLong(fibon[i])) != null) {
                        if (Character.isUpperCase(letters[j])) {
                            // System.out.println(fibo.get(Long.parseLong(fibon[j])));

                            mess[fibo.get(Long.parseLong(fibon[i])) - 1] = letters[j];
                            

                        }else i--;
                        j++;
                    }

                }
              
                boolean first = false;
                String answer = "";
              for(int i=100;i>=0;i--){
                  if(!first){
                  if(Character.isUpperCase(mess[i])){
                      first=true;
                      answer=mess[i]+answer;
                  }
                  }
                  else answer=mess[i]+answer;
              }
                  System.out.println(answer);
                
            }

            
        in.close();
        System.exit(0);
        
    }
}
