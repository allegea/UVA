/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Alejandro E. Garces
 */

public class WhatGoesUp{
    static Stack< Integer> lis(ArrayList< Integer> list) {
        int N = list.size();
        ArrayList< Integer> M = new ArrayList< Integer>();
        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        M.add(0);
        int[] states = new int[N];
        int L = 1;
        for (int i = 1; i < N; ++i) {
            int x = list.get(i);
            int m = M.size() - 1;
            if (x > list.get(M.get(m))) {
                parent[i] = M.get(m);
                states[i] = states[M.get(m)]+1;
                M.add(i);
                continue;
            }
            int lo = 0;
            int hi = m;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (list.get(M.get(mid)) <= x) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            int j = lo;
            if (x < list.get(M.get(j))) {
                if (j > 0) {
                    parent[i] = M.get(j - 1);
                }
                states[i] = states[M.get(j-1)]+1;
                M.set(j, i);
            }
        }
       // System.out.println(Arrays.toString(states));
        Stack< Integer> lis = new Stack< Integer>();
        int cur = M.get(M.size() - 1);
        while (cur != -1) {
            lis.push(list.get(cur));
            cur = parent[cur];
        }
        return lis;
    }
    
   static  ArrayList< Integer> lis2(ArrayList< Integer> list) {
        int N = list.size();
        ArrayList< Integer> M = new ArrayList< Integer>();
        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        M.add(0);
        for (int i = 1; i < N; ++i) {
            int x = list.get(i);
            if (x > list.get(M.get(M.size() - 1))) {
                parent[i] = M.get(M.size() - 1);
                M.add(i);
                continue;
            }
            int lo = 0;
            int hi = M.size() - 1;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (list.get(M.get(mid)) <= x) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            int j = lo;
            if (x < list.get(M.get(j))) {
                if (j > 0) {
                    parent[i] = M.get(j - 1);
                }
                M.set(j, i);
            }
        }
        ArrayList< Integer> lis = new ArrayList< Integer>();
        int cur = M.get(M.size() - 1);
        while (cur != -1) {
            lis.add(0, list.get(cur));
            cur = parent[cur];
        }
        return lis;
    }

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		while( (line = in.readLine() )!= null && line.length() > 0)
			numbers.add(Integer.parseInt(line));

                /*Stack<Integer> answer = lis(numbers);
                System.out.println(answer.size()+"\n-");
                while(!answer.isEmpty())
                    System.out.println(answer.pop());*/
                
                 ArrayList<Integer> answer = lis2(numbers);
                System.out.println(answer.size()+"\n-");
                while(!answer.isEmpty())
                    System.out.println(answer.remove(0));
                
		in.close();
		System.exit(0);
	
	}

}

