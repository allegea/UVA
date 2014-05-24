/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */

public class JollyJumpers{

	public static void main(String[] args) throws IOException{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String line = "";
	String[] read;
	boolean[] set;
	int[] numbers;
        
	while((line = in.readLine()) != null && line.length()>0)
	{
		read = line.split("[ ]+");
		int n = Integer.parseInt(read[0]);
		if(n == 1)
		{
			System.out.println("Not jolly");
			continue;
		}
		
		numbers = new int[n];
		set = new boolean[n+1];
		for(int i=0;i<n;i++)
		numbers[i] = Integer.parseInt(read[i+1]);
		
		for(int i=0;i<n-1;i++)
		{
			int x = Math.abs(numbers[i] - numbers[i+1]);
			if(x >= n)continue;
			set[x] = true;
		}
		boolean answer = true;
		for(int i=1;i<n;i++)
			if(!set[i])
			{
				answer = false;
				break;
			}
		System.out.println(answer?"Jolly":"Not jolly");
	}	
	in.close();
	System.exit(0);
	}
	
}