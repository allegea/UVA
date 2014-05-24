/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */

public class StringPopping {

	static boolean answer;
	
	static void BT(StringBuilder x)
	{
		//System.out.println("** "+x);
                        
		if(answer)return;
		int n = x.length();
		for(int i=0;i<n;i++)
		{
			int l = i;
			char w = x.charAt(i);
			while((++i)<n)
				if(x.charAt(i) != w)
					break;
                       // System.out.println(l+" - "+i);
			if(i-l>1)
			{
				if(i-l == n)
				{	answer = true;
                                        //System.out.println("TRUE");
					return;
				}
				StringBuilder toGo = new StringBuilder(x.substring(0,l)).append(x.substring(i));
				//System.out.println(toGo);
				BT(toGo);
			}
                        i--;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int tests = Integer.parseInt(in.readLine());
		while(tests-->0)
		{
			line = in.readLine().trim();
			answer = false;
			BT(new StringBuilder(line));
			System.out.println(answer?"1":"0");
            
		}
                StringBuilder x;
                
		in.close();
		System.exit(0);
	}
	
}