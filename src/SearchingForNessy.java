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

class  SearchingForNessy {

	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n-->0)
		{
			int a = in.nextInt()-2;
			int b = in.nextInt()-2;
			System.out.println((int)Math.ceil(a/(float)3)*(int)Math.ceil(b/(float)3));
		}
		in.close();
		System.exit(0);
	}
}