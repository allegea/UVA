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

public class ElementaryAdditions {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String curr = "{}";
		String[] values = new String[16];
		values[0] = curr;
		for(int i = 1; i <= 15; i++)
		{
			values[i] = "{"+curr+"}";
                        //System.out.println(i + " - " + values[i]);
			curr+=","+values[i];
		}
		
		for(int i = 0; i<16; i++)
			map.put(values[i], i);
		
               // System.out.println(map);
                
		int n = Integer.parseInt(in.readLine());
		while(n-->0)
		{
			String x = in.readLine();
			String y = in.readLine();
			int a = map.get(x);
			int b = map.get(y);
			System.out.println(values[a + b]);
		}
		in.close();
		System.exit(0);
	}
}