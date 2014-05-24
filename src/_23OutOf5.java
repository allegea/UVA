/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */

public class _23OutOf5 {

	static boolean[] visited;
	static int[] numbers;
	static boolean answer;
	
	static void BT(int acum, int cant)
	{
		if(cant == 5 && acum == 23)answer = true;
		if(answer)return;
		for(int i=0;i<numbers.length;i++)
		if(!visited[i])
		{
			visited[i] = true;
			BT(acum + numbers[i], cant + 1);
			BT(acum - numbers[i], cant + 1);
			BT(acum * numbers[i], cant + 1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		String[] read;
		int n = 5;
		boolean finish;
		while(true)
		{
			read = in.readLine().split("[ ]+");
			visited = new boolean[n];
			numbers = new int[n];
			finish = true;
                        answer = false;
			for(int i=0;i<n;i++){
				numbers[i] = Integer.parseInt(read[i]);
				if(numbers[i] != 0)
				finish = false;
			}
			
			if(finish)break;
			
			for(int i=0;i<n;i++){
				visited[i] = true;
				BT(numbers[i], 1);
				visited[i] = false;
			}
			
			System.out.println(answer?"Possible":"Impossible");
            
		}
		in.close();
		System.exit(0);
	}
	
}