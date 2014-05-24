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

public class Doublets{
	
	static HashMap<String, Integer> mapP;
	static ArrayList<String> names; 
	static int position(String x)
	{
		int n = mapP.size();
		if(mapP.containsKey(x))
			return mapP.get(x);
		
		mapP.put(x, n);
		return n;
	}
	
	public static String BFS(String x, String y)
	{
               // System.out.println(x+" - "+y);
		if(x.length() != y.length())return "No solution.";
		int n = mapP.size();
		int[] prev = new int[n];
		Arrays.fill(prev, -1);
		int xx = position(x);
		int yy = position(y);
		boolean[] visited = new boolean[n];
		visited[xx] = true;
		Queue<Integer> q = new LinkedList<Integer>();
                q.offer(xx);
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			if(u == yy)
			break;
			String uu = names.get(u);
                       // System.out.println(uu+" - "+u);
			int size = uu.length();
			for(int i=0;i<size;i++)
			{
				char[] aux = uu.toCharArray();
				for(char j='a';j<='z';j++)
				{
					aux[i] = j;
					String vv = String.valueOf(aux);
                                        //System.out.println(vv);
					if(mapP.containsKey(vv))
					{
						int v = position(vv);
						if(!visited[v])
						{
							//System.out.println("Add "+vv);
							visited[v] = true;
							prev[v] = u;
							q.offer(v);
						}
					}
				}
			}
			
			
		
		}
		
		if(!visited[yy])
		return "No solution.";
		
		String answer = y;
		int to = yy;
               // System.out.println(Arrays.toString(prev)+" - "+yy);
		while( prev[to] != -1)
		{       
                        //System.out.println(prev[to] + " - "+to);
			answer = names.get(prev[to])+"\n"+answer;
			to = prev[to];
		}
                //System.out.println("Answer "+answer+" ----");
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		mapP = new HashMap<String, Integer>();
		names = new ArrayList<String>();
		while((line = in.readLine()) != null && line.length()>0)
		{
			names.add(line);
			position(line);
		}
		
               // System.out.println(line);
		//System.out.println(mapP);
		
		boolean first = true;
		while((line = in.readLine()) != null && line.length()>0)
		{
			String[] read = line.split("[ ]+");
			if(!first)System.out.println();
                        first = false;
			System.out.println(BFS(read[0], read[1]));
			
		}
		in.close();
		System.exit(0);
	}
}