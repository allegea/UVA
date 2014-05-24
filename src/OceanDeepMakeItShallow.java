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

public class OceanDeepMakeItShallow {

	static final int prime = 131071;
	public static void main(String[] args) throws IOException{
		
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		String line = "";
		while(in.hasNext())
		{
                        String number = "";
			do{
				line = in.next();
				number+=line;
			
			}while(line.indexOf("#") == -1);
			
			//System.out.println("** "+number);
			int n = number.length();
			int x = 1*(number.charAt(n-2)-'0');
			int w = 1;
			for(int i=n-3;i>=0;i--)
			{
				w = ((w%prime)*(2%prime))%prime;
				x = (x%prime + ((w*(number.charAt(i)-'0'))%prime))%prime;
			}
			
			if(x%prime == 0)
			System.out.println("YES");
			else System.out.println("NO");
		}
		
		in.close();
		System.exit(0);
	}
}