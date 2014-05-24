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
public class  WhereIsTheMarble1 {

     public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 int[] marbles;
                 int[] marblesSorted;
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
                        marblesSorted = new int[n];
			positions = new HashMap<Integer, Integer>();
                        
                        int max = 0;
			for(int i=0;i<n;i++){
                            marbles[i] = Integer.parseInt(in.readLine());
                            max = Math.max(max, marbles[i]);
                        }
                        int[] countSort = new int[max+2];
                        for(int i=0;i<n;i++)
                        {
                            countSort[marbles[i]+1]++;
                        }
                        //System.out.println(Arrays.toString(countSort));
                        for(int i=0;i<=max;i++)
                        {
                            countSort[i+1] +=countSort[i];
                        }
                       // System.out.println(Arrays.toString(countSort));
                        for(int i=0;i<n;i++)
                        {
                            marblesSorted[countSort[marbles[i]]++] = marbles[i];
                        }
                        //System.out.println(Arrays.toString(marblesSorted));
			//Arrays.sort(marbles);
			for(int i=n-1;i>=0;i--) positions.put(marblesSorted[i], i+1);
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
	