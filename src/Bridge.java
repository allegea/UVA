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
public class Bridge {

  
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int cases = Integer.parseInt(in.readLine());
         boolean noFirst = false;
         StringTokenizer st;
         int[] values, mins;
         while(cases -- > 0)
         {
             if(noFirst)System.out.println();
             noFirst = true;
             in.readLine();
             int N = Integer.parseInt(in.readLine());
             values = new int[N];
             mins = new int[2];
             for(int i = 0; i < N; i ++)
                values[i] = Integer.parseInt(in.readLine());
             
             Arrays.sort(values);
             if(N == 1)System.out.println(values[0] +"\n" + values[0]);
             else{
                 int i = 0;
                 int front, end = 0;
                 front = 2;
                 mins[i] = values[i++];
                 mins[i] = values[i++];
                 //N-= 2;
                 String steps = "";
                 long sum = 0;
                 int turn = 0;
                 i = N - 1;
                 while(N > 0)
                 {
                     if(turn == 0)
                     {
                         int a = 0, b = 0;
                         if(front == 2)
                         {
                             a = mins[0];
                             b = mins[1];
                             end = 2;
                            front = 0;
                         }else{
                             if(i == 2)
                             {
                              a = mins[0];
                              b = values[i];   
                             }else{
                             a = values[i - 1];
                             b = values[i];
                             }
                             i-=2;
                         }
                         steps+=a+" "+b+"\n";
                         N-=2;
                         sum+=b;
                     }else{
                         int a = 0;
                         if(end == 2)
                         {
                             a = mins[0];
                             front = end = 1;
                         }else{
                             a = mins[1];
                             front = 2;
                             end = 0;
                         }
                         steps+=a + "\n";
                         N++;
                         sum+=a;
                     }
                    // System.out.println(N + " - " + sum + " - " + turn + " - " + front + " - " + end + " - " +i);
                     turn = 1 - turn;
                 }
                 System.out.println(sum);
                 System.out.print(steps);
             }
             
             
         }
         in.close();
         System.exit(0);
     }
}
