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

class ErrorCorrection{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n;
		StringTokenizer read;
		while((n = Integer.parseInt(in.readLine())) != 0)
		{
			int[][] nums = new int[n][n];
			int[] col = new int[n];
			int[] row = new int[n];
			for(int i=0;i<n;i++)
			{
				read = new StringTokenizer(in.readLine());
				for(int j=0;j<n;j++)
					nums[i][j] = Integer.parseInt(read.nextToken());
			}
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				{	
					row[i] = row[i]^nums[i][j];
					col[i] = col[i]^nums[j][i];
				}
				
			int posI = -1, posJ = -1, countI = 0, countJ = 0;
			
			for(int i=0;i<n && countI < 2 && countJ < 2;i++)
			{
				if(row[i]!=0){
				countI++;
				posI = i;
				}
				
				if(col[i] != 0){
				countJ++;
				posJ = i;
				}
			}
			
			if(countI == 0 && countJ == 0)System.out.println("OK");
			else if(countI == 1 && countJ == 1) System.out.println("Change bit ("+(posI+1)+","+(posJ+1)+")");
			else System.out.println("Corrupt");
			
		}
		in.close();
		System.exit(0);
	
	}

}