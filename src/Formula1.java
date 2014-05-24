/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;



/**
 *
 * @author allegea
 */
public class Formula1 {
   public static class pilot implements Comparable{
        
        long time;
        int i;
        
        pilot(long t,int j){
            this.time = t;
            this.i=j;
        }
        

        @Override
        public int compareTo(Object o) {
            return Double.compare(this.time,((pilot)o).time);
        }
        
        
    }
   
   public static class pnames implements Comparable{
        
        String nameL;
        
        pnames(String l){
            this.nameL = l;  
        }
        

        @Override
        public int compareTo(Object o) {
            return this.nameL.compareToIgnoreCase(((pnames)o).nameL);
        }
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           long[] mul= new long[3];
           mul[0] = 60*1000;
           mul[1] = 1000;
           mul[2] = 1;
           //int cases=0;
           String line = "";
            //while (in.ready()) 
           while( (line = in.readLine())!=null)
            {
            
                //if(cases++>0)
                    
               int n= Integer.parseInt(line);
               String[] names = new String[n];
               pilot[] pilots = new pilot[n];
               pilot aux2;
               for(int i=0;i<n;i++){
                   StringTokenizer aux = new StringTokenizer(in.readLine());
                   names[i] = aux.nextToken();
                   long time =0;
                   int count = 0;
                   while(aux.hasMoreTokens()){
                       String toke = aux.nextToken();
                       
                       if(Character.isDigit(toke.charAt(0))){
                           time+=Integer.parseInt(toke)*mul[count++];
                          // System.out.print(Integer.parseInt(toke)*mul[count-1]+" - ");
                       }
                       
                   }
                  // System.out.println();
                   aux2 = new pilot(time,i);
                   pilots[i]=aux2;
                   
               }
               
               Arrays.sort(pilots);
               pnames auxN;
               int round=0;
               int prin = 1;
               for(int i=0;i<n;i++)
               {
                   ArrayList<pnames> names2 = new ArrayList<pnames>();
                   auxN = new pnames(names[pilots[i].i]);
                   names2.add(auxN);
                   
                   while(i+1<n && pilots[i].time==pilots[i+1].time)
                   {
                       auxN = new pnames(names[pilots[i+1].i]);
                       names2.add(auxN);
                       i++;
                   }
                   
                   if(names2.size()>1)
                       Collections.sort(names2);
                   
                   
                   for(int j=0;j<names2.size();j++)
                   {
                       if(round++%2==0)
                           System.out.println("Row "+prin++);
                       System.out.println(names2.get(j).nameL);
                   }
                   i+=names2.size()-1;
                   
               }
               in.readLine();
               
               System.out.println();
                
            }

       
        in.close();
        System.exit(0);
        
    }
}
