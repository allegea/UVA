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
public class Football {
    


   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String line = "";
         StringTokenizer st;
         StringBuilder out = new StringBuilder();
         while((line = in.readLine()) != null && line.length() > 0)
         {
         //Scanner in = new Scanner(System.in);
            // int N = in.nextInt();
            //int Budg = in.nextInt();
            
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int Budg = Integer.parseInt(st.nextToken());
            
            int[] data = new int[N];
            for(int i = 0; i < N; i++)
            {
                st = new StringTokenizer(in.readLine());
                //int a = in.nextInt();
                //int b = in.nextInt();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                data[i] = a - b;
            }
            Arrays.sort(data);
            int answer = 0;
            for(int i = N - 1; i >= 0 ; i--)
            {
               // if(data[i].diff < 0 && Budg < -data[i].diff)break;
                
                if(data[i]> 0)answer+=3;
                else if(data[i] == 0)
                {
                    answer++;
                    if(Budg > 0)
                    {
                        answer+=2;
                        Budg--;
                    }
                }else 
                    if( -data[i] <= Budg )
                    {
                        answer++;
                        Budg+=(data[i]);
                        if(Budg > 0)
                        {
                            answer+=2;
                            Budg--;
                        }
                    }else break;

            }
            out.append(answer).append("\n");
            //System.out.println(answer);
         }
         System.out.print(out);
         in.close();
         System.exit(0);
     }
}
