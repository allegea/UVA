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

public class SwitchBulbs {

	static class Bulb {
	
		int value;
		int dist;
		Bulb(int vv, int dd)
		{
			value = vv;
			dist = dd;
		}
	}
	static HashMap<Integer, Integer> answers;
	static int[] switches;
	static int n, m;
	static void BFS()
	{
		Queue<Bulb> q = new LinkedList<Bulb>();
		q.offer(new Bulb(0, 0));
		answers.put(0, 0);
		while(!q.isEmpty())
		{
			Bulb u = q.poll();
			for(int i = 0; i < m; i++)
			{
				int v = u.value^switches[i];
                                
				if(!answers.containsKey(v))
				{
                                   /* System.out.println(u.dist + " - "+Integer.toBinaryString(u.value)+" - "+u.value);
                                    System.out.println(u.dist + " - "+Integer.toBinaryString(switches[i])+" - "+switches[i]);
                                    System.out.println(u.dist + " V "+Integer.toBinaryString(v));*/
					answers.put(v, u.dist + 1);
					q.offer(new Bulb(v, u.dist + 1));
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer sT;
		for(int k = 1; k <= T; k++)
		{
			sT = new StringTokenizer(in.readLine());
			n = Integer.parseInt(sT.nextToken());
			m = Integer.parseInt(sT.nextToken());
			switches = new int[m];
                       // System.out.println(n + " - " + m);
			for(int i = 0; i < m; i++)
			{
				sT = new StringTokenizer(in.readLine());
				int mm = Integer.parseInt(sT.nextToken());
				for(int j = 0; j < mm; j++)
					//switches[i]|=1<<(n-1-Integer.parseInt(sT.nextToken()));
                                    switches[i]|=1<<(Integer.parseInt(sT.nextToken()));
			}
			answers = new HashMap<Integer, Integer>();
			BFS();
			System.out.println("Case "+k+":");
                       // System.out.println(Arrays.toString(switches));
			//System.out.println(answers);
			int q = Integer.parseInt(in.readLine());
			for(int i = 0; i < q; i++)
			{
				int key = Integer.parseInt(in.readLine(), 2);
                                //int key = Integer.parseInt(new StringBuilder(in.readLine()).reverse().toString(), 2);
                                //System.out.println(key+" - ");
				if(answers.containsKey(key))System.out.println(answers.get(key));
				else System.out.println(-1);
			}
			System.out.println();	
		}
		in.close();
		System.exit(0);
	}
} 