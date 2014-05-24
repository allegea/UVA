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

class  MorningWalk {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		String line = "";
		while((line = in.readLine()) != null && line.length() > 0)
		{
			read = new StringTokenizer(line);
			int n = Integer.parseInt(read.nextToken());
			int r = Integer.parseInt(read.nextToken());
			int[] nodes = new int[n];
			
			for(int i=0;i<r;i++)
			{
				read = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(read.nextToken());
				int v = Integer.parseInt(read.nextToken());
				nodes[u]++;
				nodes[v]++;
			}
			
			boolean answer = true;
			for(int i=0;i<n && answer;i++)
				if(nodes[i] == 0)answer = false;
				else if(nodes[i]%2 != 0)answer = false;
				
			System.out.println(answer?"Possible":"Not Possible");
		}
		
		in.close();
		System.exit(0);
	}
}