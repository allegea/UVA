/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * http://uva.onlinejudge.org/external/117/11787.html
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class NumeralHieroglyphs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        char[] symbols = new char[]{'B','U','S','P','F','T','M'};
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
          
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                
                int[] numbers = new int[7];
                char[] x = in.readLine().toCharArray();
                
                
                boolean err=false;
                int posI = 0;
                int posJ=0;
                boolean up = false;
                boolean found = false;
                
                for(int i=0;i<x.length;i++){

                    for(int j=0;j<7;j++)
                        if(x[i]==symbols[j]){
                            numbers[j]+=1;
                            if(numbers[j]>9){
                                err=true;
                                i=x.length;
                            
                            }
                            if(i!=0){
                            posI=posJ;
                            posJ=j;}
                            else
                            {posJ=j;
                                posI=posJ;
                            
                            }
                            if (!found) {
                                if (posI < posJ) {
                                    found = true;
                                    //System.out.println(i+" - "+j+" <");
                                    up = true;
                                } else if (posI > posJ) {
                                    found = true;
                                    //System.out.println(i+" - "+j+" >");
                                }

                            }else
                            {
                                if(up && posI > posJ){
                                   // System.out.println(i+" - "+j);
                                    err=true;
                                    i=x.length;
                                }
                                if(!up && posI <posJ){
                                    err=true;
                                    i=x.length;
                                }
                            }
                            
                            
                                break;
                        }
                }
                
                if(err)System.out.println("error");
                else{
                int sum=0;
                int ten = 1;
                for(int i=0;i<7;i++)
                {    sum+=numbers[i]*ten;
                    ten*=10;
                        
                }
                System.out.println(sum);
                }
                
                
            }

           
        in.close();
        System.exit(0);
        
    }
}
