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
public class Trainsorting{
	 public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] LIS;
		int[] LDS;
		int[] numbers;
		int answer;
		while(n-->0)
		{
			int m = Integer.parseInt(in.readLine());
			LIS = new int[m];
			LDS = new int[m];
			numbers = new int[m];
			answer = 0;
			for(int i=0;i<m;i++)
				numbers[i] = Integer.parseInt(in.readLine());
				
			for(int i=m-1; i>=0;i--)
			{
				int maxI = 0;
				int maxD = 0;
				for(int j=m-1;j>i;j--)
				{	if(numbers[j]<numbers[i])
					maxI = Math.max(maxI, LIS[j]);
					if(numbers[j]>numbers[i])
					maxD = Math.max(maxD, LDS[j]);
				}
				LIS[i] = maxI+1;
				LDS[i] = maxD+1;
				answer = Math.max(answer, LIS[i]+LDS[i]-1);
			
			}
			/*System.out.println(Arrays.toString(LIS));
			System.out.println(Arrays.toString(LDS));*/
			System.out.println(answer);
		}
		in.close();
		System.exit(0);
	}

}