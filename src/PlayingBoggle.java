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

public class PlayingBoggle{
	static char[][] grid;
	static int n = 4;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
	static boolean[][] visited;
	static String[] words;
        static int size= 0;
        static String goal;
        static int goalSize = 0;
	static boolean canGo(int i, int j, int pos)
	{
		return i>=0 && i<n && j>=0 && j<n && !visited[i][j] && grid[i][j] == goal.charAt(pos);
	}
	
	static int point(int length)
	{
		if(length == 3 || length == 4)return 1;
		if(length == 5)return 2;
		if(length == 6)return 3;
		if(length == 7)return 5;
		return 11;
	}
	
	static boolean DFS(int x, int y, String word, int length)
	{
                visited[x][y] = true;
                if(length == goalSize){
                    if(word.equals(goal))return true;
                    else return false;
                }
                boolean answer = false;
                for(int i=0;i<dx.length;i++)
                {
                    int u = x + dx[i];
                    int v = y + dy[i];
                    if(canGo(u, v, length))
                    answer|=DFS(u, v, word+""+grid[u][v], length +1);
                }
                visited[x][y] = false;
                return answer;
	
	}
        
	
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int curr = 0;
                int answer = 0;
		while(curr++<m)
		{
			
                        answer = 0;
			grid = new char[n][n];
			
			for(int i=0;i<n;i++)
                            grid[i] = in.next().toCharArray();
                        
			int nDic = in.nextInt();
                        words = new String[nDic];
			for(int i=0;i<nDic;i++)
                            words[i] = in.next();
                        
                        /*System.out.println("*********");
                        System.out.println(Arrays.toString(words));
                        System.out.println("*********");*/
                        
                        for(int k=0;k<nDic;k++)
                        {
                            boolean nextWord = false;
                            for(int i=0;i<n && !nextWord;i++)
				for(int j=0;j<n && !nextWord;j++)
                                    if(words[k].charAt(0) == grid[i][j])
                                    {
                                        visited = new boolean[n][n];
                                        goalSize = words[k].length();
                                        goal = words[k];
                                        if(DFS(i, j, ""+grid[i][j], 1))
                                        {  // System.out.println(goal);
                                            answer+=point(goalSize);
                                            nextWord = true;
                                        }
                                    }
                        }
   
			System.out.println("Score for Boggle game #"+curr+": "+answer);
			
		}
		in.close();
		System.exit(0);
	}
}