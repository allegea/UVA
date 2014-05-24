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
public class ShoemakersProblem {

    public static class Job implements Comparable<Job>{
 
    int a, b, p;
    float value;
    Job(int aa, int bb, int pp)
    {
        a = aa;
        b = bb;
        p = pp;
        value = a /(float)b; 
    }
    @Override
    public int compareTo(Job o)
    {
        if(this.value != o.value) return Float.compare(this.value, o.value);
        else return this.p - o.p;
    }
}
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int cases = Integer.parseInt(in.readLine());
         boolean noFirst = false;
         Job[] input;
         StringTokenizer st;
         while(cases -- > 0)
         {
             if(noFirst)System.out.println();
             noFirst = true;
             in.readLine();
             int N = Integer.parseInt(in.readLine());
             input = new Job[N];
             for(int i = 0; i < N; i ++)
             {
                 st  = new StringTokenizer(in.readLine());
                 int u = Integer.parseInt(st.nextToken());
                 int v = Integer.parseInt(st.nextToken());
                 input[i] = new Job(u, v, i + 1);
             }
             
             Arrays.sort(input);
             String answer = "";
             for(int i = 0; i < N; i++)
                 answer+= input[i].p + " ";
             System.out.println(answer.trim());
             
         }
         in.close();
         System.exit(0);
     }
}
