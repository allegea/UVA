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

public class Editor{

	static final int ALPHA = 27;
	static StringBuilder output = new StringBuilder();
	static class Node{
		Node[] childs;
		int visits;
		Node()
		{
			childs = new Node[ALPHA];
			visits = 0;
		}
	}
	
	static class Trie{
		Node root;
		int maxRepeated;
		Trie(String word)
		{
                        root = new Node();
			maxRepeated = 0;
			int size = word.length();
			for(int i = size-1;i>=0;i--)
				addWord(word.substring(i));
		}
		
		void addWord(String word)
		{
                    //System.out.println(word);
			Node path = root;
			int pos = 0;
			for(char c:word.toCharArray())
			{
				pos = c-'a';
				if(path.childs[pos] == null)
					path.childs[pos] = new Node();
				path.childs[pos].visits++;
				path = path.childs[pos];
			}
		}
		
		void LRS()
		{
			findDeepest(root, 0);
			output.append(maxRepeated).append("\n");
		}
		
		void findDeepest(Node child, int deep)
		{
			boolean goDeep = false;
			for(int i=0;i<ALPHA;i++)
                        {
                           // if(child.childs[i] != null)System.out.println(LRS + (char)(i+'a')+" - "+child.childs[i].visits+" - "+deep+" - "+maxRepeated);
                            if(child.childs[i] != null && child.childs[i].visits > 1)
                                {
                                    goDeep = true;
                                    findDeepest(child.childs[i], deep + 1);
                                }
                        }
			if(!goDeep && deep > maxRepeated)maxRepeated = deep;
		}
	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Trie myTrie;
		while(n-- > 0)
		{
			myTrie = new Trie(in.readLine());
			myTrie.LRS();
		}
		
		System.out.print(output);
		in.close();
		System.exit(0);
	}
}