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
public class TeamWork {
 RTE
    public static int ANSWER, MAX, N;
    public static boolean[] used;
    public static int[] numbers;
    
    public static void BT(int pos, int bitmap, int sum, int curr, int count, int currMax)
    {
        if(sum > currMax || pos == N)return;
        if(count >= 2)
        {
            if(curr > 0)
            {
                if(sum == currMax)
                {
                    if(curr == 2)
                    {
                        ANSWER = Math.max(ANSWER, sum);
                        return;
                    }else{
                        BT(0, 0, 0, curr + 1, 0, sum);
                        return;
                    }
                }
            }else  BT(0, 0, 0, curr + 1, 0, sum);
        }
        
        for(int i = pos; i < N; i++)
        {
            if(used[i])continue;
            int bit = (bitmap & (1 << numbers[i]));
            if(bit == 0)
            {
                used[i] = true;
                bitmap|= (1 << numbers[i]);
                BT(pos + 1, bitmap, sum + numbers[i], curr, count + 1, currMax);
                bitmap^= (1 << numbers[i]);
                used[i] = false;
            }
        }
    }
    
   public static void main(String[] args) throws IOException{
       // String file = "teamwork";  
       // System.setIn(new FileInputStream(file + ".in"));
        //System.setOut(new PrintStream(new FileOutputStream(file + ".out")));
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
         String file = "teamwork";  
         BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        //System.setIn(new FileInputStream(file+".txt"));
       // System.setOut(new PrintStream(new FileOutputStream("output.txt")));
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         in = new BufferedReader(new InputStreamReader(new FileInputStream("teamwork.in")));
         out = new PrintWriter(new FileOutputStream("teamwork.out"));
        // Scanner in = new Scanner(System.in);
         StringTokenizer st;
         int curr = 1;

         while(true)
         {
             st = new StringTokenizer(in.readLine());
             N = Integer.parseInt(st.nextToken());
             //N = in.nextInt();
             MAX = 0;
             ANSWER = 0;
             if(N == 0)break;
             numbers = new int[N];
             used = new boolean[N];
             for(int i = 0; i < N; i++)
             {
                 numbers[i] = Integer.parseInt(st.nextToken());
                 //numbers[i] = in.nextInt();
                 MAX+= numbers[i];
             }
             MAX/=3;
             BT(0, 0, 0, 0, 0, MAX);
             out.println("Case " + curr + ": " + ANSWER);
             curr++;
             
         }
         

         in.close();
         out.close();
         System.exit(0);
     }
}
