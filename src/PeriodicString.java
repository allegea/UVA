/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class PeriodicString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         

           String line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
           in.readLine();
            while (act++<cases) 
            {
               
              
                    
                        
               
               line = in.readLine();
               if(line.length()==0) {
                   act--;
                   continue;
               }
               if(line.length()==1){
                   System.out.println(1);
                   
               }else{
               int i;
               for(i=1;i<=line.length();i++){
                   if(line.length()%i!=0)continue;
                   
                   boolean answer = true;
                   String aux = line.substring(0, i);
                  for(int j=i;j<line.length() && answer;j+=i)
                      if(!aux.equals(line.substring(j, j+i)))
                          answer=false;
                  
                  if(answer)
                  {
                      System.out.println(i);
                      break;
                  }
                   
               }
               }
              /* if(i==line.length())
                   System.out.println(i);*/
                System.out.println();
                
            }

            
        in.close();
        System.exit(0);
        
    }
}
