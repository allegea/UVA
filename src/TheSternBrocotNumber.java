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

public class TheSternBrocotNumber {

	public static class Frac{
		
		long n, m;
		Frac(long nn, long mm)
		{
			n = nn;
			m = mm;
		}
                @Override
                public String toString()
                {
                    return n + "/"+m;
                }
	}
	public static StringBuilder answer;
	
	public static void BS(Frac value, Frac L, Frac M, Frac R)
	{
		long x = value.n * M.m;
		long y = value.m * M.n;
		if(x == y)return;
		if(y > x)
		{
			R.n = M.n;
                        R.m = M.m;
			answer.append("L");
		}else{
			L.n = M.n;
                        L.m = M.m;
			answer.append("R");
		}
		M.n = L.n + R.n;
		M.m = L.m + R.m;
                //System.out.println(L + " - "+ M + " - " + R);
		BS(value, L, M, R);
	
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                
                System.out.println(8<<0xfffffffe);
		while(true)
		{
			answer  = new StringBuilder();
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x == 1 && y == 1)break;
			BS(new Frac(x, y), new Frac(0, 1), new Frac(1, 1), new Frac(1, 0));
			System.out.println(answer);
		}
		
	}
}