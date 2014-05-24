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
public class  AllWalksOfLengthNFromTheFirstNode {

	public static int[][] adj;
	public static int N, M;
	public static ArrayList<String> solutions;
	public static void BT(int curr, int visited, String sol, int size )
	{
                
		if(size == M)
			solutions.add(sol + ")");
		else{
			for(int i = 0; i < N; i ++)
				if(adj[curr][i] == 1 && ((1<<i) & visited) == 0)
				{
					visited|=1<<i;
					BT(i, visited, sol + "," + (i + 1), size + 1);
					visited^=1<<i;
				}
		}
	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringTokenizer st;
		boolean noFirst = false;
		while(( line = in.readLine() ) != null)
		{
                        
			if(noFirst)System.out.println();
                        noFirst = true;
                        if (line.equals("-9999")) line = in.readLine();
                        //in.readLine();
			st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			adj = new int[N][N];
			solutions = new ArrayList<String>();
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++)
					adj[i][j] = Integer.parseInt(st.nextToken());
			}
                        //if(M == 1)System.out.println("(1)");
                        //else
                        {
			BT(0, 1, "(1", 0);
			if(solutions.isEmpty())
				System.out.println("no walk of length " + M);
			else
				for(String x:solutions)
					System.out.println(x);
                        }
                        
		
		}
                System.exit(0);
                in.close();
	}

}