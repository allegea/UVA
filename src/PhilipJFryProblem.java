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

public class PhilipJFryProblem{

static class Pair implements Comparable<Pair>
{
	int p;
	int value;
	Pair(int pp, int vv)
	{
		p = pp;
		value = vv;
	}
	
	void divide()
	{
		value/=2;
	}
	
	@Override
	public int compareTo(Pair o)
	{
		return o.value-this.value;
	}
	
	@Override
	public String toString()
	{
		return value+" - "+p;
	}
}	
	public static void main(String[] args) throws IOException{
	
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder();
	StringTokenizer r;
	int[] balls;
	Pair[] times;
	int amount;
	int prev;
	while(true)
	{
		int n = Integer.parseInt(in.readLine());
		if(n == 0)break;
		times = new Pair[n];
		balls = new int[n];
		prev = amount = 0;
		for(int i=0;i<n;i++)
		{
			amount+=prev;
			balls[i] = amount;
			r = new StringTokenizer(in.readLine());
			times[i] = new Pair(i, Integer.parseInt(r.nextToken()));
			prev = Integer.parseInt(r.nextToken());
			
		}
		
		//for(int i=0;i<n;i++)System.out.println(times[i].toString());
		Arrays.sort(times);
		//System.out.println("-----");
		//for(int i=0;i<n;i++)System.out.println(times[i].toString());
		for(int i=0;i<n && amount>0;i++)
		{
			int pos = times[i].p;
			if(balls[pos] > 0)
			{
				times[i].divide();
				amount--;
				for(int j=pos;j<n;j++)balls[j]--;
			}
		}
		
		int answer = 0;
		for(int i=0;i<n;i++)
		answer+=times[i].value;
		out.append(answer).append("\n");
	}
	System.out.print(out);
	in.close();
	System.exit(0);
	}
}