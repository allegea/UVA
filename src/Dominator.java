/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Alejandro E. Garces
 */

public class Dominator {

	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
        static int notVisit;
	
	static void DFS(int u)
	{
		if(visited[u])return;
		visited[u] = true;
                if(notVisit == u)return;
		for(int v:nodes[u])
			DFS(v);
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(in.readLine());
		boolean[] visOri;
                int curr = 1;
		while(test-->0)
		{
			int N = Integer.parseInt(in.readLine());
			nodes = new ArrayList[N];
			visited = new boolean[N];
			visOri = new boolean[N];
			notVisit = -1;
			for(int i=0;i<N;i++)
			{	
				String[] read = in.readLine().split("[ ]+");
				nodes[i] = new ArrayList<Integer>();
				for(int j=0;j<read.length;j++)
					if(read[j].compareTo("1")==0)
						nodes[i].add(j);
			}
			
			DFS(0);
			String separate = "+";
                        String cas = "|";
			for(int i=0;i<N;i++)
			{ visOri[i] = visited[i];
			  separate += "--";
                          if(visited[i])
                            cas+= "Y|";
                          else cas+= "N|";
			}
                        
                                
			separate = separate.substring(0,separate.length()-1)+"+";
                        System.out.println("Case "+(curr++)+":\n"+separate);
                        System.out.println(cas);
			
			for(int i=1;i<N;i++)
			{
				//ArrayList<Integer> aux = new ArrayList<Integer>(nodes[i]);
				//nodes[i] = new ArrayList<Integer>();
				visited = new boolean[N];
                                notVisit  = i;
				DFS(0);
				System.out.println(separate);
				 cas = "|";
				//nodes[i] = new ArrayList<Integer>(aux);
				String pr = "N";
				for(int j=0;j<N;j++)
				{
					if(visOri[j] && i == j)
					pr = "Y";
					else if(visOri[j] && !visited[j])
					pr = "Y";
					else pr = "N";
					
					cas+= pr+"|";
				}
				System.out.println(cas);
				
			}
			System.out.println(separate);
			
		}
		in.close();
		System.exit(0);
	}
}