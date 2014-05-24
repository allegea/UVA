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
public class CountingCellsInABlob{

	public static char[][] grid;
	public static boolean[][] visited;
	public static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	public static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
	public static int N, M;
	public static boolean canGo(int i, int j)
	{
		return i >= 0 && i < N && j >= 0 && j < M && !visited[i][j] && grid[i][j] == '1';
	}
	
	public static int DFS(int i, int j)
	{
		if(!canGo(i, j))return 0;
		int count = 1;
		visited[i][j] = true;
		for(int h = 0; h < 8; h++)
			count+= DFS(i + dx[h], j + dy[h]);
			
		return count;
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		ArrayList<String> lines;
		
                boolean noFirst = false;
		while(n-- > 0)
		{
			in.readLine();
                        if(noFirst)System.out.println();
                        noFirst = true;
			lines = new ArrayList<String>();
			String line = in.readLine();
			/*while((line = in.readLine()).length() > 0)
				lines.add(line);*/
				
			N = line.length();
			//M = lines.get(0).length();
                        M = N;
                        
			grid = new char[N][M];
			visited = new boolean[N][M];
                        grid[0] = line.toCharArray();
			//System.out.println(N + " - " + M);
			for(int i = 1; i < N; i++)
				//grid[i] = lines.get(i).toCharArray();
                            grid[i] =in.readLine().toCharArray();
			
			int max = 0;
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if(!visited[i][j] && grid[i][j] == '1')
					max = Math.max(max, DFS(i, j));
			System.out.println(max);
				
		}
		in.close();
		System.exit(0);
	}

}
