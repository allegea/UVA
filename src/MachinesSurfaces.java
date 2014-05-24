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

class MachinesSurfaces{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[][] images;
		int[] count;
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			images = new char[n][25];
			count = new int[n];
			int min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
			{
				images[i] = in.readLine().toCharArray();
				for(int j=0;j<25;j++)
					if(images[i][j] == 'B' || images[i][j] == ' ')count[i]++;
					
				min = Math.min(min, count[i]);
			}
			
			int answer = 0;
			for(int i=0;i<n;i++)
				answer+=count[i]-min;
			System.out.println(answer);
		}
		in.close();
		System.exit(0);
	
	}

}