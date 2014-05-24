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
public class SoundexIndexing {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		String padded = "000";
		HashSet<Character>[] codes = new HashSet[7];
		String[] input = {"AEIOUYWH", "BPFV", "CSKGJQXZ", "DT", "L", "MN", "R"};
		for(int i = 0; i < 7; i ++)
		{
			codes[i] = new HashSet<Character>();
			for(char c:input[i].toCharArray())
				codes[i].add(c);
		}
                boolean first = true;
		int count = 0;
                int prev = -1;
		while((line = in.readLine()) != null && line.length() > 0)
		{
                    count++;
                    if(first)System.out.println("         NAME                     SOUNDEX CODE");
                    first = false;
			String answer = "" + line.charAt(0);
			boolean put = codes[0].contains(line.charAt(0));
                        for(int j = 0; j < 7; j++)
                            if(codes[j].contains(line.charAt(0)))
                            {
                                prev = j;
                                 break;
                            }
			for(int i = 1; i < line.length() && answer.length() < 4; i++)
			{
				if(codes[0].contains(line.charAt(i)))
					prev = 0;
				else{
					for(int j = 1; j < 7; j++)
					 if(codes[j].contains(line.charAt(i)))
					{
                                                if(prev == j)break;
						answer+="" + j;
						put = false;
                                                prev = j;
						break;
					}
				}
			}
			//System.out.println("* " + answer + "-");
                        if(answer.length() < 5)
			answer+=padded.substring(answer.length() - 1);
			while(line.length() < 25) line+=" ";
			System.out.println("         " + line + answer);
			
		
		}
		if(count > 0)System.out.println("                   END OF OUTPUT");
	
		in.close();
		System.exit(0);
	}
}