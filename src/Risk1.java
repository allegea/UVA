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

public class Risk1 {

        static ArrayList<Integer>[] nodes;
        static int N;
        static int BFS(int u, int v)
        {
            Queue<Integer> q = new LinkedList<Integer>();
            boolean[] visited = new boolean[N+1];
            visited[u] = true;
            int[] paths = new int[N+1];
            q.offer(u);
            while(!q.isEmpty())
            {
                int x = q.poll();
                if(x == v)return paths[v];
                //System.out.println(x+" - "+paths[x]);
                for(int y:nodes[x])
                {
                    if(!visited[y])
                    {
                        paths[y] = paths[x]+1;
                        visited[y] = true;
                        q.offer(y);
                    }
                }
                
            }
            return -1;
        }
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		String line = "";
                
                
		int t = 1;
		N = 20;
		while((line = in.readLine())!=null && line.length() > 0)
		{
			nodes = new ArrayList[N+1];
			for(int i=1;i<=N;i++)nodes[i] = new ArrayList<Integer>();
			
			
			for(int i=1;i<20;i++)
			{
				read = new StringTokenizer(line);
				int m = Integer.parseInt(read.nextToken());
				for(int j=0;j<m;j++)
				{
					int u = Integer.parseInt(read.nextToken());
                                        nodes[i].add(u);
                                        nodes[u].add(i);
					
				}
				line = in.readLine();
			}
                      
					
			System.out.println("Test Set #"+t);
			t++;
			int m = Integer.parseInt(line);
			for(int i=0;i<m;i++)
			{
				read = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(read.nextToken());
                                String uu = (u>=10)?""+u:" "+u;
                                
				int v = Integer.parseInt(read.nextToken());
                                String vv = (v>=10)?""+v:" "+v;
				//System.out.printf("%2d to %2d: %d\n",u,v,BFS(u, v));
                                System.out.println(uu+" to "+vv+": "+BFS(u, v));
			}
                        System.out.println();
		}
		in.close();
		System.exit(0);
        }
		
}
