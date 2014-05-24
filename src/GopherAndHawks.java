/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */
public class GopherAndHawks{

	static boolean[] visited;
	static ArrayList<Point2D.Float> nodes;
	static int n;
	static int BFS(int speed, long time)
	{
		visited = new boolean[n];
                int[] dist = new int[n];
		Queue<Integer> qP = new LinkedList<Integer>();
		visited[0] = true;
		qP.offer(0);
		while(!qP.isEmpty())
		{
			int u = qP.poll();
			if(u == 1)
			return dist[u]-1;
			for(int i=1;i<n;i++)
			{
				if(visited[i])continue;
				double dista = nodes.get(u).distance(nodes.get(i));
				if(dista/speed<=time)
				{
					visited[i] = true;
					qP.offer(i);
					dist[i] = dist[u]+1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] read = in.readLine().split("[ ]+");
			int s = Integer.parseInt(read[0]);
			long t = Long.parseLong(read[1])*60;
			if(s==0 && t==0)break;
			nodes = new ArrayList<Point2D.Float>();
			String line = "";
			while((line = in.readLine().trim())!=null && line.length()>4)
			{
                            
                                //System.out.println("** "+line);
				read = line.split("[ ]+");
				float x = Float.parseFloat(read[0]);
				float y = Float.parseFloat(read[1]);
				nodes.add(new Point2D.Float(x, y));
			}
			n = nodes.size();
			int answer = BFS(s, t);
			System.out.println(answer>=0?"Yes, visiting "+answer+" other holes.":"No.");
			
		}
		in.close();
		System.exit(0);
	}
}

/*
 * 3 1
0.000 0.000
500.000 0.000
179.000 0.000
358.000 0.000
 
5 1
0.000 0.000
0.000 550.000
179.000 0.000
0.000 301.000 

0 0
 */