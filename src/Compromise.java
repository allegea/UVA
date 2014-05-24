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

public class Compromise{

	static ArrayList<String> a, b;
	static int n, m;
	static ArrayList<Integer>[][] dp;
	static ArrayList<Integer> solve(int i, int j)
	{
		if(i == n || j == m) return dp[i][j] = new ArrayList<Integer>();
		if(dp[i][j] != null)return dp[i][j];
		//System.out.println(i + " - "+j);
		ArrayList<Integer> aux = new ArrayList<Integer>();
		ArrayList<Integer> aux1 = new ArrayList<Integer>();
		ArrayList<Integer> aux2 = new ArrayList<Integer>();
		if(a.get(i).equals(b.get(j))){
			aux.add(i);
			aux.addAll(solve(i + 1, j + 1));
		}else{
			aux1.addAll(solve(i + 1, j));
			aux2.addAll(solve(i, j + 1));
			
			if(aux1.size() >= aux2.size())
				aux = aux1;
			else aux = aux2;
		}
		
		return dp[i][j] = aux;
	}
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		String line = "";
		StringBuilder output;
		
		while(in.hasNext())
		{
			output = new StringBuilder();
			 a = new ArrayList<String>();
			 b = new ArrayList<String>();
			 
			 while(!(line  = in.next()).equals("#"))a.add(line);
			 
			 while(!(line  = in.next()).equals("#"))b.add(line);
			
			n = a.size();
			m = b.size();
			//System.out.println(a);
                        //System.out.println(b);
			dp = new ArrayList[n + 1][m + 1];
			
			ArrayList<Integer> pos = solve(0, 0);
                        //System.out.println("POS - " + pos);
			int l = pos.size();
			int i = 0;
			for(int x:pos)
			{
				if(i++ == l -1)	output.append(a.get(x)).append("\n");
                                else output.append(a.get(x)).append(" ");
			}
			
			
			System.out.print(output);
			
		}
		
		in.close();
		System.exit(0);
		
	}
}