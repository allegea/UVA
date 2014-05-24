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

public class LEDTest {

	static char[][] display;
	static char[][] input;
	static boolean findS; 
	static int n;
	
	static boolean match(int iD, int iI)
	{
               // System.out.println(iI+ " - "+iD);
		for(int i=0;i<7;i++)
			if(input[iI][i] == 'Y' && display[iD][i] != 'Y')
			return false;
		//System.out.println(iI+ " - "+iD+" - TRUE");
                return true;
	}
	
	static void BT(int ii, int jj)
	{
		if(ii == n)
		{
                       // System.out.println("FIND");
			findS = true;
			return;
		}
		if(findS || jj < 0)return;
		
		//for(int i=jj;i>=0;i--)
			if(match(jj, ii))
                            BT(ii+1, jj-1);
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                display = new char[10][7];
		display[0] = "YYYYYYN".toCharArray();
		display[1] = "NYYNNNN".toCharArray();
		display[2] = "YYNYYNY".toCharArray();
		display[3] = "YYYYNNY".toCharArray();
		display[4] = "NYYNNYY".toCharArray();
		display[5] = "YNYYNYY".toCharArray();
		display[6] = "YNYYYYY".toCharArray();
		display[7] = "YYYNNNN".toCharArray();
		display[8] = "YYYYYYY".toCharArray();
		display[9] = "YYYYNYY".toCharArray();
		while(true)
		{
			n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			findS = false;
			input = new char[n][7];
			for(int i=0;i<n;i++)
                        {
                            char aux
                            input[i] = in.readLine().toCharArray();
                        }
                        for(int i=9;i>=(n-1) && !findS;i--)
			BT(0, i);
			System.out.println(findS?"MATCH":"MISMATCH");
		}
		in.close();
		System.exit(0);
	}

}