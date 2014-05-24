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
public class BinarySearchTree {

    static StringBuilder output = new StringBuilder();
    static class Tree{
        node root;
        int size = 0;
        
        public void add(int value)
        {
            if(size == 0){
                root = new node(value);
                size++;
            }else addNode(root, value);
        }
        
        private node addNode(node r,int value)
        {
            if(r == null){
                size++;
                return new node(value);
                
            }else if(r.value > value) r.l = addNode(r.l, value);
            else r.r = addNode(r.r, value);
            return r;
        }
        private void postOrden()
        {
            postOrden(root);
        }
        private void postOrden(node r)
        {
            if(r != null)
            {
                postOrden(r.l);
                postOrden(r.r);
                output.append(r.value).append("\n");
            }
        }
    }
    static class node{
        node l;
        node r;
        int value;
        node(int v)
        {
            value = v;
        }
    }
   public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         Tree BST = new Tree();
         String line = "";
         while((line = in.readLine())!=null && line.length() > 0)
         {
             BST.add(Integer.parseInt(line));
            // BST.postOrden();
             //System.out.println("****");
         }
         BST.postOrden();
         System.out.print(output);
         in.close();
         System.exit(0);
     }
}
