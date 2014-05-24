/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class WordLengthandFrequency {
gffgdfg
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (in.ready()) 
            {
               int[] fre = new int[2500];
                int n=0;
               while(!"#".equals((line = in.readLine()))){
                  //System.err.println(line);
                   char[] read = line.toCharArray();
                  
                   for(int i=0;i<read.length-1;i++){
                       if(read[i]==' '||read[i]=='?'||read[i]=='!'||read[i]==','||read[i]=='.'){
                            fre[n]++;
                               n=0;
                       }else{
                           if(read[i]!='\'' && read[i]!='-')
                           {
                               n++;
                           }    
                       }
                       //System.err.println(read[i]+" - "+n);

                   }
                   

                           if(Character.isLetterOrDigit(read[read.length-1]))
                           {
                               fre[++n]++;
                               n=0;
                           }
                           if(read[read.length-1]!='\''&&read[read.length-1]!='-'){
                               fre[n]++;
                               n=0;
                           }    
                       
                   
               }
               
               for(int i=1;i<2500;i++)
                   if(fre[i]!=0)
                       System.out.println(i+" "+fre[i]);
               
               System.out.println();
               
               
                
                
            }

            
        in.close();
        System.exit(0);
        
    }
}
