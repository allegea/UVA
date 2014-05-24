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


public class GATTACA1 {
	static final int ALPHA = 28;
        static final int[] forCheck = new int[]{'A'-'A', 'C'-'A', 'G'-'A', 'T'-'A'};
	static StringBuilder output = new StringBuilder();
	static class Trie{
		Node root;
		int maxSize;
                String maxRepeated;
                int frec;
		Trie(String word)
		{
			root = new Node();
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
			Node sufixes = root;
			int pos = 0;
			for(char c:word.toCharArray())
			{
                                pos = c - 'A';
				if(sufixes.childs[pos] == null)
					sufixes.childs[pos] = new Node();
				sufixes = sufixes.childs[pos];
                                sufixes.visited++;
			}
		}
		
		void LRS()
		{
                        findDeepesth(root, 0, "");
                        /*if(maxSize == 0)System.out.println("No repetitions found!");
                        else System.out.println(maxRepeated+" "+frec);*/
                       if(maxSize == 0) output.append("No repetitions found!").append("\n");
                        else  output.append(maxRepeated).append(" ").append(frec).append("\n");
                      
		}
                
                void findDeepesth(Node sufixes, int deep, String LRS)
                {
                    boolean goingDown = false;
                    for(int i=0;i<forCheck.length;i++)
                    {   //if(sufixes.childs[i] != null)System.out.println(LRS + (char)(i+'A')+" - "+sufixes.childs[i].visited+" - "+deep+" - "+ maxSize);
                        int check = forCheck[i];
                        if(sufixes.childs[check] != null && sufixes.childs[check].visited > 1)
                        {
                            goingDown = true;
                            findDeepesth(sufixes.childs[check], deep + 1, LRS + (char)(check + 'A'));
                        }
                    }
                    if(!goingDown && deep > maxSize)
                    {
                        frec = sufixes.visited;
                        maxSize = deep;
                        maxRepeated = LRS;
                    }
                        
                }
	
	}
	
	static class Node{
		Node[] childs;
                int visited;
		Node()
		{
			childs = new Node[ALPHA];
                        visited = 0;
                        
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