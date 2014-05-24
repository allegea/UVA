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

public class SwitchTheLights {

	static int[] switches;
	static int N, M;
	
	static int BFS()
	{
		//HashSet<Integer> visited = new HashSet<Integer>();
		//HashMap<Integer, Integer> path = new HashMap<Integer, Integer>();
		int start = (1<<N)-1;
                boolean[] visited = new boolean[start+1];
                int[] dist = new int[start+1];
                visited[start] = true;
               
		//path.put(start, 0);
		//visited.add(start);
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		while(!q.isEmpty())
		{
			int x = q.poll();
                        if(x == 0)return dist[x];
			//if(x == 0)return path.get(x);
			
			for(int i=0;i<M;i++)
			{
				int y = x;
				y^=switches[i];
                                if(!visited[y])
                                {
                                    dist[y] = dist[x]+1;
                                    visited[y] = true;
                                    q.offer(y);
                                    
                                }
				/*if(visited.add(y))
				{
					int w = path.get(x);
					path.put(y, w+1);
					q.offer(y);
				}*/
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		StringBuilder numbers;
		int t = Integer.parseInt(in.readLine());
		int curr = 1;
		while(t-->0)
		{
			read = new StringTokenizer(in.readLine());
			N = Integer.parseInt(read.nextToken());
			M = Integer.parseInt(read.nextToken());
			switches = new int[M];
			for(int i=0;i<M;i++)
			{
				read = new StringTokenizer(in.readLine());
				numbers = new StringBuilder();
				for(int j=0;j<N;j++)
                                {
                                    //int value = Integer.parseInt(read.nextToken());
                                    if(read.nextToken().charAt(0) == '1')
                                    switches[i]|= 1<<j;
                                    
                                }
				//numbers.append(read.nextToken());
				//System.out.println(numbers);
				//switches[i] = Integer.parseInt(numbers.toString(), 2);
			}
			int answer = BFS();
			System.out.println("Case "+curr+": "+(answer!=-1?answer:"IMPOSSIBLE"));
			curr++;
			}
		in.close();
		System.exit(0);
        }
}