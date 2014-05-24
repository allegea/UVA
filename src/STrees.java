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
public class STrees {

   public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] values, input;
		int[] order;
		int n, m;
		StringTokenizer r;
		int cases = 1;
		while(true)
		{
			n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			m = 1<<n;
			order = new int[n];
			r = new StringTokenizer(in.readLine());
			for(int i=0;i<n;i++)order[i] = r.nextToken().charAt(1)-'1';
                        
			values = in.readLine().toCharArray();
			int queries = Integer.parseInt(in.readLine());
			String answer = "";
			for(int i=0;i<queries;i++)
			{
				input = in.readLine().toCharArray();
				int pos = 1;
				for(int j=0;j<n;j++)
					pos=pos*2 + (input[order[j]]-'0');
				pos%=m;
				answer+=values[pos];
			}
			
			System.out.println("S-Tree #"+(cases++)+":");
			System.out.println(answer+"\n");
			
		}
         in.close();
         System.exit(0);
     }
}
