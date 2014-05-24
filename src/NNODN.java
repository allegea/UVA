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

class NNODN{

	static int n = 1000000+1;
	static int[] nod = new int[n];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                int M = Integer.parseInt(in.readLine());
                StringBuilder out = new StringBuilder();
		generateSolution();
		StringTokenizer r;
                
		for(int i=1;i<=M;i++)
		{
			r = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(r.nextToken());
			int b = Integer.parseInt(r.nextToken());
                        out.append("Case ").append(i).append(": ").append(nod[b]-nod[a-1]).append("\n");
		}
                System.out.print(out);
                in.close();
                System.exit(0);
	}
	
	public static int divisors(int x)
	{
	
		int answer = 1;
		for(int i=2;i*i<=x;i++)
		{
			int count = 0;
			while(x%i == 0)
			{
				count++;
				x/=i;
			}
			answer*=count+1;
		}
		if(x>1)answer*=2;
		return answer;
	
	}
	public static void generateSolution()
	{
		HashSet<Integer> visited = new HashSet<Integer>();
		int prev = 1;
		visited.add(prev);
		while(prev < n)
		{
			int div = divisors(prev);
			prev +=div;
			visited.add(prev);
		}
		
		for(int i=1;i<n;i++)
		{
			nod[i] = nod[i-1]+(visited.contains(i)?1:0);
		}
		
	}

}
