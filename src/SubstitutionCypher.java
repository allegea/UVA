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
public class SubstitutionCypher{


	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		HashMap<Character, Character> map; 
		in.readLine();
		ArrayList<String> lines;
		boolean noFirst = false;
		while(n-- > 0)
		{
			if(noFirst)System.out.println();
			noFirst = true;
			
			map = new HashMap<Character, Character>();
			String ori = in.readLine();
			String sub = in.readLine();
			for(int i = 0; i < ori.length(); i ++)
				map.put( ori.charAt(i), sub.charAt(i));
				
			lines = new ArrayList<String>();
			String rline = "";
			while((rline = in.readLine()) != null && rline.length() > 0)
				lines.add(rline);
			
                        System.out.println(sub);
                        System.out.println(ori);
			for(String line:lines)
			{
				char[] newLine = line.toCharArray();
				for(int i = 0; i < newLine.length; i++)
					if(map.containsKey(newLine[i]))
						newLine[i] = map.get(newLine[i]);
				System.out.println(String.valueOf(newLine));
			}
			
				
		}
		in.close();
		System.exit(0);
	}

}
