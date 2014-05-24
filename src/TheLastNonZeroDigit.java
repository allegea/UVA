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

public class TheLastNonZeroDigit{
ff
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line = in.readLine())!=null && line.length() > 0)
		{
			String[] read = line.split("[ ]+");
			int n = Integer.parseInt(read[0]);
			int m = Integer.parseInt(read[1]);
			long x = 1;
                        
			for(int i=(n-m)+1;i<=n;i++)
			{
				x*=i;
				while(x%10 == 0)
				x/=10;
                                
				x%=10;
			}
			
			System.out.println(x);
			
		}
                in.close();
                System.exit(0);
	}

}
