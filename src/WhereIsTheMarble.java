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
public class  WhereIsTheMarble {

     public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 int[] marbles;
		 HashMap<Integer, Integer> positions;
		 int n, m;
		 StringTokenizer r;
		 int cases = 1;
		 StringBuilder output = new StringBuilder();
		 while(true)
		 {
			r = new StringTokenizer(in.readLine());
			n = Integer.parseInt(r.nextToken());
			m = Integer.parseInt(r.nextToken());
			if(n == 0 && m == 0)break;
			marbles = new int[n];
			positions = new HashMap<Integer, Integer>();
			for(int i=0;i<n;i++)marbles[i] = Integer.parseInt(in.readLine());
			Arrays.sort(marbles);
			for(int i=n-1;i>=0;i--) positions.put(marbles[i], i+1);
			output.append("CASE# ").append(cases++).append(":").append("\n");
			for(int i=0;i<m;i++)
			{
				n = Integer.parseInt(in.readLine());
				if(positions.containsKey(n))output.append(n).append(" found at ").append(positions.get(n)).append("\n");
				else output.append(n).append(" not found").append("\n");
			}
			
		 }
		 System.out.print(output);
		 in.close();
		 System.exit(0);
	}
}	
	