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

public class RankTheLanguages	{

	static char[][] grid;
	static boolean[][] visited;
	static int n, m;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	static boolean canGo(int i, int j, char x)
	{
		return i>=0 && i<n && j>=0 && j<m && !visited[i][j] && grid[i][j] == x;
	}
	
	static void DFS(int i, int j, char x)
	{
		if(!canGo(i, j, x)) return;
		visited[i][j] = true;
		for(int ii=0;ii<dx.length;ii++)
			DFS(i+dx[ii], j+dy[ii], x);
	}
	
	static class Output implements Comparable<Output>{
	
		char x;
		int f;
		Output(char xx, int ff)
		{
			x = xx;
			f = ff;
		}
		
		@Override
		public int compareTo(Output o)
		{
			if(this.f != o.f) return o.f-this.f;
			return this.x - o.f;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		int curr = 0;
		int[] freq;
		ArrayList<Output> salida;
		while(curr++<t)
		{
			String[] read = in.readLine().split("[ ]+");
			n = Integer.parseInt(read[0]);
			m = Integer.parseInt(read[1]);
			grid = new char[n][m];
			freq = new int[26];
			visited = new boolean[n][m];
			salida = new ArrayList<Output>();
			
			for(int i=0;i<n;i++)
			grid[i] = in.readLine().toLowerCase().toCharArray();
			
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					if(!visited[i][j])
					{
						freq[grid[i][j]-'a']++;
						DFS(i, j, grid[i][j]);
					}
                        
                       // System.out.println(Arrays.toString(freq));
                                
			for(int i=0;i<26;i++)
				if(freq[i] != 0)
				salida.add(new Output((char)('a'+i), freq[i]));
				
			Collections.sort(salida);
			System.out.println("World #"+curr);
			for(Output x:salida)
				System.out.println(x.x+": "+x.f);
			
			
		}
		in.close();
		System.exit(0);
	}
}
