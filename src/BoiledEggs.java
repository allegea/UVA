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
public  class  BoiledEggs{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int[] eggs;
		StringTokenizer st;
                int cases = 0;
		int N = Integer.parseInt(in.readLine());
		while(cases++ < N)
		{
			st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			eggs = new int[M];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < M; i++)
				eggs[i] = Integer.parseInt(st.nextToken());
				
			int answer = 0;
			int weight = 0;
			for(int i = 0; i < M && i < P; i++)
			{
				weight += eggs[i];
				if(weight > Q)break;
				answer++;
			}
			System.out.println("Case "+ cases + ": " + answer);
		}
		in.close();
		System.exit(0);
	}
}