/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alejandro E. Garces
 */

public class TilingUpBlocks{
	
	static class Block implements Comparable {
	
		int l;
		int m;
		Block(int ll, int mm)
		{
			l = ll;
			m = mm;
		}
		@Override
		public int compareTo(Object o)
		{
			if(this.l != ((Block)o).l) return this.l - ((Block)o).l;
			return this.m - ((Block)o).m;
		}
		@Override
		public String toString()
		{
			return l+" - "+m;
		}
	}
	
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                Scanner in = new Scanner(System.in);
		Block[] b;
		String[] read;
		long[] states;
		long answer;
		while(true)
		{
			//int n = Integer.parseInt(in.readLine());
                        int n = in.nextInt();
			if(n == 0)break;
			b = new Block[n];
			states = new long[n];
			answer = 0;
			for(int i=0;i<n;i++)
			{
				//read = in.readLine().split("[ ]+");
				//int l = Integer.parseInt(read[0]);
				//int m = Integer.parseInt(read[1]);
                                int l = in.nextInt();
				int m = in.nextInt();
				b[i] = new Block(l, m);
			}
			
			Arrays.sort(b);
			for(int i=0;i<n;i++)
			{
				long max = 0;
				for(int j=0;j<i;j++)
					if(b[i].l >= b[j].l && b[i].m >= b[j].m)
					max = Math.max(max, states[j]);
				states[i] = max + 1;
				answer = Math.max(answer, states[i]);
			}
			/*System.out.println(Arrays.toString(b));
			System.out.println(Arrays.toString(states));*/
			System.out.println(answer);
			
		}
		System.out.println("*");
		in.close();
		System.exit(0);
	}
}