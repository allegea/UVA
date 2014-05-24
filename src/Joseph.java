/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class Joseph {

        static int[] answers = new int[27];
        static int simulate(int x)
        {
            int y = x;
            x*=2;
            ArrayList<Integer> numbers;
            int m = 1;
            while(true)
            {
                numbers = new ArrayList<Integer>();
                for(int i=1;i<=x;i++)numbers.add(i);

                int pos = 0;
                int curr = m;
                int size = x;
                boolean found = true;
                while(size > y)
                {
                    pos += (curr)-1;
                    pos%= size--;
                    if(  numbers.remove(pos) <= y)
                    {
                        found = false;
                        break;
                    }
                }
                //System.out.println(" ---- "+m);
                if(found)
                    break;
                m++;
                
            }
           // System.out.println(y+" - "+m);
           return m;
        }
	public static void main(String[] args) throws IOException{
		
                for(int i=1;i<14;i++)
                    answers[i] = simulate(i);
		
		Scanner in = new Scanner(System.in);
		
                while(true)
                {
                    int num = in.nextInt();
                    if(num == 0)break;
                    System.out.println(answers[num]);
                }

		in.close();
		System.exit(0);
	}
}