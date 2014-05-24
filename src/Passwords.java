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
public class Passwords {

    private static String[] words;
    private static char[] rules;
    private static int lenRules;
    
    private static void permute(StringBuilder answer, int size)
    {
        if(size == lenRules)
            System.out.println(answer);
        else
        {
            StringBuilder aux ;
            if(rules[size]=='0')
            {
                for(int i = 0; i<10; i++)
                {
                    aux = new StringBuilder(answer);
                    aux.append(String.valueOf(i));
                    permute(aux, size + 1);
                    
                }
                
            }else
            {
                for(int i = 0; i<words.length; i++)
                {
                    aux = new StringBuilder(answer);
                    aux.append(words[i]);
                    permute(aux, size + 1);
                    
                }
            }
        }
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
               int n= Integer.parseInt(line);
               words = new String[n];
               for(int i = 0;i<n;i++)
               words[i] = in.readLine();
               
               int m = Integer.parseInt(in.readLine());
               
               System.out.println("--");
               for(int i = 0;i<m;i++)
               {
                   rules = in.readLine().toCharArray();
                   lenRules = rules.length;
                   permute(new StringBuilder(), 0);
                   
               }
                
            }

        in.close();
        System.exit(0);
        
    }
}
