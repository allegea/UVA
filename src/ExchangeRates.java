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

public class ExchangeRates {

	static class Edge{
		
		int uValue;
		int v;
		int vValue;
		Edge(int u, int vv, int vVV)
		{
			uValue = u;
			v = vv;
			vValue = vVV;
		}
		@Override
		public String toString()
		{
			return uValue+" - "+v+" - "+vValue;
		}
		
	}
	static HashMap<String, Integer> mapNames;
	static ArrayList<ArrayList<Edge>> nodes;
	static boolean newNode;
	static ArrayList<String> names;
	
	static int position(String name)
	{
		newNode = false;
		if(mapNames.containsKey(name))
		return mapNames.get(name);
		int n = mapNames.size();
		newNode = true;
		mapNames.put(name, n);
		names.add(name);
		nodes.add(n, new ArrayList<Edge>());
		return n;
	}
	static int[] BFS(int i, int j)
	{
		int n = mapNames.size();
		boolean[] visited = new boolean[n];
		int[] uRate = new int[n];
		int[] vRate = new int[n];
		uRate[i] = 1;
		vRate[i] = 1;
		visited[i] = true;
		
		int[] out = {-1, -1};
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		while(!q.isEmpty())
		{
			int u = q.poll();
			if(u == j)
			{
				out[0] = uRate[u];
				out[1] = vRate[u];
				break;
			}
			
			for(Edge x:nodes.get(u))
			{
				if(!visited[x.v])
				{
					visited[x.v] = true;
					uRate[x.v] = uRate[u]*x.uValue;
					vRate[x.v] = vRate[u]*x.vValue;
					q.offer(x.v);
				}
			}
		}
		
		return out;
		
	}
	
	static int GCD(int a, int b)
	{
		if(b == 0)return a;
		return GCD(b, a%b);
	}
  

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		mapNames = new HashMap<String, Integer>();
		nodes = new ArrayList<ArrayList<Edge>>();
		String line = "";
		String[] read;
		names = new ArrayList<String>();
		int[] answer;
		while((line = in.readLine()) != null && line.length() > 0 && line.charAt(0) != '.')
		{
			 read = line.trim().split("[ ]+");
			 if(read[0].charAt(0) == '!')
			 {
				int uV = Integer.parseInt(read[1]);
				int vV = Integer.parseInt(read[4]);
				int gcd = GCD(uV, vV);
				uV/=gcd;
				vV/=gcd;
				String uName = read[2].toLowerCase();
				String vName = read[5].toLowerCase();
				int u = position(uName);
				int v = position(vName);
				nodes.get(u).add(new Edge(uV, v, vV));
				nodes.get(v).add(new Edge(vV, u, uV));
				
				
			 }else
			 {
                                //for(int i=0;i<nodes.size();i++)
                                   // System.out.println(nodes.get(i).toString());
				String uName = read[1].toLowerCase();
				String vName = read[3].toLowerCase();
				int u = position(uName);
				int v = position(vName);
				answer = BFS(u, v);
				if(answer[0] != -1)
				{
					int gcd = GCD(answer[0], answer[1]);
					answer[0]/=gcd;
					answer[1]/=gcd;
					System.out.println(answer[0]+" "+uName+" = "+answer[1]+" "+vName);
					//nodes.get(u).add(new Edge(answer[0], v, answer[1]));
					//nodes.get(v).add(new Edge(answer[1], u, answer[0]));
				}else System.out.println("? "+uName+" = ? "+vName);
				
			 }
		}
		in.close();
		System.exit(0);
		}
}
