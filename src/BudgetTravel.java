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
public class BudgetTravel {

	public static Gas[] nodes;
	public static int N;
	public static long capacity, veloc;
	public static long MIN = Long.MAX_VALUE;
	public static class Gas {
		long pos;
		long cost;
		Gas(long p, long c)
		{
			pos = p;
			cost = c;
		}
		
		public String toString()
		{
			return pos + " - " + cost;
		}
	}
	
	public static void BT(int curr, long prevPos, long cost, long capac)
	{
		if(curr == N)
		{
			System.out.println("MIN - " + MIN + " - " + cost);
			MIN = Math.min(MIN, cost);
		}else{
		
			for(int i = curr + 1; i <= N; i++)
			{
			        long dist = nodes[i].pos - prevPos;
				long canGo = capac * veloc;
				System.out.println("A - " + i + " - "  + dist + " - " +prevPos + " - " + capac + " - " + veloc + " - "+ canGo + " - " + cost);
				if(canGo < dist)break;
				long currCap = canGo - dist;
				long galons = currCap / veloc;
				long newCapa = capac - galons;
				long currCost = 200 + cost;
				System.out.println("B  - " + currCap + " - " + galons + " - " + newCapa + " - " + currCost);
				if(newCapa * 2 <=  capacity)
				{
					currCost += (capacity - newCapa) *  nodes[i].cost;
					newCapa = capacity;
				}
				System.out.println("C  - " + currCap + " - " + galons + " - " + newCapa + " - " + currCost);
				BT(i, nodes[i].pos, currCost, newCapa);
				
			}
		}
	}fdsf

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int cases = 1;
		StringTokenizer st;
		while( true )
		{
			long start = (long) (Float.parseFloat(in.readLine()) * 100);
			if(start == -100)break;
			st = new StringTokenizer(in.readLine());
			
			 capacity = (long) (Float.parseFloat(st.nextToken()) * 100);
			 veloc = (long) (Float.parseFloat(st.nextToken()) * 100);
			long costIni = (long) (Float.parseFloat(st.nextToken()) * 100);
			N = Integer.parseInt(st.nextToken());
			nodes = new Gas[N + 1];
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(in.readLine());
				long pos = (long) (Float.parseFloat(st.nextToken()) * 100);
				long cost =  (long) (Float.parseFloat(st.nextToken()) * 100);
				nodes[i] = new Gas(pos, cost);
			}
			nodes[N] = new Gas(start, 0);
			 MIN = Long.MAX_VALUE;
			System.out.println(Arrays.toString(nodes));
			BT(-1, 0, costIni, capacity);
			
			System.out.println("Data Set #" + cases++);
			System.out.println("minimum cost = $" + MIN/100 + "." + MIN%100);
		}
	}
}