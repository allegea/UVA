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

class LunchInGridCity {

	
	
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
                int[] x;
                int[] y;
		while(cases-->0)
		{
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
                        x = new int[k];
                        y = new int[k];
			for(int i=0;i<k;i++)
                        {
                            x[i] = in.nextInt();
                            y[i] = in.nextInt();
                        }
			Arrays.sort(x);
                        Arrays.sort(y);
                        if(k%2 == 0) System.out.println("(Street: "+x[k/2-1]+", Avenue: "+y[k/2-1]+")");
                        else System.out.println("(Street: "+x[k/2]+", Avenue: "+y[k/2]+")");
                       // else System.out.println(coord[k/2].toString());
		}
		in.close();
		System.exit(0);
	}
}