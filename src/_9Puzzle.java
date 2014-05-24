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

public class _9Puzzle {

	static int answer;
	static String goal = "123456789";
	static HashSet<String> visited;
        static HashMap<String, Integer> mapM;
        static HashMap<String, String> mapS;
	static String BFS(String x)
	{
		Queue<String> grid = new LinkedList<String>();
		Queue<Integer> dist = new LinkedList<Integer>();
		Queue<String> moves = new LinkedList<String>();
		visited = new HashSet<String>();
		grid.offer(x);
		dist.offer(0);
		moves.offer("");
		visited.add(x);
		while(!grid.isEmpty())
		{
			String xx = grid.poll();
			int d = dist.poll();
			String mov = moves.poll();
			if(xx.equals(goal))
			{
                            //System.out.println("*************");
				answer = d;
				return mov;
			}
			
			for(int i=0;i<3;i++)
			{
				char[] aux = xx.toCharArray();
				int row = 3*i;
				char a = aux[row+2];
				for(int j=1;j>=0;j--)
				aux[row+j+1]=aux[row+j];
				aux[row] = a;
				
				String newS = String.valueOf(aux);
				//System.out.println(newS);
				if(visited.add(newS))
				{
					grid.offer(newS);
					dist.offer(d+1);
					moves.offer(mov+"H"+(i+1));
				}
				
			}
			for(int i=0;i<3;i++)
			{
				char[] aux = xx.toCharArray();
                                char a = aux[i];
				//char a = aux[i+6];
				for(int j=0;j<2;j++)
				aux[i+(j*3)]=aux[i+(j+1)*3];
				aux[i+6] = a;
				
				String newS = String.valueOf(aux);
				//System.out.println(newS);
				if(visited.add(newS))
				{
					grid.offer(newS);
					dist.offer(d+1);
					moves.offer(mov+"V"+(i+1));
				}
			}
		}
                return "";
	}
	
        static void BFS2()
	{
		Queue<String> grid = new LinkedList<String>();
		Queue<Integer> dist = new LinkedList<Integer>();
		Queue<String> moves = new LinkedList<String>();
		visited = new HashSet<String>();
                mapM = new HashMap<String, Integer>();
                mapM.put(goal, 0);
                mapS = new HashMap<String, String>();
                mapS.put(goal, "");
		grid.offer(goal);
		dist.offer(0);
		moves.offer("");
		visited.add(goal);
		while(!grid.isEmpty())
		{
			String xx = grid.poll();
			int d = dist.poll();
			String mov = moves.poll();
			/*if(xx.equals(goal))
			{
                            //System.out.println("*************");
				answer = d;
				return mov;
			}*/
			
			for(int i=2;i>=0;i--)
			{
				char[] aux = xx.toCharArray();
				int row = 3*i;
				char a = aux[row];
				for(int j=0;j<2;j++)
				aux[row+j]=aux[row+j+1];
				aux[row+2] = a;
				
				String newS = String.valueOf(aux);
				//System.out.println(newS);
				if(visited.add(newS))
				{
					grid.offer(newS);
					dist.offer(d+1);
					moves.offer(mov+"H"+(i+1));
                                        mapM.put(newS, d+1);
                                        mapS.put(newS,mov+ "H"+(i+1));
				}
				
			}
			for(int i=2;i>=0;i--)
			{
				char[] aux = xx.toCharArray();
                                //char a = aux[i];
				char a = aux[i+6];
				for(int j=1;j>=0;j--)
				aux[i+(j+1)*3]=aux[i+j*3];
				aux[i] = a;
				
				String newS = String.valueOf(aux);
				//System.out.println(newS);
				if(visited.add(newS))
				{
					grid.offer(newS);
					dist.offer(d+1);
					moves.offer(mov+"V"+(i+1));
                                        
                                        mapM.put(newS, d+1);
                                        mapS.put(newS,mov+ "V"+(i+1));
				}
			}
		}
                System.out.println(visited.size());
                System.out.println(mapS.size());
                System.out.println(mapM.size());
	}
        
	public static void main(String[] args) throws IOException{
	Scanner in = new Scanner(System.in);
        BFS2();
	while(true)
	{
		String read = "";
		int n = in.nextInt();
		if(n == 0)break;
		read+=""+n;
		for(int i=0;i<8;i++)
		read+=""+in.nextInt();
		answer = -1;
                
                //String x = BFS(read);
                if(visited.contains(read))
                {
                    char[] get = mapS.get(read).toCharArray();
                    String out = "";
                   // System.out.println(String.valueOf(get));
                    for(int i=0;i<get.length;i+=2)
                        out= get[i]+""+get[i+1]+""+out;
                    
                    System.out.println(mapM.get(read)+" "+out);
                    
                }else System.out.println("Not solvable");
		
	}
	in.close();
	System.exit(0);
	}
}