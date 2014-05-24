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

public class HardwoodSpecies{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		ArrayList<Integer> fre;
		TreeMap<String, Integer> output;
		int pos;
		HashMap<String, Integer> map;
		ArrayList<String> names;
		in.readLine();
		String line = "";
		boolean first = true;
		while(t-->0)
		{
			output = new TreeMap<String, Integer>();
			fre = new ArrayList<Integer>();
			names = new ArrayList<String>();
			map = new HashMap<String, Integer>();
			pos = 0;
			if(!first)System.out.println();
			first = false;
			int n = 0;
			while((line = in.readLine())!=null && line.length()>0)
			{
				if(map.containsKey(line))
				{
					int x = map.get(line);
					int f = fre.get(x)+1;
					fre.set(x, f);
				}else
				{
					names.add(line);
					map.put(line, pos++);
					fre.add(1);
				}
				n++;
			}
			
			for(String x:names)
			{
				int f = fre.get(map.get(x));
				output.put(x, f);
			}
                        
                        Entry<String, Integer> salida;
                        while(!output.isEmpty())
                        {
                            salida = output.pollFirstEntry();
                            System.out.printf("%s %.4f\n",salida.getKey(), (salida.getValue()/(float)(n))*100);
                        }
			
			
		}
		in.close();
		System.exit(0);
	}
}
