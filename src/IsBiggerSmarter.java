/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Alejandro E. Garces
 */

public class  IsBiggerSmarter {

	public static class Elephant implements Comparable{
	
		int w;
		int q;
		int p;
		Elephant(int ww, int qq, int pp)
		{
			w = ww;
			q = qq;
			p = pp;
		}
		
		@Override
		public int compareTo(Object o)
		{
			return ((Elephant)o).q - this.q;
		}
		
		@Override
		public String toString()
		{
			return w+" "+q+" "+p;
		}

	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Elephant> input = new ArrayList<Elephant>();
		String line = "";
		int pos = 1;
		String[] read;
		while( (line = in.readLine()) != null && line.length() > 0)
		{
			read = line.split("[ ]+");
			input.add(new Elephant(Integer.parseInt(read[0]), Integer.parseInt(read[1]), pos++));
		}
			
		Collections.sort(input);
		int[] prev = new int[input.size()];
		Arrays.fill(prev, -1);
		int posMax = 0;
		int[] states = new int[input.size()];
		int maxG = 0;
                
               // for(Elephant x:input)
                //   System.out.println(x.toString());
                
		for(int i=0;i<input.size();i++)
		{
			int max = 0;
			for(int j=0;j<i;j++)
			{
				if(input.get(j).w < input.get(i).w)
					if(max < states[j])
					{
						prev[i] = j;
						max = states[j];
					}
			}
			
			states[i] = max + 1;
			if(states[i] > maxG)
			{
				maxG = states[i];
				posMax = i;
			}
		
		}
		
		
               // System.out.println(Arrays.toString(states));
                System.out.print(maxG);
		String answer = "\n"+input.get(posMax).p;
		int from = posMax;
		while(prev[from] != -1)
		{
			//System.out.println(prev[from]);
			answer = "\n"+input.get(prev[from]).p+answer;
			from = prev[from];
		}
		System.out.println(answer);
		
		in.close();
		System.exit(0);
	
	
	}
}