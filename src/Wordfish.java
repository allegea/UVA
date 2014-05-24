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

public class Wordfish{

	public static TreeSet<String> permut;
	public static int sizeP;
	public static int N;
	public static boolean[] visited;
	public static char[] username;
	
        static void swap(char[] x, int i, int j)
    {
        char a = x[i];
        x[i] = x[j];
        x[j] = a;
    }
    
    static boolean prevPermutation(char[] c) {
        int n = c.length;
        int i = n - 1;
        while (i > 0 && c[i - 1] <= c[i]) {
            --i;
        }
        if (i == 0) {
            return false;
        }
        int k = i - 1;
        int l = 0;
        for (int j = n - 1; j >= 0; --j) {
            if (c[j] < c[k]) {
                l = j;
                break;
            }
        }
        swap(c, k, l);
        for (int j = k + 1; j < (n + k + 1) / 2; ++j) {
            swap(c, j, n + k - j);
        }
        return true;
    }
    static boolean nextPermutation(char[] c) {
        int n = c.length;
        int k = -1;
        for (int i = n - 2; i >= 0; --i) {
            if (c[i] < c[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return false;
        }
        int l = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (c[k] < c[i]) {
                l = i;
                break;
            }
        }
        swap(c, k, l);
        for (int i = k + 1; i < (n + k + 1) / 2; ++i) {
            swap(c, i, n + k - i);
        }
        return true;
    }
	
	
	public static String solution(String user)
	{
		username = user.toCharArray();
                char[] username2 = user.toCharArray();
		N = user.length();
		char[] letters = user.toCharArray();
		Arrays.sort(letters);
		//permut = new TreeSet<String>();
                String[] permut = new String[21];
                visited = new boolean[N];
		//BT(0, "");
                int h = 0;
                int[] distances = new int[21];
                for(; h < 10; h++)
                {
                    prevPermutation(username);
                    permut[10 - h - 1] = String.valueOf(username);
                }
                 permut[h++] = String.valueOf(username2);
                for(; h < 21; h++)
                {
                    nextPermutation(username2);
                    permut[h] = String.valueOf(username2);
                }
                //Arrays.sort(permut);
		System.out.println(Arrays.toString(permut));
		int pos = 0;
		int minDist = 0;
		String answer = "";
		int j = 0;
		for(String line:permut)
		{
			int dist = Integer.MAX_VALUE;
			boolean found = false;
			for(int i = 0; i < N - 1; i++)
			{
				/*if(Math.abs(letters[i] - letters[i + 1]) > 1)continue;
				int x = line.indexOf(letters[i]);
				int y = line.indexOf(letters[i + 1]);
				dist = Math.min(Math.abs(x - y), dist);
                                System.out.println(j + " - "+ letters[i] + " - "+letters[i + 1] + " - " + x + " - " + y + " - " +dist);
				found = true;*/
                              
				int x = line.charAt(i) - 'A';
				int y = line.charAt(i + 1) - 'A';
				dist = Math.min(Math.abs(x - y), dist);
                                //System.out.println(j + " - "+ letters[i] + " - "+letters[i + 1] + " - " + x + " - " + y + " - " +dist);
				found = true;
			}
			//System.out.println(j + " - "+ line + " - "+dist);
                        distances[j] = dist;
			if(found && dist > minDist)
			{
				pos = j;
				minDist =  dist;
			}
			j++;
		}
                TreeSet<String> lexi = new TreeSet<String>();
                for(int i = 0; i < 21; i++)
                    if(distances[i] == minDist)
                        lexi.add(permut[i]);
                
		//answer = permut[pos];
                answer = lexi.first();
		//System.out.println(answer +" - "+answer);
		return answer+""+minDist;
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line = in.readLine()) != null)
		System.out.println(solution(line));
		
		in.close();
		System.exit(0);
	}
	
}