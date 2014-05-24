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

public class EenyMeenyMoo {

        static int[] answers = new int[151];
        static int simulate(int x)
        {
            
            ArrayList<Integer> numbers;
            int m = 1;
            while(true)
            {
                numbers = new ArrayList<Integer>();
                for(int i=2;i<=x;i++)numbers.add(i);

                int pos = 0;
                int curr = m;
                int size = x-1;
                boolean found = true;
                while(size > 1)
                {
                    pos += (curr)-1;
                    pos%= size--;
                    //System.out.println(numbers.get(pos));
                    if(  numbers.remove(pos) == 2)
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
            //System.out.println(x+" - "+m);
           return m;
        }
	public static void main(String[] args) throws IOException{
		
                for(int i=1;i<150;i++)
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