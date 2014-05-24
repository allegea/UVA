/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;


import java.util.*;

/**
 *
 * @author allegea
 */
public class PowerCrisis {

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
            while (true) 
            {
               int n = Integer.parseInt(in.readLine());
               if(n==0)break;
               if(n==13)
               {
                   System.out.println(1);
                   continue;
               }
                 ArrayList<Integer> numbers = new ArrayList<Integer>();
                 for(int i=1;i<=n;i++)
                     numbers.add(i);

                 ArrayList<Integer> aux = new ArrayList<Integer>(numbers);
                // System.out.println(aux);
                 int jump=2;
                 int s = 0;
                 while(true)
                 {
                     
                 
                     while(aux.size()!=1)
                     {
                         //System.out.println(aux.get(s)+" "+s);
                         if(aux.get(s)==13)break;
                         aux.remove(s);
                         //System.out.println(aux);
                         if(jump>aux.size())
                         {
                             s=(jump+s-1)%aux.size();
                             continue;
                         }
                         if((s+jump)>aux.size())s=(s+jump)-(aux.size()+1);
                         
                         else s+=jump-1;


                     }
                     if(aux.get(0)==13&&aux.size()==1)
                     {
                         System.out.println(jump);
                         break;
                     }
                     aux = new ArrayList<Integer>(numbers);
                     jump++;
                     s=0;
                     //System.out.println("Salto "+jump);
                 }
                 
                 
                
            }

        in.close();
        System.exit(0);
        
    }
}
