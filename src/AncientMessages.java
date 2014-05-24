

import java.io.*;
import java.util.*;

public class AncientMessages{
	public static int N, M;
	public static char[][] grid;
	public static boolean[][] visited;
	public static final char[] hieroglyph = "WAKJSD".toCharArray();
        public static int[] dx = {0, -1, 0, 1};
        public static int[] dy = {1, 0, -1, 0};
	
        public static boolean canGo(int i, int j)
        {
            return i >= 0 && i < N && j >= 0 && j < M*4 && !visited[i][j];
        }
       
        public static void DFSMarkBlanksStack(int i, int j)
        {
            Stack<Integer> sX = new Stack<Integer>();
            Stack<Integer> sY = new Stack<Integer>();
            visited[i][j] = true;
            sX.push(i);
            sY.push(j);
            while(!sX.isEmpty())
            {
                i = sX.pop();
                j = sY.pop();
                for(int h = 0; h < dx.length; h++)
                {
                    int x = i + dx[h];
                    int y = j + dy[h];
                    if(canGo(x, y) && grid[x][y] == '0')
                    {
                        visited[x][y] = true;
                        sX.push(x);
                        sY.push(y);
                    }
                }
            }
            
        }
        public static int DFSBlacks(int i, int j) {
       
             if(!canGo(i, j))return 0;
             int count = 0;
             visited[i][j] = true;
              if(grid[i][j] == '0'){
                  DFSMarkBlanksStack(i, j);
                  count = 1;
              }else
                  for(int h = 0; h < dx.length;h++)
                     count += DFSBlacks(i + dx[h], j + dy[h]);
              
              return count;
         }
        public static void FillBackGround()
        {
            for(int i = 0; i < N; i++)
                if(grid[i][0] == '0')
             DFSMarkBlanksStack(i, 0);
            for(int i = 0; i < N; i++)
                if(grid[i][M*4 - 1] == '0')
             DFSMarkBlanksStack(i, M*4 - 1);
            for(int i = 0; i < M*4 - 1; i++)
                if(grid[0][i] == '0')
             DFSMarkBlanksStack(0, i);
            for(int i = 0; i < M*4 - 1; i++)
                if(grid[N-1][i] == '0')
             DFSMarkBlanksStack(N - 1, i);

        }
	public static String solve()
        {
            ArrayList<Character> answer = new ArrayList<Character>();
            FillBackGround();
            
            for(int i = 0; i < N; i++)
                for(int j = 0; j < M*4; j++)
                    if(grid[i][j] == '1' && !visited[i][j])
                        answer.add(hieroglyph[DFSBlacks(i, j)]);

            char[] sort = new char[answer.size()];
            int pos = 0;
            for(char c:answer)
                sort[pos++] = c;
            
            Arrays.sort(sort);
            
            return String.valueOf(sort);
        }
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cases = 1;
		String padded = "0000";
		StringBuilder sB;
		while(true)
		{
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0)break;
			grid = new char[N][M*4];
                        visited = new boolean[N][M*4];

			for(int i = 0; i < N; i++)
			{
				String line = in.readLine();
				sB = new StringBuilder("");
				for(int j = 0; j < M; j++)
				{
					String digits = Integer.toBinaryString(Integer.parseInt(""+line.charAt(j), 16));
					sB.append(padded.substring(digits.length()) + digits);
				}
                                
				grid[i] = sB.toString().toCharArray();
				
			}
			System.out.println("Case " + cases + ": " + solve());
			cases++;
		}
		in.close();
		System.exit(0);
	}
}