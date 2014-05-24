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
public class SimpleSubSet {

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
            while ((line = in.readLine()) != null) 
            {
               String[] un = line.split("[ ]");
               int[] set1 = new int[un.length];
               for(int i=0;i<un.length;i++)
                   set1[i]=Integer.parseInt(un[i]);
               
               un = in.readLine().split("[ ]");
               int[] set2 = new int[un.length];
               for(int i=0;i<un.length;i++)
                   set2[i]=Integer.parseInt(un[i]);
               
               Arrays.sort(set1);
               Arrays.sort(set2);
               
               int count=0;
               boolean a=true;
               int min=-1;
               if(set1.length<set2.length)
                   min=set1.length;
               else
               {
                   min=set2.length;
                   a=false;
               }
               
               if(set1.length<set2.length)
               {
                   for(int i=0;i<set1.length;i++)
                       if(Arrays.binarySearch(set2, set1[i])>=0)
                           count++;
                   
               }
               else
               {
                   for(int i=0;i<set2.length;i++)
                       if(Arrays.binarySearch(set1, set2[i])>=0)
                           count++;
                   
               }
               String answer;
               if(count==min)
               {
                   if(set1.length==set2.length)answer="A equals B";
                   else { if(a)answer="A is a proper subset of B";
                   else answer="B is a proper subset of A";
                   }
               }
               else if(count==0) answer="A and B are disjoint";
               else answer="I'm confused!";
               
               
                System.out.println(answer);
            }

            
        in.close();
        System.exit(0);
        
    }
}
