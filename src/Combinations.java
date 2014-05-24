/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Alejandro E. Garces
 */
public class Combinations{

	public static void main(String[] args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		
                BigInteger s = new BigInteger("1");
		int n = 100;
		int[][] binomial = new int[n+1][n+1];
		for(int i=0;i<=n;i++)
		{
			binomial[i][0] = binomial[i][i] = 1;
		}
		
		for(int i=1; i<=n;i++)
			for(int j=1; j<i; j++)
				binomial[i][j] = binomial[i-1][j] + binomial[i-1][j-1];
		while(true)
		{
                            String[] read = in.readLine().trim().split("[ ]+");
			int u = Integer.parseInt(read[0]);
			int v = Integer.parseInt(read[1]);
			if(u == 0 && v == 0)break;
			
			System.out.println(u+ " things taken "+v+" at a time is "+binomial[u][v]+" exactly.");
		}
		
		in.close();
		System.exit(0);
	}
	

}