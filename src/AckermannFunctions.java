/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.HashMap;



/**
 *
 * @author allegea
 */
public class AckermannFunctions {

    static HashMap<Long,Long> map;
    
    public static long answer(long x){
        
        if(map.containsKey(x)){
            //System.out.println("contains "+x);
            return map.get(x);
        }else{ 
            long xA = x;
            if((x&1)!=1)x>>=1;
            else x=(x<<1)+x+1;
           // System.out.println(xA);
            long count=answer(x)+1;
            map.put(xA, count);
            return count;
            
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         for(int i=1;i<=32;i++){
             System.out.println(i+" - "+(i&(i-1)));
         }
           String line;
           map = new HashMap<Long,Long>();
              map.put(1l, 0l);

            while ((line=in.readLine())!=null) 
            {
              String[] read = line.split("[ ]+");
              int l = Integer.parseInt(read[0]);
              int r = Integer.parseInt(read[1]);
              if(l==0 && r==0)break;
              
              if(r<l){
                  int aux = r;
                  r=l;
                  l=aux;
              }
              long max=0;
              long number=-1;
              long orL=l;
              if(l<=1){
                  max=3;
                  number=1;
                  l=2;
              }
              for(int i=l;i<=r;i++){
                  
                  long partial = answer(i);
                  //System.out.println(partial+"--"+i+"\n_____");
                  if(partial>max){
                      max=partial;
                      number=i;
                  }
                  
              }
              
             // System.out.println(map);
              
              System.out.println("Between "+orL+" and "+r+", "+number+" generates the longest sequence of "+max+" values.");
              
            }

            //System.out.print(out.toString());
        in.close();
        System.exit(0);
        
    }
}
