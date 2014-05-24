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
public class UniqueSnowflakes {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		HashMap<Integer, Integer> map;
		int[] values;
		while(cases-- > 0)
		{
			int N = Integer.parseInt(in.readLine());
                        map = new HashMap<Integer, Integer>();
			int max = 0;
			values = new int[N];
			for(int i = 0; i < N; i++)
                        values[i] = Integer.parseInt(in.readLine());
			
                        int i, j;
                        i = j = 0;
			for(i = 0; i < N; i++)
			{
                            if(map.containsKey(values[i]))
                            {
                                max = Math.max(i - j, max);
                                j = Math.max(j, map.get(values[i]));
                                map.remove(values[i]);
                            }
                            map.put(values[i], i + 1);
                            //System.out.println(i + " - " + j + " - " + max + " - " + map);

			}
                       // System.out.println(i + " - " + j + " - " + max + " - " + map);
                         max = Math.max(i - j, max);
                        System.out.println(max);
		
		}
	
		in.close();
		System.exit(0);
	}
}