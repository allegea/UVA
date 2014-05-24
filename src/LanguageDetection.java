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

class  LanguageDetection {

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("HELLO", "ENGLISH");
		map.put("HOLA", "SPANISH");
		map.put("HALLO", "GERMAN");
		map.put("BONJOUR", "FRENCH");
		map.put("CIAO", "ITALIAN");
		map.put("ZDRAVSTVUJTE", "RUSSIAN");
		String line = "";
		int curr = 1;
		while(true)
		{
			line = in.readLine().trim();
			if(line.equals("#"))break;
			
			System.out.println("Case "+curr+": "+(map.containsKey(line)?map.get(line):"UNKNOWN"));
			curr++;
		}
		
		in.close();
		System.exit(0);
	}
}