/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author Alejandro E. Garces
 */


public class GATTACA {
	static final int ALPHA = 256;
	static StringBuilder output = new StringBuilder();
	static class Trie{
		Node root;
		HashMap<String, Integer> LRS;
		int maxSize;
                String maxRepeated;
                int frec;
		Trie(String word)
		{
			root = new Node();
			LRS = new HashMap<String, Integer>();
			maxSize = 0;
                        maxRepeated = "";
                        frec = 0;
			int size = word.length();
			for(int i = size - 1; i >= 0; i--)
				add(word.substring(i));
		}
		
		void add(String word)
		{
                   //System.out.println(word);
                        StringBuilder currentWord = new StringBuilder();
			boolean repeated = true;
			Node sufixes = root;
			//int sizeR = 0;
			int pos = 0;
			for(char c:word.toCharArray())
			{
				if(sufixes.childs[c] == null)
				{
					if(repeated && pos > 0)
					{
						
						if(pos > maxSize)
						{
                                                        maxRepeated = currentWord.toString();
							maxSize = pos;
                                                        frec = 2;
						}else if(pos == maxSize)
						{
                                                   // System.out.println("Same");
                                                        String posNewMax = currentWord.toString();
                                                        int comparation = maxRepeated.compareTo(posNewMax);
                                                        if(comparation == 0)
                                                            frec++;
                                                        else if(comparation > 0)
                                                        {
                                                            maxRepeated = posNewMax;
                                                            frec = 2;
                                                        }
						}
					}
                                        repeated = false;
					sufixes.childs[c] = new Node();
				}
                                currentWord.append(c);
				sufixes = sufixes.childs[c];
				pos++;
			}
                        
                        if(repeated)
                        {
                                if(pos > maxSize)
                                {
                                        maxRepeated = currentWord.toString();
                                        maxSize = pos;
                                        frec = 2;
                                }else if(pos == maxSize)
                                {
                                   // System.out.println("Same");
                                        String posNewMax = currentWord.toString();
                                        int comparation = maxRepeated.compareTo(posNewMax);
                                        if(comparation == 0)
                                            frec++;
                                        else if(comparation > 0)
                                        {
                                            maxRepeated = posNewMax;
                                            frec = 2;
                                        }
                                }
                        }
		}
		
		void LRS()
		{
                       // System.out.println(LRS);
			/*TreeMap<String, Integer> max = new TreeMap<String, Integer>();
			for(Entry<String, Integer> lexico:LRS.entrySet())
				max.put(lexico.getKey(), lexico.getValue());
				
			if(max.isEmpty())System.out.println("No repetitions found!");
			else System.out.println(max.firstEntry().getKey()+" "+max.firstEntry().getValue());*/
                        /*if(maxSize == 0)System.out.println("No repetitions found!");
                        else System.out.println(maxRepeated+" "+frec);*/
                        if(maxSize == 0) output.append("No repetitions found!").append("\n");
                        else  output.append(maxRepeated).append(" ").append(frec).append("\n");
                      
		}
	
	}
	
	static class Node{
		Node[] childs;
		Node()
		{
			childs = new Node[ALPHA];
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		while(n-- > 0)
		{
			Trie myTrie;
                        myTrie = new Trie(in.readLine());
			myTrie.LRS();
		}
                System.out.print(output);
		in.close();
		System.exit(0);
	}

}