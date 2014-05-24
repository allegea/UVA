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
public class ThePlayboyChimp2 {

    static int BSPrev(int[] values, int x, int n)
    {
        int l = 0;
        int r = n-1;
        int pos = -1;
        while( r >= l)
        {
            int mid = (l+r)/2;
            //System.out.println("P "+l+" - "+mid+" - "+r+" | "+values[mid]+" - "+pos);
            if(values[mid] >= x)r = mid-1;
            else {
                l = mid+1;
                pos = mid;
            }
        }
        return pos;
    }
    
     static int BSNext(int[] values, int x, int n)
    {
        int l = 0;
        int r = n-1;
        int pos = -1;
        while( r >= l)
        {
            int mid = (l+r)/2;
            //System.out.println("N "+l+" - "+mid+" - "+r+" | "+values[mid]+" - "+pos);
            if(values[mid] <= x)l = mid+1;
            else {
                r = mid-1;
                pos = mid;
            }
        }
        return pos;
    }
   public static void main(String[] args) throws IOException{
       
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         int n = Integer.parseInt(in.readLine());
         int[] values = new int[n];
         StringTokenizer r = new StringTokenizer(in.readLine());
         StringBuilder out = new StringBuilder();
         for(int i=0;i<n;i++)
             values[i] = Integer.parseInt(r.nextToken());
         
         int m = Integer.parseInt(in.readLine());
         r = new StringTokenizer(in.readLine());
         for(int i=0;i<m;i++)
         {
            int q = Integer.parseInt(r.nextToken());
            //System.out.println(q+" - "+BSPrev(values, q, n));
            if(q < values[0])out.append("X ").append(values[0]).append("\n");
            else if(q > values[n-1])out.append(values[n-1]).append(" X").append("\n");
            else{
                int a = BSPrev(values, q, n);
                String prev = (a == -1?"X":""+values[a]);
                int b = BSNext(values, q, n);
               // System.out.println(a+" - "+b);
                String next = (b == -1?"X":""+values[b]);
                 out.append(prev).append(" ").append(next).append("\n");
                /*int bs = Arrays.binarySearch(values, q);
                if(bs < 0)
                {   
                    bs++;
                    bs*=-1;
                    out.append(values[bs-1]).append(" ").append(values[bs]).append("\n");
                }else{
                    int a, b ;
                    a = b = bs;
                    while(a >= 0 && values[a] == values[bs])a--;
                    while(b < n && values[b] == values[bs])b++;
                    String prev = (a < 0?"X":""+values[a]);
                    String next = (b == n?"X":""+values[b]);
                    out.append(prev).append(" ").append(next).append("\n");
                }*/
            }
         }
         System.out.print(out);
         in.close();
         System.exit(0);
     }
}
