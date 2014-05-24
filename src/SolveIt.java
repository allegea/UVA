/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class SolveIt{
	public static final double EPS = 1e-9;
        public static final double EPS2 = 1e-5;
	public static double evaluate(int p, int q, int r, int s, int t, int u, double x)
	{
            return p * Math.exp(-x) + q * Math.sin(x) + r * Math.cos(x) + s * Math.tan(x) + t * (x * x) + u; 
	 
	}
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringTokenizer st;
		while((line = in.readLine()) != null)
		{
			st = new StringTokenizer(line);
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			boolean found = false;
			double L = 0.0;
			double R = 1.0;
			double Mid = 0.0;
                        double y = 0;
                        	double a = evaluate(p, q, r, s, t, u, L);
                                double b = evaluate(p, q, r, s, t, u, R);

                                if (a * b > EPS)
                                System.out.println("No solution");
                                else if (Math.abs(a) < EPS)
                                System.out.printf(Locale.ENGLISH, "0.0000\n");
                                else if (Math.abs(b) < EPS)
                                System.out.printf(Locale.ENGLISH, "1.0000\n");
                                else
                                {
			while(L  + EPS < R && !found)
			{
				Mid = (L + R)/2.0;
                                y = evaluate(p, q, r, s, t, u, Mid);
                               // System.out.println(L + " - " + Mid + " - " + R + " - " + y);
				if(Math.abs(y) < EPS2) found = true;
				else if(y < EPS2) R = Mid;
                                else L = Mid;
			}
			
			if(found)System.out.printf("%.4f\n", Mid);
			else System.out.println("No solution");
                                }
		}
	
	}
} 