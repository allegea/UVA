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

public class PseudoRandomNumbers {

	public static long Z, I, M;
	public static long nextRan(long last)
	{
		return (Z * last + I) % M;
	}
	public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashMap<Long, Integer> map;
		int cases = 1;
		while(true)
		{
			st = new StringTokenizer(in.readLine());
			Z = Long.parseLong(st.nextToken());
			I = Long.parseLong(st.nextToken());
			M = Long.parseLong(st.nextToken());
			long L = Long.parseLong(st.nextToken());
			int pos = 0;
			if(Z == 0 && I == 0 && M == 0 && L == 0)break;
			map = new HashMap<Long, Integer>();
			map.put(L, pos++);
			while(true)
			{
				long next = nextRan(L);
				if(map.containsKey(next))
				{
					System.out.println("Case " + (cases++) + ": " + (pos - map.get(next)));
					break;
				}
				map.put(next, pos++);
				L = next;
			}
		}
         in.close();
         System.exit(0);
     }

}