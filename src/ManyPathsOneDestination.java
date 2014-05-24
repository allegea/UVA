/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ManyPathsOneDestination {

	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	static int[] paths;
        static int[] topSort;
        static int Nts;
        
	
	public static void DFS(int u)
	{
            if(visited[u]) return;
            visited[u] = true;
		for(int v:nodes[u])
			DFS(v);
            
                topSort[Nts--] = u; 
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		ArrayList<Integer> deads;
                boolean first = true;
		while( (line = in.readLine()) != null)
		{
			int N = Integer.parseInt(line);
			if(N == 0) break;
			
                        if(!first)System.out.println();
                        first = false;
                        
			visited = new boolean[N];
			nodes = new ArrayList[N];
			paths = new int[N];
                        topSort = new int[N];
                        Nts = N-1;
			for(int i=0;i<N;i++)
			nodes[i] = new ArrayList<Integer>();
			deads = new ArrayList<Integer>();
			paths[0] = 1;
			for(int i=0;i<N;i++)
			{
				String[] read = in.readLine().split("[ ]+");
				int M = Integer.parseInt(read[0]);
				for(int j=0;j<M;j++)
				nodes[i].add(Integer.parseInt(read[j+1]));
				
				if(M == 0)deads.add(i);
			}
			
                        //System.out.println(Arrays.deepToString(nodes));
                        for(int i = 0;i<N;i++)
                            DFS(i);
                        
                        for(int i=0;i<N;i++)
                        {
                            for(int u:nodes[topSort[i]])
                                paths[u] += paths[topSort[i]];
                        }
			
			int answer = 0;
			for(int i:deads)
				if(visited[i])
					answer+=paths[i];
					
			System.out.println(answer);
			in.readLine();
			
		}
		
		in.close();
		System.exit(0);
	}
}