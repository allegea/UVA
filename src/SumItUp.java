/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Alejandro E. Garces
 */

public class SumItUp {

	static int sum;
	static int n;
	static int[] numbers;
	static boolean[] visited;
	static HashSet<String> toPrint;
        static ArrayList<String> out;
	
        /*static class PrintSum implements Comparable<PrintSum>{
            
            int[] num;
            PrintSum(int[] nn)
            {
                num = new int[nn.length];
                for(int i=0;i<nn.length;i++)
                    num[i] = nn[i];
            }
            
        }*/
	static void backtracking(int currentSum, int[] output, int pos, int j)
	{
		if(currentSum > sum)return;
		if(currentSum == sum)
		{
                        int[] aux = new int[pos];
                        for(int i=0;i<pos;i++)
                            aux[i] = output[i];
                        Arrays.sort(aux);
                        String toString = aux[pos-1]+"";
                        for(int i = pos-2;i>=0;i--)
                            toString+="+"+aux[i];
			if(toPrint.add(toString))
			System.out.println(toString);
			return;
		}
		
		for(int i=j;i<n;i++)
			if(!visited[i])
			{
				visited[i] = true;
                                output[pos] = numbers[i];
				backtracking(currentSum+numbers[i], output, pos+1, j+1);
                                output[pos] = -1;
				visited[i] = false;
			}
	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		String[] read;
		while(true)
		{
			read = in.readLine().split("[ ]+");
			sum = Integer.parseInt(read[0]);
			n = Integer.parseInt(read[1]);
			if(sum == 0)break;
			
			toPrint = new HashSet<String>();
			visited = new boolean[n];
			numbers = new int[n];
                        out = new ArrayList<String>();
                        int[] aux = new int[n];
			for(int i=0;i<n;i++)
				numbers[i] = Integer.parseInt(read[i+2]);
			
			System.out.println("Sums of "+sum+":");
                        Arrays.fill(aux, -1);
			backtracking(0, aux, 0, 0);
			if(toPrint.isEmpty())
			System.out.println("NONE");
                        
                        //System.out.println("sss");
		}
		in.close();
		System.exit(0);
	}
}