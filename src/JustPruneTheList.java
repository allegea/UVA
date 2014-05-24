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
public class JustPruneTheList {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		StringTokenizer st;
		HashSet<Long> numbers;
		HashMap<Long, Integer> freA, freB;
		while( cases-- > 0 )
		{
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			freA = new HashMap<Long, Integer>();
			freB = new HashMap<Long, Integer>();
			numbers = new HashSet<Long>();
			st = new StringTokenizer(in.readLine());
			for(int i = 0 ; i < N; i ++)
			{
				long value =  Long.parseLong(st.nextToken());
				int fre = 1;
				if(freA.containsKey(value))
					fre+= freA.get(value);
				freA.put(value, fre);
				numbers.add(value);
			}
			st = new StringTokenizer(in.readLine());
			for(int i = 0 ; i < M; i ++)
			{
				long value =  Long.parseLong(st.nextToken());
				int fre = 1;
				if(freB.containsKey(value))
					fre+= freB.get(value);
				freB.put(value, fre);
				numbers.add(value);
			}
			
			int count = 0;
			for(long x:numbers)
			{
				long fre1 = 0;
				long fre2 = 0;
				if(freA.containsKey(x))
					fre1+= freA.get(x);
				if(freB.containsKey(x))
					fre2+= freB.get(x);
				count+=Math.abs(fre1 - fre2);
			}
			System.out.println(count);
			
		}
		in.close();
		System.exit(0);
	}
}