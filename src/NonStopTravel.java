/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class NonStopTravel
{
	public static class Edge implements Comparable{
		int v;
		int w;
		Edge(int v, int w)
		{
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Object o)
		{
			return this.w - ((Edge)o).w;
		}
	}
	
	public static void main(String[] args) throws IOException{
	
	//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         Scanner in = new Scanner(System.in);
	ArrayList<Edge>[] nodes;
	Queue<Edge> queue;
	int[] paths;
	int[] dists;
	int answer;
	int cases = 1;
	
	while(true)
	{
		int n = in.nextInt();
		if(n == 0)break;
		nodes = new ArrayList[10+1];
		queue = new PriorityQueue<Edge>();
		paths = new int[10+1];
		dists = new int[10+1];
		answer = 0;
		for(int i=0;i<=10;nodes[i++] = new ArrayList<Edge>());
		Arrays.fill(dists, Integer.MAX_VALUE);
		StringTokenizer read;
		for(int i=0;i<n;i++)
		{
			//read = new StringTokenizer(in.readLine());
			int m = in.nextInt();
			for(int j=0;j<m;j++)
			{
				int v = in.nextInt();
				int w = in.nextInt();
				nodes[i+1].add(new Edge(v,w));
			}
		}
		
		//read = new StringTokenizer(in.readLine());
		int x = in.nextInt();
		int y = in.nextInt();
		//paths[x] = x;
		dists[x] = 0;
		queue.offer(new Edge(x, 0));
		Edge aux;
		while(!queue.isEmpty())
		{
			aux = queue.poll();
                        //System.out.println(aux.v+" -- "+aux.w);
			if(aux.v == y)
			{
				answer = aux.w;
				break;
			}
			for(Edge u:nodes[aux.v])
			{
				if(dists[u.v] > dists[aux.v]+u.w)
				{
					dists[u.v] = dists[aux.v]+u.w;
					paths[u.v] = aux.v;
					queue.offer(new Edge(u.v, dists[u.v]));
				}
			}
			
		}
		String printPath = y+"";
                //System.out.println(Arrays.toString(paths));
                //System.out.println(Arrays.toString(dists));
		int yAux = y;
		while(paths[yAux]!=0)
		{
                        //System.out.println(paths[yAux]);
			printPath = paths[yAux]+" "+printPath;
			yAux = paths[yAux];
		}
		if(x == y)
                    printPath+=" "+y;
		System.out.println("Case "+cases+": Path = "+printPath+"; "+answer+" second delay");
		cases++;
		
		//in.readLine();
	}
	in.close();
	System.exit(0);
}
}
		
	