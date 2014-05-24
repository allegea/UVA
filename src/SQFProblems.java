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
public class SQFProblems {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		
		HashSet<String>[] categories;
                HashSet<String>[] visited;
		int[] minRequired;
		int[] founded;
		String[] names;
		
		StringTokenizer st;
		
		while(cases-- > 0)
		{
			int N = Integer.parseInt(in.readLine());
			categories = new HashSet[N];
                        visited = new HashSet[N];
			minRequired = new int[N];
			founded = new int[N];
			names = new String[N];
			
			for(int i = 0; i < N; i++)
			{	categories[i] = new HashSet<String>();
                                visited[i] = new HashSet<String>();
				st = new StringTokenizer(in.readLine());
				names[i] = st.nextToken();
				int M = Integer.parseInt(st.nextToken());
				minRequired[i] = Integer.parseInt(st.nextToken());
				for(int j = 0; j < M; j++)
					categories[i].add(in.readLine());
			}
			
			String line = "";
			while(( line = in.readLine()) != null && line.length() > 0)
			{
                               // line = line.replaceAll("[^a-zA-z]"," ");
                                 line = line.replaceAll("[^\\w]"," ");
                                 line = line.replaceAll("[0-9]"," ");
                                //System.out.println(line);
				st = new StringTokenizer(line);
				while(st.hasMoreTokens())
				{
					line = st.nextToken();
					for(int i = 0; i < N; i++)
						if(categories[i].contains(line))
                                                if(visited[i].add(line))
							founded[i]++;
				}
			}
			
			String answer = "";
			for(int i = 0; i < N; i++)
			{
				if(founded[i] >= minRequired[i])
				{
					if(answer.length() > 0)
					answer+=",";
					answer+=names[i];
				}
			}
			
			if(answer.length() == 0)answer = "SQF Problem.";
			System.out.println(answer);
			
		}
	
		in.close();
		System.exit(0);
	}
}