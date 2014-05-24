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

public class Argus{

	static class Query implements Comparable<Query>{
		int id;
		long value;
		long curr;
		Query(int i, long v, long c)
		{
			id = i;
			value = v;
			curr = c;
		}
		@Override
		public int compareTo(Query o)
		{
			if(this.curr != o.curr)
                        {
                            if(this.curr<o.curr)return -1;
                            else return 1;
                        }
                        else return this.id-o.id;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Query> q = new PriorityQueue<Query>();
		String[] read;
		while(true)
		{
			read = in.readLine().split("[ ]+");
			if(read[0].charAt(0) == '#') break;
			int id = Integer.parseInt(read[1]);
			long value = Long.parseLong(read[2]);
			q.offer(new Query(id, value, value));
		}
		int k = Integer.parseInt(in.readLine());
		while(k-->0)
		{
			Query aux = q.poll();
			System.out.println(aux.id);
			q.offer(new Query(aux.id, aux.value, aux.curr+aux.value));
		}
		in.close();
		System.exit(0);
	}
}