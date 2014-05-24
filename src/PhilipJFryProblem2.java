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

public class PhilipJFryProblem2{


	public static void main(String[] args) throws IOException{
	
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder();
	StringTokenizer r;
	int[] balls;
        int[] times;
        boolean[] used;
	
	while(true)
	{
		int n = Integer.parseInt(in.readLine());
		if(n == 0)break;
		balls = new int[n];
                times = new int[n];
                used = new boolean[n];
		for(int i=0;i<n;i++)
		{
			r = new StringTokenizer(in.readLine());
			times[i] = Integer.parseInt(r.nextToken());
                        balls[i] = Integer.parseInt(r.nextToken());
			
		}
		
		
		//System.out.println("-----");
		//for(int i=0;i<n;i++)System.out.println(times[i].toString());
                int j=n-1;
                while(j > 0)
                {
                    int max = -1;
                    int pos = -1;
                    boolean found = false;
                    for(int i=j;i>0;i--)
                    {
                        if(!used[i] && max < times[i])
                        {
                            max = times[i];
                            pos = i;
                        }
                        
                        if(balls[i-1] > 0 && pos!=-1)
                        {
                            balls[i-1]--;
                            found = true;
                            break;
                        }
                    }
                    
                    if(found)
                    {
                        used[pos] = true;
                        times[pos]/=2;
                        if(pos == j)j--;
                    }else break;
                    
                    /*System.out.println(Arrays.toString(times));
                    System.out.println(Arrays.toString(used));
                    System.out.println(pos+" - "+max);*/
                    
                }

		int answer = 0;
		for(int i=0;i<n;i++)
		answer+=times[i];
		out.append(answer).append("\n");
	}
	System.out.print(out);
	in.close();
	System.exit(0);
	}
}