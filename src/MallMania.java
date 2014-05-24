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
 */hfg

public class MallMania {

	static HashSet<String> visited;
	static HashMap<String, Integer> paths;
	static HashSet<String> goal;
	static Queue<Integer> qX;
	static Queue<Integer> qY;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int BFS()
	{
		while(!qX.isEmpty())
		{
			int x = qX.poll();
			int y = qY.poll();
			if(goal.contains(x+"|"+y))
			{
				return paths.get(x+"|"+y);
			}
			
			for(int i=0;i<dx.length;i++)
			{
				int u = x+dx[i];
				int v = y+dy[i];
				if(visited.add(u+"|"+v))
				{
					qX.offer(u);
					qY.offer(v);
					paths.put(u+"|"+v, paths.get(x+"|"+y)+1);
				}
			}
		
		}
                return 0;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		while(true)
		{
			int n = in.nextInt();
			if(n == 0)break;
			
			paths = new HashMap<String, Integer>();
			visited = new HashSet<String>();
			goal = new HashSet<String>();
			qX = new LinkedList<Integer>();
			qY = new LinkedList<Integer>();
			for(int i=0;i<n;i++)
			{
				int x = in.nextInt();
				int y = in.nextInt();
				visited.add(x+"|"+y);
				paths.put(x+"|"+y, 0);
				qX.offer(x);
				qY.offer(y);
			}
			
			int m = in.nextInt();
			for(int i=0;i<m;i++)
			{
				int x = in.nextInt();
				int y = in.nextInt();
				goal.add(x+"|"+y);
			}
			System.out.println(BFS());
		}
		in.close();
		System.exit(0);
	}
}