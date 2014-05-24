/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class DifferentDigits {

	public static boolean check(int x)
	{
		HashSet<Integer> map = new HashSet<Integer>();
		while(x!=0)
		{
			if(!map.add(x%10))return false;
			x/=10;
		}
		return true;
	}

public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner in = new BufferedReader(new InputStreamReader(System.in));
		int n = 5000;
		boolean toUse;
		int[] count = new int[n+1];
		
		for(int i=1;i<=n;i++)
		{
			toUse = check(i);
			count[i] = count[i-1] + (toUse?1:0);
		}
		String line = "";
		while( (line = in.readLine()) != null)
		{
			String[] read = line.split("[ ]+");
			int nn = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
		

			System.out.println(count[m]-count[nn-1]);
			
		}
		
		in.close();
		System.exit(0);
	}
	
}