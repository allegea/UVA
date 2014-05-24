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
public class DroppingBalls{
	
	public static long solve(int d, int i)
	{
		int curr = 1<<(d - 1);
                 i%=curr;
                i--;
                int bitCount = Integer.bitCount(i);
                int pos = 1<<(d - 2);
                int ori = 1;
              // System.out.println(i + " * "+Integer.toBinaryString(i) + " - " +bitCount);
                
                while(bitCount > 0)
                {
                    if( (i & ori) != 0)
                    {
                        curr^=pos;
                        bitCount--;
                    }
                   /* System.out.println(i + " - "+Integer.toBinaryString(curr));
                    System.out.println(i + " * "+Integer.toBinaryString(i));
                    System.out.println(i + " O "+Integer.toBinaryString(ori));
                    System.out.println(i + " P "+Integer.toBinaryString(pos));*/
                    pos>>=1;
                    ori<<=1;
                    
                }
                
              //  i%=curr;
		
		return curr;
	}
        
        public static int solve2(int d, int i)
	{
		int curr = 1<<(d - 1);
                
                i%=curr;
		int prev = curr;
		while(i-- > 0)
		{
			int p = d - 2;
			prev = curr;
			while(true)
			{
				if(p < 0)break;
				int value = (curr & (1<<p));
				curr^=1<<p;
                               // System.out.println(p + " - "+(1<<p)+" - "+curr);
				if(value == 0)break;
				p--;
			}
                        System.out.println(i + " - "+Integer.toBinaryString(prev));
                        System.out.println(i + " * "+Integer.toBinaryString(curr));
		}
		return prev;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st;
		while(n-- > 0)
		{
			st = new StringTokenizer(in.readLine());
			int d = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			System.out.println(solve(d, i));
		}
	
	}
} 