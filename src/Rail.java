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

class Rail {

	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] values = new int[10002];
		for(int i=0;i<10002;i++)
			values[i] = i+1;
		
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			while(true)
			{
				Stack<Integer> st = new Stack<Integer>();
				int[] numbers = new int[n];
				StringTokenizer tokens = new StringTokenizer(in.readLine());
				numbers[0] = Integer.parseInt(tokens.nextToken());
				if(numbers[0] == 0)break;
				for(int i=1;i<n;i++)
					numbers[i] = Integer.parseInt(tokens.nextToken());
					
				int i=0, j=0;
                               // System.out.println(Arrays.toString(numbers));
				while(i<n)
				{
                                    if(st.isEmpty()){
                                        st.push(values[j++]);
                                        continue;
                                    }
                                    if(st.peek() != numbers[i])
                                        while(j<n && st.peek() != numbers[i])st.push(values[j++]);
                                   
                                   // System.out.println(i+" - "+j+" - "+st);
                                    if(st.pop() != numbers[i++])break;

				}
                                
                                System.out.println((i==n?"Yes":"No"));
					
			}
			System.out.println();
		}
		in.close();
		System.exit(0);
	}
}