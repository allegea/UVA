/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class MonitoringTheAmazon {

	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	static int N;
	static Point2D.Float[] points;
	static int M;
	
	static int getNearest(int u)
	{
		int v = -1;
		if(nodes[u].size() > 0)
			v = nodes[u].get(0);
			
		double dist = Double.MAX_VALUE;
		int pos = -1;
		for(int i=0;i<N;i++)
		{
			if(v == i || i == u)continue;
			
			double d = points[u].distance(points[i]);
			if(d < dist)
			{
				dist = d;
				pos = i;
			}else if(d == dist)
			{
				if(points[i].x < points[pos].x) pos = i;
				else if(points[i].x == points[pos].x)
				{
					if(points[i].y < points[pos].y) pos = i;
				}
			}
		}
		return pos;
	}
	
	static void DFS(int u)
	{
		if(visited[u])return;
		visited[u] = true;
		M++;
		for(int v:nodes[u])
			DFS(v);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer read;
		while(true)
		{
			N = Integer.parseInt(in.readLine());
			if(N == 0)break;
			points = new Point2D.Float[N];
			nodes = new ArrayList[N];
			visited = new boolean[N];
			read = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)
			{
				nodes[i] = new ArrayList<Integer>();
				int x = Integer.parseInt(read.nextToken());
				int y = Integer.parseInt(read.nextToken());
				points[i] = new Point2D.Float(x, y);
			}
			
			for(int i=0;i<N;i++)
			{
				while(nodes[i].size() < 2)
				{
					int v = getNearest(i);
					nodes[i].add(v);
				}
			}
                        //System.out.println(Arrays.toString(nodes));
			
			M = 0;
			DFS(0);
			System.out.println(N == M?"All stations are reachable.":"There are stations that are unreachable.");
			
			
		}
		in.close();
		System.exit(0);
	}
}