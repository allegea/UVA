/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class IDCodes{

	static void swap(char[] x, int i, int j)
	{
		char c = x[i];
		x[i] = x[j];
		x[j] = c;
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
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			char[] x = in.readLine().toCharArray();
			if(x[0] == '#')break;
			if(nextPermutation(x))System.out.println(x);
			else System.out.println("No Successor");
			
		}
		
	}
}