/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.math.BigInteger;

/**
 *
 * @author Alejandro E. Garces
 */
public class PascalTriangleOfDeath {

	public static void main(String[] args) throws IOException{
		//BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 205;
		BigInteger[][] pascalT = new BigInteger[n+1][n+1];
		BigInteger limit = BigInteger.TEN;
		limit = limit.pow(60);
                System.out.println(limit.toString());
		System.out.println("1");
		boolean nofound = true;
                //int count = 0;
		for(int i=1; i<=n && nofound;i++)
		{
			pascalT[i][0] = BigInteger.ONE;
			pascalT[i][i] = BigInteger.ONE;
			System.out.print("1");
                       // count++;
			for(int j=1; j<i;j++)
			{
				pascalT[i][j] = BigInteger.ZERO;
				pascalT[i][j] = pascalT[i-1][j].add(pascalT[i-1][j-1]);
				System.out.print(" "+pascalT[i][j].toString());
				if(pascalT[i][j].compareTo(limit)>=0)
					nofound = false;
			}
			System.out.println(" 1");
		}

		//System.out.println(count);
		//in.close();
		System.exit(0);
	}
	

}