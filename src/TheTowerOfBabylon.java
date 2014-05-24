/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */

public class TheTowerOfBabylon{

	public static class Tower implements Comparable{
	
		int a;
		int b;
		int c;
		Tower(int aa, int bb, int cc)
		{
			a = aa;
			b = bb;
			c = cc;
		}
		
		@Override
		public int compareTo(Object o)
		{
			if(this.a != ((Tower)o).a) return this.a - ((Tower)o).a;
			if(this.b != ((Tower)o).b) return this.b - ((Tower)o).b;
			else return this.c - ((Tower)o).c;
		}
		
		@Override
		public String toString(){
			return a+" - "+b+" - "+c;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Tower[] numbers;
		int curr = 1;
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			int m = 0;
			numbers = new Tower[6*n];
			for(int i=0;i<n;i++)
			{
				String[] read = in.readLine().split("[ ]+");
				int a = Integer.parseInt(read[0]);
				int b = Integer.parseInt(read[1]);
				int c = Integer.parseInt(read[2]);
				numbers[m++] = new Tower(a, b, c);
				numbers[m++] = new Tower(a, c, b);
                                numbers[m++] = new Tower(b, a, c);
				numbers[m++] = new Tower(b, c, a);
                                numbers[m++] = new Tower(c, a, b);
				numbers[m++] = new Tower(c, b, a);
			}
		
                        
			Arrays.sort(numbers);
			n = m;
			int[] states = new int[n];
			int[] prev = new int[n];
			Arrays.fill(prev, -1);
			int maxG = -1;
			int posM = -1;
			for(int i=0;i<m;i++)
			{  // System.out.println(numbers[i].toString());
				//int max = 0;
                                states[i] = numbers[i].c;
				for(int j=0;j<i;j++)
					if((numbers[j].a < numbers[i].a && numbers[j].b < numbers[i].b) ||
					   (numbers[j].a < numbers[i].b && numbers[j].b < numbers[i].a))
					{
						prev[i] = j;
						states[i] = Math.max(states[i], states[j]+numbers[i].c);
                                               // max = Math.max(max, states[j]);
					}
					
				//states[i] = max + 1;
				if(states[i] >= maxG)
				{
					maxG = states[i];
					posM = i;
				}
			
			}
		
                        System.out.println("Case "+curr+": maximum height = "+maxG);
                        curr++;
                       /* int to = posM;
                        int answer = numbers[to].c;
                        while(prev[to]!=-1)
                        {
                            answer+=numbers[prev[to]].c;
                            to = prev[to];
                            
                        }
                        System.out.println(Arrays.toString(states));
			System.out.println(Arrays.toString(prev));
                        System.out.println(maxG+" - "+posM+" - "+answer+" *************");*/
		}
		
		in.close();
		System.exit(0);
	
	}

}