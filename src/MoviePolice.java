/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro E. Garces
 */
public class MoviePolice
{
	public static int Hamming(String x, String y)
	{
                int n = x.length();
                int m = y.length();
		if(n<m)return Integer.MAX_VALUE;
		int count = 0;
                int min = Integer.MAX_VALUE;
		for(int i=0;i<=n-m;i++)
                {
                    count = 0;
                    for(int j=0;j<m;j++)
                    {
                        if(x.charAt(j+i)!=y.charAt(j))
                        count++;
                    }
                    min = Math.min(min, count);
                    
                }

		
		return min;
	}
	public static void main(String[] args) throws IOException{
	
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String[] signatures;
	String line = "";
	while((line = in.readLine())!= null)
	{
		StringTokenizer x = new StringTokenizer(line);
		int n = Integer.parseInt(x.nextToken());
		int m = Integer.parseInt(x.nextToken());
		signatures = new String[n];
                for(int i=0;i<n;i++)
                    signatures[i] = in.readLine();
		
		for(int i=0;i<m;i++)
		{
			line = in.readLine();
			int pos = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<n;j++)
			{
				int output = Hamming(signatures[j],line);
				if(min>output)
				{
					min = output;
					pos = j;
				}
			}
			
			System.out.println(pos+1);
		}
	}
	
		
		in.close();
		System.exit(0);
	}
}