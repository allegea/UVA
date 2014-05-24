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

public class BeatTheSpread {
	

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		int n = Integer.parseInt(in.readLine());
		for(int i=0;i<n;i++)
		{
			read = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(read.nextToken());
			int y = Integer.parseInt(read.nextToken());
			int a = x-y;
			if(a%2==0)a/=2;
			else a=-1;
			int b = y+a;
			if(a < 0 || b < 0)System.out.println("impossible");
			else System.out.println(Math.max(a, b)+" "+Math.min(a, b));
		}
		
		in.close();
		System.exit(0);
	}
}