/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class TheArcheologistsDilemma {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
         int[] sizes = new int[32];
         String[] powers = new String[31];
         for(int i=0;i<31;i++)
         {
             powers[i] = String.valueOf(1<<i);
             sizes[i]=powers[i].length();
             if(sizes[i]%2==0){
                 sizes[i]=sizes[i]/2-1;
             }else sizes[i]=sizes[i]/2;
            // System.out.println(powers[i]+" - "+sizes[i]);
         }
        
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
                //boolean found = false;
                int answer=-1;
                for(int i=0;i<31 && answer==-1;i++)
                {
                    if(line.length()<=sizes[i])
                    {
                        if(powers[i].startsWith(line))
                        {
                            answer=i;
                        }
                    }
                }
                
                if(answer==-1)
                    System.out.println("no power of 2");
                else System.out.println(answer);
  
                
            }

        in.close();
        System.exit(0);
        
    }
}
