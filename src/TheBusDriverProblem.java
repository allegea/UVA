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
public  class TheBusDriverProblem{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int[] morning, evening;
		StringTokenizer st;
		while(true)
		{
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(N == 0 && d == 0 && r == 0)break;
			morning = new int[N];
			evening = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++)
				morning[i] = Integer.parseInt(st.nextToken());
				
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++)
				evening[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(morning);
			Arrays.sort(evening);
			long answer = 0;
			for(int i = 0; i < N; i++)
			{
				long route = morning[i] + evening[N - i - 1];
				if(route > d)answer += (route - d) * r;
			}
			System.out.println(answer);
		}
		in.close();
		System.exit(0);
	}
}