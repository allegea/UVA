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

public class TreeRecovery  {

	static final int M = 27;
	static int[] toInt;
	static char[] toChar;
	static StringBuilder out;
	
	static class Node{
	
		Node r, l;
		int value;
		Node(int v)
		{
			value = v;
		}
	}
	
	static class BST{
	
		Node root;
		void add(int value)
		{
			if(root == null)root = new Node(value);
			else add(root, value);
		}
		static Node add(Node r, int value)
		{
			if(r == null)r = new Node(value);
			else{
				if(r.value > value)r.l = add(r.l, value);
				else r.r = add(r.r, value);
			}
			return r;
		}
		
		void postOrder()
		{
			postOrder(root);
		}
		void postOrder(Node r)
		{
                    if(r != null)
                    {
			postOrder(r.l);
			postOrder(r.r);
			//System.out.println(r.value+" - "+toChar[r.value]);
                        //System.out.println(r.value);
                        out.append(toChar[r.value]);
                    }
		}
	}
	
   public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		StringTokenizer r;
		BST tree;
		while((line = in.readLine())!=null && line.length()>0)
		{
			tree = new BST();
			out = new StringBuilder();
			r = new StringTokenizer(line);
			char[] preOr = r.nextToken().toCharArray();
			char[] inOr = r.nextToken().toCharArray();
			int value = 0;
			int n = inOr.length;
			toInt = new int[M];
			toChar = new char[M];
			for(int i=0;i<n;i++)
			{
				toInt[inOr[i]-'A'] = value;
				toChar[value++] = inOr[i];
			}
			//System.out.println(Arrays.toString(toInt));
                        //System.out.println(Arrays.toString(toChar));
			for(int i=0;i<n;i++)
				tree.add(toInt[preOr[i]-'A']);
			tree.postOrder();
                        System.out.println(out);

		}
         in.close();
         System.exit(0);
     }
}
