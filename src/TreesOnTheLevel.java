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

public class TreesOnTheLevel {

	static boolean complete;
	static class node{
		node l, r;
		int value = -1;
		boolean set = false;
		node(int v)
		{
			value = v;
			set = true;
		}
		node()
		{
			value = -1;
			set = false;
		}
                
                public void set(int v)
                {
                    value = v;
                    set = true;
                }
	}
	static class BST{
		node root;
		int size = 0;
		public void add(int value, char[] path)
		{
			complete = true;
                          if(size == 0){
                            root = new node();
                            size++;
                        }
			if(path.length == 0)
			{
				if(root == null)root = new node(value);
				else if(root.set == true)complete = false;
				else root.set(value);
			}else add(root, value, path, 0, path.length);
		}
                
		public node add(node r, int value, char[] path, int d, int s)
		{
                    // System.out.println(value+" - "+(r == null)+" - "+ (r != null?r.value:-1)+" - "+String.valueOf(path));
			if(d == s)
			{
				if(r == null)r = new node(value);
				else if(r.set == true)complete = false;
				else r.set(value);
				return r;
			}else {
				if(r == null)r = new node();
				if(path[d] == 'L')r.l = add(r.l, value, path, d+1, s);
				else r.r = add(r.r, value, path, d+1, s);
				return r;
			}
		}
		
		public boolean check()
		{
			return check(root);
		}
		public boolean check(node r)
		{
			if(r!=null)
			{
				if(r.set == false)return false;
				return check(r.l)&check(r.r);
			}else return true;
		}
		
		public void print()
		{
			Queue<node> Q = new LinkedList<node>();
			Q.offer(root);
			StringBuilder out = new StringBuilder();
			while(!Q.isEmpty())
			{
				node x = Q.poll();
				out.append(x.value).append(" ");
				if(x.l != null)Q.offer(x.l);
				if(x.r != null)Q.offer(x.r);
			}
			System.out.println(out.toString().trim());
		}
	}
   public static void main(String[] args) throws IOException{
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         Scanner in = new Scanner(System.in);
         BST arbol = new BST();
         boolean comple = true;
         while(in.hasNext())
         {
             String token = in.next();
             int size = token.length();
             if(size == 2)
             {
                 //arbol.postOrden();
                 if(comple == false || arbol.check() == false)
                 {
                     System.out.println("not complete");
                 }else  arbol.print();
                 arbol = new BST();
                 comple = true;
             }else{
                 int index = token.indexOf(",");
                 //System.out.println(token.substring(1, index));
                 //System.out.println(token.substring(index+1, size-1));
                 int value = Integer.parseInt(token.substring(1, index));
                 char path[] = token.substring(index+1, size-1).toCharArray();
                 arbol.add(value, path);
                 if(complete == false)comple = false;
             }
         }
        in.close();
         System.exit(0);
     }
}
