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

public class KnightsInFEN{

	static String goal = "111110111100 110000100000";
	static HashSet<String> visited;
        static HashMap<String, Integer> solutions;
	static int[] dx = {-1, 1, -2, -2, -1, 1, 2, 2};
	static int[] dy = {2, 2, 1, -1, -2, -2, 1, -1};
	static int max = 10;
	
	static boolean canGo(int i, int j)
	{
		return i>=0 && i<5 && j>=0 && j<5; 
	}
	
	
        static int BFS(String a) //Solved on time 1.040
	{
		Queue<Integer> qX = new LinkedList<Integer>();
		Queue<Integer> qY = new LinkedList<Integer>();
		Queue<String> b = new LinkedList<String>();
		Queue<Integer> moves = new LinkedList<Integer>();
                visited = new HashSet<String>();
		visited.add(a);
		b.offer(a);
		moves.offer(0);
		int pos = a.indexOf(" ");
		qX.offer(pos/5);
		qY.offer(pos%5);
                

               // System.out.println(a);
               // System.out.println(goal);
		while(!qX.isEmpty())
		{
			String bb = b.poll();
			int x = qX.poll();
			int y = qY.poll();
			int m = moves.poll();
			
                      //  System.out.println(bb+" - "+x+" - "+y+" - "+m);
                        
			if(bb.equals(goal))
			return m;
			
			if(m == max)continue;
			int t = x*5+y;
			for(int i=0;i<dx.length;i++)
			{
				int u = x+dx[i];
				int v = y+dy[i];
				if(canGo(u, v))
				{
					char[] aux = bb.toCharArray();
					int q = u*5+v;
					char o = aux[t];
					aux[t] = aux[q];
					aux[q] = o;
					String result = String.valueOf(aux);
					//System.out.println(result);
					if(visited.add(result))
					{
						b.offer(result);
						moves.offer(m+1);
						qX.offer(u);
						qY.offer(v);
                                                
						
					}
				}
			}
		}
		
		return -1;
                
	}
        
        static void BFS2() //Solved 0.404!!!!!!!!!!!!!!!!!!!!
	{
		Queue<Integer> qX = new LinkedList<Integer>();
		Queue<Integer> qY = new LinkedList<Integer>();
		Queue<String> b = new LinkedList<String>();
		Queue<Integer> moves = new LinkedList<Integer>();
                visited = new HashSet<String>();
		visited.add(goal);
		b.offer(goal);
		moves.offer(0);
		int pos = goal.indexOf(" ");
		qX.offer(pos/5);
		qY.offer(pos%5);
                solutions = new HashMap<String, Integer>();
                solutions.put(goal, 0);

               // System.out.println(a);
               // System.out.println(goal);
		while(!qX.isEmpty())
		{
			String bb = b.poll();
			int x = qX.poll();
			int y = qY.poll();
			int m = moves.poll();
			
			if(m == max)continue;
			int t = x*5+y;
			for(int i=0;i<dx.length;i++)
			{
				int u = x+dx[i];
				int v = y+dy[i];
				if(canGo(u, v))
				{
					char[] aux = bb.toCharArray();
					int q = u*5+v;
					char o = aux[t];
					aux[t] = aux[q];
					aux[q] = o;
					String result = String.valueOf(aux);
					//System.out.println(result);
					if(visited.add(result))
					{
						b.offer(result);
						moves.offer(m+1);
						qX.offer(u);
						qY.offer(v);
                                                solutions.put(result, m+1);
						
					}
				}
			}
		}
		
		//System.out.println(solutions.size());
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                BFS2();
		int n = Integer.parseInt(in.readLine());
		while(n-->0)
		{
			String x = "";
			for(int i=0;i<5;i++)
			x+=in.readLine();
                        
                        System.out.println(solutions.containsKey(x)?"Solvable in "+solutions.get(x)+" move(s).":"Unsolvable in less than 11 move(s).");
			/*int answer = BFS(x);
			System.out.println(answer>=0?"Solvable in "+answer+" move(s).":"Unsolvable in less than 11 move(s).");*/
		}
		in.close();
		System.exit(0);
	}

}