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

public class Password4845 {

	private static List<Character>[] characters;
	private static List<Boolean>[] used;
	private static List<String> passwords;
	private final static int LIST_LENGTH = 5;
	
	private static void findPasswords(int i, char[] word) {
		if (i == LIST_LENGTH) passwords.add(String.valueOf(word));
		else {
			for (int j = 0; j < characters[i].size(); j++)
				if (!used[i].get(j)) {
					used[i].set(j, true);
					word[i] = characters[i].get(j);
					findPasswords(i + 1, word);
					used[i].set(j, false);
				}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		while (cases-- > 0) {
			int k = Integer.parseInt(in.readLine());
			characters = new ArrayList[LIST_LENGTH];
			used = new ArrayList[LIST_LENGTH];
			Set<Character> first = new HashSet<Character>();
			Set<Character> second = new HashSet<Character>();
			char[][] a = new char[6][6];
			char[][] b = new char[6][6];
			for (int i = 0; i < 6; i++) {
				a[i] = in.readLine().toCharArray();
			}
			for (int i = 0; i < 6; i++) {
				b[i] = in.readLine().toCharArray();
			}
			int max = 1;
			for (int i = 0; i < LIST_LENGTH; i++) {
				first = new HashSet<Character>();
				second = new HashSet<Character>();
				for (int j = 0; j < 6; j++) {
					first.add(a[j][i]);
					second.add(b[j][i]);
				}
				characters[i] = new ArrayList<Character>();
				used[i] = new ArrayList<Boolean>();
				first.retainAll(second);
				for (Character x : first) {
					characters[i].add(x);
					used[i].add(false);
				}
				max *= Math.max(1, characters[i].size());
			}
			
			if (max < k) System.out.println("NO");
			else {
				passwords = new ArrayList<String>();
				findPasswords(0, new char[LIST_LENGTH]);
				Collections.sort(passwords);
				if (passwords.size() >= k) System.out.println(passwords.get(k - 1));
				else System.out.println("NO");
			}
			
		}
		in.close();
		System.exit(0);
	}

}