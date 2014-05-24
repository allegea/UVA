


import java.io.*;
import java.util.*;

public class CountingOnes {

    public static long Counting(long X)
    {
        long curr = 2;
        long answer = (X + 1) / 2;
        while(true)
        {
            
            long div = X / curr;
            if(div == 0)break;
            long count = (div) / 2;
            answer+= count * curr;
            if(div % 2 != 0)
            {
                long inf = div * curr;
                answer+= (X - inf) + 1;
            }
            curr*=2;
        }
        return answer;
    }
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         String line = "";
         StringBuilder out = new StringBuilder();
         long A, B;
         while((line = in.readLine()) != null && line.length() > 0)
         {
             st = new StringTokenizer(line);
             A = Long.parseLong(st.nextToken());
             B = Long.parseLong(st.nextToken());
             out.append(Counting(B) - Counting(A - 1)).append("\n");
             //System.out.println(Counting(B) - Counting(A - 1));
         }
         System.out.print(out);
         in.close();
         System.exit(0);
     }
}
