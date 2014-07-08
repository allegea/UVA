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
public class Palinwords {

	private static Set<String> palindromes;
	private static Boolean[][] dp;
	private static int N;
	private static String word;
	
	private static boolean solve(int i, int j) {
		if (i == N || j < 0) return false;
		if (dp[i][j] != null) return dp[i][j];
		if (i >= j) return dp[i][j] = true;
		boolean value = false;
		if (word.charAt(i) == word.charAt(j)) {
			value = solve(i + 1, j - 1);
			if (value && (j - i + 1 == 3 || j - i + 1 == 4)) {
				String newWord = word.substring(i, j + 1);
				/*boolean contains = false;
				for (String x : palindromes) {
					if(newWord.contains(x)) {
						contains = true;
						break;
					}
				}
				if (!contains) */palindromes.add(newWord);
			}
		}
		solve(i + 1, j);
		solve(i, j - 1);
		return dp[i][j] = value;
	}
	
	static class StringComparator implements Comparator<String> {
	    @Override
	    public int compare(String a, String b) {
	        return b.length() - a.length();
	    }
	}
	private static boolean isValid() {
		int count = 0;
		List<String> list = new ArrayList<String>();
		for (String x : palindromes) 
			list.add(x);
		Collections.sort(list, new StringComparator());
		
		for (int i = 0; i < list.size(); i++) {
			boolean valid = true;
			String current = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (current.contains(list.get(j))) {
					valid = false;
					break;
				}
			}
			if (valid)count++;
		}
		
		return count >= 2;
	}
   public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String line = "";
         StringBuilder sb = new StringBuilder();
         while ((line = in.readLine()) != null && !line.isEmpty()) {
        	StringTokenizer st = new StringTokenizer(line);
        	while (st.hasMoreTokens()) {
        		word = st.nextToken();
        		N = word.length();
        		dp = new Boolean[N + 1][N + 1];
        		palindromes = new HashSet<String>();
        		solve(0, N - 1);
        		if (isValid()) sb.append(word).append("\n");
        	}
         }
         System.out.print(sb);
         in.close();
         System.exit(0);
     }
}
