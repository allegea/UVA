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

public class EditorSA{

    static StringBuilder output = new StringBuilder();
    static class SuffixArray{
        
        String[] suffixes;
        int N;
        
        SuffixArray(String word)
        {
            N = word.length();
            
            suffixes = new String[N];
            for(int i = 0; i < N; i++)
                suffixes[i] = word.substring(i);
           // System.out.println(Arrays.toString(suffixes));
            Arrays.sort(suffixes, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int n1 = o1.length();
                    int n2 = o1.length();
                    int n = Math.min(n1, n2);
                    for(int i = 0; i < n; i++)
                        if(o1.charAt(i) != o2.charAt(i))return o1.charAt(i) - o2.charAt(i);
                    return n1 - n2;
                }
            });
           // System.out.println("----------");
            //System.out.println(Arrays.toString(suffixes));
        }
        
        int findLRS()
        {
            int max = 0;
            for(int i = 0; i < N - 1; i++)
            {
                int maxAux = commondStrings(suffixes[i], suffixes[i+1]);
                max = Math.max(maxAux, max);
            }
            return max;
        }
        
        int commondStrings(String a, String b)
        {
            int i = 0;
            int n1 = a.length();
            int n2 = b.length();
            int n = Math.min(n1, n2);
            for(; i < n; i++)
                if(a.charAt(i) != b.charAt(i))break;
            return i;
                
        }
    }
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		SuffixArray mySA;
		while(n-- > 0)
		{
			mySA = new SuffixArray(in.readLine());
			output.append(mySA.findLRS()).append("\n");
		}
		
                
		System.out.print(output);
		in.close();
		System.exit(0);
	}
}