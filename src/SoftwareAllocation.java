/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */
public class SoftwareAllocation {

        static int N;
	static int[][] capacity;
	static int[][] flow;
	static boolean[] visited;
	static int[] paths;
	static ArrayList<Integer>[] nodes;
        static int source, sink;
	
	static int BFSAugPaths(int source, int sink){
	
		Arrays.fill(visited, false);
		Arrays.fill(paths, -1);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(source);
		visited[source] = true;
		boolean found = false;
		while(!queue.isEmpty())
		{
			int u = queue.poll();
			if(u == sink)
			{
				found = true;
				break;
			}
			for(int v:nodes[u])
			{
				//if(!visited[v] && (capacity[u][v]-flow[u][v] > 0))
                            if(!visited[v] && (capacity[u][v]> 0))
				{
					visited[v] = true;
					paths[v] = u;
					queue.offer(v);
				}
			}
		
		}
		
		if(!found)return -1;
		
		int incre = Integer.MAX_VALUE;
		int to = sink;
                int from = 0;
                String pat = sink+"";
		while(paths[to] != -1)
		{
                        from = paths[to];
			//incre = Math.min(incre, capacity[from][to]-flow[from][to]);
                        incre = Math.min(incre, capacity[from][to]);
                        pat = from+"-"+pat;
			to = from;
		}
                //System.out.println(pat);
		to = sink;
		while(paths[to] != -1)
		{
                        from = paths[to];
			/*flow[from][to]+=incre;
			flow[to][from]-=incre;*/
                        capacity[from][to]-=incre;
			capacity[to][from]+=incre;
			to = from;
		}
                /*System.out.println(Arrays.toString(paths));
                System.out.println(Arrays.deepToString(flow));*/
		
		return incre;
		
	}
	
	static int MaxFlow(int source, int sink){
		int answer = 0;
		int fromBFS = 0;
		while( ( fromBFS = BFSAugPaths(source, sink)) > 0 ){
		answer+=fromBFS;
               // System.out.println(fromBFS);
                }
		return answer;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
                N = 38;
                source = 0;
                sink = 37;
                int toAssign = 0;
                int indexPCs = 27; // source + 0..25 characters
		while( (line = in.readLine())!=null /*&& line.length() > 0*/)
		{
                        nodes = new ArrayList[N];
                        toAssign = 0;
			for(int i=0;i<N;i++)nodes[i] = new ArrayList<Integer>();
			capacity = new int[N+1][N+1];
			visited = new boolean[N+1];
			paths = new int[N+1];
			flow = new int[N+1][N+1];
                        String[] read;
                        while(line!=null&&!line.equals(""))
                        {
                        //do{
                            read = line.split("[ ]+");
                            int letter = read[0].charAt(0)-'A'+1;
                            int cap = Integer.parseInt(read[0].substring(1, read[0].length()));
                            nodes[source].add(letter);
                            capacity[source][letter] = cap;
                            toAssign += cap;
                            for(int i=0;i<read[1].length()-1;i++)
                            {
                                
                                int v = indexPCs +(read[1].charAt(i)-'0');
                                nodes[letter].add(v);
                                if(!nodes[v].contains(sink))nodes[v].add(sink);
                                
                                capacity[letter][v] = capacity[v][sink] = 1;
                               // System.out.println(letter+" - "+cap+" - "+v);
                            }
                            line = in.readLine();
                       // }while( (line = in.readLine())!=null && line.length()>0);
                        }
		
                       /* for(int i=0;i<N;i++)
                            System.out.println(nodes[i]);
                       
                        for(int i=0;i<N;i++)
                        System.out.println(Arrays.toString(capacity[i]));
			//System.out.println(MaxFlow(source, sink)+" - "+toAssign);
                        for(int i=0;i<N;i++)
                        System.out.println(Arrays.toString(capacity[i]));*/
                        String answer = "";
                        if(MaxFlow(source, sink) == toAssign){
                        for(int i=indexPCs;i<N-1;i++){
                            boolean assig = false;
                            for(int j=1; j<indexPCs;j++)
                                if(capacity[i][j] == 1)
                                {   
                                    //System.out.print((char)((j-1)+'A'));
                                    answer+= (char)((j-1)+'A');
                                    assig = true;
                                    break;
                                }
                            if(!assig)
                                answer+="_";
                        }
                        }else answer = "!";
                        
                        System.out.println(answer);
                            
                        
			
		}
		in.close();
		System.exit(0);
	}

}
/*
Q1 5;
P4 56789;
A4 01234;

A4 01234;
Q1 5;
P5 56789;

A4 01234;
Q1 5;
P5 56789;
* 
*/