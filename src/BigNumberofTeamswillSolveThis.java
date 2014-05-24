/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class BigNumberofTeamswillSolveThis {

 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
       // BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
               String answer = in.readLine();
               String right = in.readLine();
               if(right.equals(answer))
                   System.out.println("Case "+act+": Yes");
               else{
                   String aux = answer.replace(" ","");
                   if(right.equals(aux))
                       System.out.println("Case "+act+": Output Format Error");
                   else System.out.println("Case "+act+": Wrong Answer");
                   
               }
                
                
            }

            
        in.close();
        System.exit(0);
        
    }
}
