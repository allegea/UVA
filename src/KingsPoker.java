/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class KingsPoker {

    static HashMap<String, String> pre = new HashMap<String, String>();
   public static void main(String[] args) throws IOException{
       
       for(int i=1;i<13;i++)
       {    pre.put(i+" "+i+" "+i, (i+1)+" "+(i+1)+" "+(i+1));
           for(int j=i+1;j<14;j++)
               for(int h=j+1;h<14;h++)
                   pre.put(i+" "+j+" "+h, "1 1 2");
       }           
       pre.put("13 13 13", "*");
       
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         int a, b, c;
         int[] sort;
         StringTokenizer r;
         while(true)
         {
             r = new StringTokenizer(in.readLine());
             a = Integer.parseInt(r.nextToken());
             b = Integer.parseInt(r.nextToken());
             c = Integer.parseInt(r.nextToken());
             if(a == 0 && b == 0 && c == 0)break;
             sort = new int[]{a, b, c};
             Arrays.sort(sort);
             if(pre.containsKey(sort[0]+" "+sort[1]+" "+sort[2]))
                 System.out.println(pre.get(sort[0]+" "+sort[1]+" "+sort[2]));
             else{
                 if(sort[0] == sort[1]){
                     a = sort[0];
                     b = sort[2];
                 } else if(sort[2] == sort[1])
                 {
                     a = sort[1];
                     b = sort[0];
                 }else{
                     a = sort[0];
                     b = sort[1];
                 }
                 
                 b++;
                 if(b == a)b++;
                 if(b>13){
                     a++;
                     b = 1;
                 }
                 if(a>13){
                     a = 1;
                     b = 1;
                 }
                 
                 sort = new int[]{a, a, b};
                Arrays.sort(sort);
                 System.out.println((sort[0]+" "+sort[1]+" "+sort[2]));
                
                 
             }
         }
         in.close();
         System.exit(0);
     }
}
