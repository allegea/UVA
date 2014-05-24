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
public class ThetaPuzzle{

	static class Pair{
	
		String x;
		char y;
		Pair(String xx, char yy)
		{
			x = xx;
			y = yy;
		}
	}
	
	static Queue<String> q;
	static HashMap<String, Pair> paths;
	static final String goal = "ABCDEF ";
	static final int n = 7;
	static final int front = 1;
	static final int end = 4;
	static void swap(char[] x, int i, int j)
	{
		char aux = x[i];
                x[i] = x[j];
                x[j] = aux;
	}
	static void addNew(char[] curr, int pos, String from)
	{
		String newValue = String.valueOf(curr);
			if(!paths.containsKey(newValue))
			{
                                //System.out.println(newValue+"-" +  curr[pos] + " - From - "+from);
				q.offer(newValue);
				paths.put(newValue, new Pair(from, curr[pos]));
			}
	}
	static void addToQueue(String x)
	{
		char[] curr = x.toCharArray();
		int blank = 0;
		for(int i = 0; i < n; i++)
			if(curr[i] == ' ')
			{
				blank = i;
				break;
			}
               // System.out.println(blank);
                        
		if(blank != 6)
		{
			int a = (blank + 1)%(n - 1); 
			swap(curr, blank, a);
			addNew(curr, blank, x);
			
			curr = x.toCharArray();
			a = (blank - 1 +( n - 1))%(n - 1); 
			swap(curr, blank, a);
			addNew(curr, blank, x);
                        
                        if(blank == front || blank == end)
                        {
                           curr = x.toCharArray();
                            swap(curr, blank, 6);
                            addNew(curr, blank, x);
                        }
		}else{
			swap(curr, blank, front);
			addNew(curr, blank, x);
			
			curr = x.toCharArray();
			swap(curr, blank, end);
			addNew(curr, blank, x);
		}
		
		
	}
	static String BFS(String start)
	{
		q = new LinkedList<String>();
		paths = new HashMap<String, Pair>();
                start+=" ";
                paths.put(start, new Pair("", ' '));
		q.offer(start);
		while(!q.isEmpty())
		{
			String u = q.poll();
                        //System.out.println("**"+u+"**");
			if(u.equals(goal))
			{
				String answer = "";
				while(paths.containsKey(u))
				{
                                   // System.out.println("|"+u+"|");
                                            
					Pair path = paths.get(u);
					answer = path.y + answer;
					u = path.x;
                                }
				return (answer.length() - 1)+"" +answer;
				
			}
                        addToQueue(u);
			
			
		}
		
		return "NO SOLUTION";
	}
	
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.next().trim());
		for(int h = 1; h <= n; h++)
		{
			int set = Integer.parseInt(in.next().trim());
			String start = in.next().trim();
                        //System.out.println("*** "+line);
			System.out.println(set + " "+BFS(start));
		}
		in.close();
		System.exit(0);
	}
}