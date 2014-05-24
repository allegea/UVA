/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uva.projectEuler;
import java.io.*;
import java.util.StringTokenizer;



/**
 *
 * @author allegea
 */
public class P9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
         //BufferedReader in   = new BufferedReader(new FileReader("triangulo.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           
       for(int i=1;i<=1000;i++){
           for(int j=i+1;j<=1000;j++){
               /*for(int h=j+1;h<=100;h++)
                   if(i+j+h==100)System.out.println(i+" "+j+" "+h);*/
               double aux = Math.sqrt(i*i+j*j);
               int c=(int)aux;
               
               if(c==aux){
                   //System.out.println(i+" + "+j+" + "+c+" = "+(i+j+c));
                   if(i+j+c==1000)System.out.println(i+" "+j+" "+c+" - "+(i*j*c));
               }
           }
       }
       
  
           
                
            

        
    }
}
