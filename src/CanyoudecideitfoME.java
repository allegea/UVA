/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

fdfs

/**
 *
 * @author allegea
 */
public class CanyoudecideitfoME {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           StringBuilder out = new StringBuilder();
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
            
                char[] axiom = in.readLine().toCharArray();
                //System.out.println(axiom);
                int posM=-1;
                int posE=-1;
                boolean teor = true;
                for(int i=0;i<axiom.length;i++){
                    if(axiom[i]!='?')
                    {
                        if(axiom[i]=='M'){
                            posM=i;
                            break;
                        }else {
                            teor=false;
                            break;
                        }
                    }
                }
                
                if(!teor){
                    System.out.println("no-theorem");
                    continue;
                }
                
                if(posM<=0){
                    System.out.println("no-theorem");
                    continue;
                }
                
                for(int i=posM+1;i<axiom.length;i++){
                    if(axiom[i]!='?')
                    {
                        if(axiom[i]=='E'){
                            posE=i;
                            break;
                        }else {
                            teor=false;
                            
                            break;
                        }
                    }
                }
                
                if(!teor){
                    System.out.println("no-theorem");
                    continue;
                }
                
                if(posE-posM<2){
                    System.out.println("no-theorem");
                    continue;
                }
                
                for(int i=posE+1;i<axiom.length;i++){
                    if(axiom[i]!='?')
                    {//System.out.println(axiom[i]+"--");
                        teor=false;
                            break;
                            
                    }
                }
                
                if(!teor){
                    System.out.println("no-theorem");
                    
                }else System.out.println("theorem");
                        
                
                
            }

            
        in.close();
        System.exit(0);
        
    }
}
