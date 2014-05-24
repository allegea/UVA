/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Alejandro E. Garces
 */

public class WordIndex{

	static ArrayList<NewString> words;
	static int n;
	static char[] letters;
	static HashMap<String, Integer> index;
	public static class NewString implements Comparable<NewString>{
            
            String x;
            NewString(String xx)
            {
               x = xx;
            }
            
            @Override
            public int compareTo(NewString w)
            {
                if(x.length() != w.x.length())return x.length() - w.x.length();
                return x.compareTo(w.x);
            }
            @Override
            public String toString()
            {
                return x;
            }
        }
	static void BT(String current, int j)
	{
		if(current.length() == 5)return;
		for(int i=j;i<n;i++)
		{
			String aux = current;
			aux+=""+letters[i];
			words.add(new NewString(aux));
			//System.out.println(aux);
			BT(aux, i+1);
		}
			
	}
	
	static void ByBT()
	{
		n = 26;
		letters = new char[n];
		for(char i='a';i<='z';i++)
		letters[i-'a']=i;
		words = new ArrayList<NewString>();
		index = new HashMap<String, Integer>();
		BT("", 0);
		//System.out.println(words.size());
		Collections.sort(words);
		//System.out.println(words);
		for(int i=0;i<words.size();i++)
			index.put(words.get(i).x, i+1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ByBT();
		String line="";
               // System.out.println("fds");
		while((line = in.readLine()) != null && line.length()>0)
			System.out.println(index.containsKey(line)?index.get(line):"0");
                in.close();
                System.exit(0);
		
	}
}