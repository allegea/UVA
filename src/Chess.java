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

public class Chess {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.next());
		//StringTokenizer read;
		while(t-->0)
		{
			//read = new StringTokenizer(in.nextLine());
			char ficha = in.next().charAt(0);
			int n = Integer.parseInt(in.next());
			int m = Integer.parseInt(in.next());
			if(ficha == 'k') System.out.println((int)Math.ceil(n*m/(float)2));
			else if(ficha == 'r') System.out.println(Math.min(n, m));
			else if(ficha == 'Q') System.out.println(Math.min(n, m));
			else{
                            if(n%2!=0)n++;
                            if(m%2!=0)m++;
                            System.out.println((n/2)*(m/2));
			}
			
		}
		in.close();
		System.exit(0);
	}
}