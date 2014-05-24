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

class EventPlaning {
	
	public static void main(String[] args) throws IOException {
	
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> cost;
		while(in.hasNextInt())
		{
			int n = in.nextInt();
			int b = in.nextInt();
			int h = in.nextInt();
			int w = in.nextInt();
			cost = new ArrayList<Integer>();
			
			for(int i=0;i<h;i++)
			{
				int c = in.nextInt();
				boolean add = false;
				for(int j=0;j<w;j++)
					if(in.nextInt() >= n)
						add = true;
						
				if(add) cost.add(c);
				
			}
			
			if(cost.isEmpty()){
				System.out.println("stay home");
				continue;
			}
			
			Collections.sort(cost);
			int answer = cost.get(0);
			if(answer*n <= b)System.out.println(answer*n);
			else System.out.println("stay home");

		}
		in.close();
		System.exit(0);
	}
}