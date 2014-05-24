/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author Alejandro E. Garces
 */

public class ListOfConquests {
	
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static ArrayList<String> names = new ArrayList<String>();
	
	static void addToMap(String x)
	{
		int n = map.size();
		if(map.containsKey(x))
		{
			int fr = map.get(x)+1;
			map.put(x, fr);
		}else {
			map.put(x, 1);
			names.add(x);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		int n = Integer.parseInt(in.readLine());
		for(int i=0;i<n;i++)
		{
			read = new StringTokenizer(in.readLine());
			addToMap(read.nextToken());
		}
		TreeMap<String, Integer> answer = new TreeMap<String, Integer>();
		for(String x:names)
		answer.put(x, map.get(x));
		
		Entry<String, Integer> aux;
		while(!answer.isEmpty())
		{
			aux = answer.pollFirstEntry();
			System.out.println(aux.getKey()+" "+aux.getValue());
		}
		in.close();
		System.exit(0);
	}
}