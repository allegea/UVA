/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Beverages{

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> mapName;
                ArrayList<Integer>[] nodes;
                Queue<Integer> queue;
		String[] names;
		String line = "";
                boolean[] visited;
                int[] inDegree;
		int currC = 1;
		while((line = in.readLine()) != null)
		{
			int n = Integer.parseInt(line);
			int pos = 0;
			names = new String[n];
                        mapName = new HashMap<String, Integer>();
                        nodes = new ArrayList[n];
                        queue = new PriorityQueue<Integer>();
                        inDegree = new int[n];
                        visited = new boolean[n];
                        
			for(int i=0;i<n;i++)
			{
				line = in.readLine();
				mapName.put(line, pos);
				names[pos++] = line;
				nodes[i] = new ArrayList<Integer>();
			}
			
			int m = Integer.parseInt(in.readLine());
			for(int i=0;i<m;i++)
			{
				String[] read = in.readLine().split("[ ]+");
				int u = mapName.get(read[0]);
				int v = mapName.get(read[1]);
				nodes[u].add(v);
                                inDegree[v]++;
			}
			
			for(int i=0;i<n;i++)
                            if(inDegree[i] == 0)
                                queue.offer(i);
			
			String answer = "Case #"+currC+": Dilbert should drink beverages in this order:";
			currC++;
			String drinks = "";
                        while(!queue.isEmpty())
                        {
                            int u = queue.poll();
                            drinks+= " "+names[u];
                            visited[u] = true;
                            for(int v:nodes[u])
                            {
                                if(visited[v])continue;
                                inDegree[v]--;
                                if(inDegree[v] == 0)
                                    queue.offer(v);
                            }
                        }
			
			
			System.out.println(answer+drinks+".\n");
                        in.readLine();
			
		}
		in.close();
		System.exit(0);
		
	}

}

/*
public class Beverages{

	static int N;
	static int[] topSort;
	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	static void DFS(int u)
	{
		visited[u] = true;
		for(int i:nodes[u])
			if(!visited[i])
				DFS(i);
		topSort[N--] = u;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> mapName;
		String[] names;
		String line = "";
                int[] inDegree;
		int currC = 0;
		while((line = in.readLine()) != null)
		{
			int n = Integer.parseInt(line);
			int pos = 0;
			names = new String[n];
			nodes = new ArrayList[n];
			visited = new boolean[n];
			topSort = new int[n];
                        mapName = new HashMap<String, Integer>();
			N = n-1;
			for(int i=0;i<n;i++)
			{
				line = in.readLine();
				mapName.put(line, pos);
				names[pos++] = line;
				nodes[i] = new ArrayList<Integer>();
			}
			
			int m = Integer.parseInt(in.readLine());
			for(int i=0;i<m;i++)
			{
				String[] read = in.readLine().split("[ ]+");
				int u = mapName.get(read[0]);
				int v = mapName.get(read[1]);
				nodes[u].add(v);
			}
			
			for(int i=0;i<n;i++)
				if(!visited[i])
					DFS(i);
			
			String answer = "Case #"+currC+": Dilbert should drink beverages in this order:";
			currC++;
			String drinks = "";
			for(int i=0;i<n;i++)
				drinks+= " "+names[topSort[i]];
			
			System.out.println(answer+drinks+"\n");
                        in.readLine();
			
		}
		in.close();
		System.exit(0);
		
	}

}*/