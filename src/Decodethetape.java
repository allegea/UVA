/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *http://acm.uva.es/p/v108/10878.html
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class Decodethetape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (in.ready()) 
            {
               
                char[] lecture = in.readLine().toCharArray();
                if(lecture.length==0)continue;
               if(lecture[0]!='|')continue;
               int bin = 0;
               boolean dot = false;
               for(int i=2;i<lecture.length-1;i++){
                  
                   if(lecture[i]=='.'){
                       dot=true;
                       continue;
                   }  
                    if(lecture[i]=='o'){
                        if(dot)
                            bin+=1<<(lecture.length-2-i);
                        else
                            bin+=1<<(lecture.length-3-i);
                    }
               }
               System.out.print((char)bin);
                   
                
            }

           
        in.close();
        System.exit(0);
        
    }
}
