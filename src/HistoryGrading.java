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

public class HistoryGrading  {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//int cases = Integer.parseInt(in.readLine());
		int[] numbers;
		int[] positions;
		int[] states;
		int[] x;
		//while(true)
		{
			
			N = Integer.parseInt(in.readLine());
			numbers = new int[N+1];
			states = new int[N+1];
			positions = new int[N+1];
			String[] read = in.readLine().split("[ ]+");
			for(int i=0;i<N;i++)
			{
					//numbers[i] = 
                                        numbers[Integer.parseInt(read[i])-1] = i;
					//positions[numbers[i]] = i;
                                       // System.out.println(read[i]+" - "+ numbers[i]+" - "+position[numbers[i]]);
			}
                        for(int i=0;i<N;i++)
                                positions[numbers[i]] = i;
                       // System.out.println(Arrays.toString(numbers));
			//System.out.println(Arrays.toString(positions));
			String line = "";
			while((line = in.readLine()) != null)
			{
				states = new int[N+1];
				x = new int[N+1];
				read = line.split("[ ]+");
				for(int i=0;i<N;i++){
                                    	x[Integer.parseInt(read[i])-1] = i;
                                }
				
                                int answer = 0;
                               // System.out.println(Arrays.toString(x));
				for(int i=0;i<N;i++)
				{
					int max = 0;
					for(int j=0;j<i;j++)
						if(positions[x[i]] > positions[x[j]])
							max = Math.max(max, states[j]);
					
					states[i] = 1+max;
                                        answer = Math.max(states[i], answer);
				}
                        // System.out.println(Arrays.toString(states));
			System.out.println(answer);
			}
			
		}
		in.close();
		System.exit(0);
	}
}