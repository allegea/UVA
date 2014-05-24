/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */

public class MonkeysInARegularForest {

	static char[][] grid;
	static int[][] families;
	static boolean[][] visited;
	static int[] digits;
	static int n;
	static int m;
        static final int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        static StringBuilder out;
	
	static int digits(int x)
	{
		int answer = 0;
		while(x!=0)
		{	
			answer++;
			x/=10;
		}
		return answer;
	}
	
	static boolean canMark(int i, int j, char c)
	{
                //System.out.println(i+" - "+j+" - "+c+" -");
		return i>=0 && i<n && j>=0 && j<m && !visited[i][j] && grid[i][j] == c;
	}
	
	static void DFS(int i, int j, char c, int d, int x)
	{
		if(!canMark(i, j, c))return;
               // System.out.println(i+" - "+j+" - "+c+" - "+x);
		visited[i][j] = true;
		families[i][j] = x;
		digits[j] = Math.max(digits[j], d);
		for(int ii=0;ii<dx.length;ii++)
			DFS(i+dx[ii], j+dy[ii], c, d, x);
	}
	
        static void addSpaces(int spaces, String value)
        {
            int n = spaces-value.length();
            for(int i=0;i<n;i++)
                out.append(" ");
            out.append(value);
            
        }
	static void print()
	{
             out = new StringBuilder();
		for(int i=0;i<n;i++)
                {   addSpaces(digits[0], String.valueOf(families[i][0])); 
                    for(int j=1;j<m;j++)
                        addSpaces(digits[j]+1, String.valueOf(families[i][j]));
                       
                      out.append("\n");
                    
                }
                out.append("%");
                System.out.println(out);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		ArrayList<String> read;
		while( (line = in.readLine()) != null && line.length() > 0)
		{
			read = new ArrayList<String>();
			read.add(line);
			while((line = in.readLine()) != null && line.length() > 0)
			{
				
				if(line.charAt(0) == '%')break;
				read.add(line);
			}
			
			n = read.size();
			String[] dates = read.get(0).split("[ ]+");
			m = dates.length;
                        //System.out.println(n+" - "+m);
			grid = new char[n][m];
			families = new int[n][m];
			visited = new boolean[n][m];
			digits = new int[m];
			for(int i=0;i<n;i++)
			{
				dates = read.get(i).split("[ ]+");
                                //System.out.println(Arrays.toString(dates));
				for(int j=0;j<m;j++)
				grid[i][j] = dates[j].charAt(0);
			}
			
			int count = 1;
			for(int i=0;i<n;i++)
			   for(int j=0;j<m;j++)
				if(!visited[i][j])
                                {       //System.out.println(i+" - "+j);
                                    
					DFS(i, j, grid[i][j], digits(count), count++);
                                }
				
			print();
		}
		in.close();
		System.exit(0);
	}
}
