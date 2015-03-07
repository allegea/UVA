/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.io.*;

public class FourValuesWhoseSumIsZero {

	public static void main (String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		while (cases-- > 0) {
			in.readLine();
			int n = Integer.parseInt(in.readLine());
			int[] a = new int[n];
			int[] b = new int[n];
			int[] c = new int[n];
			Map<Integer, Integer> d = new HashMap<Integer, Integer>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
				int aux = Integer.parseInt(st.nextToken());
				Integer freq = d.get(aux);
				if (freq == null) {
					freq = 0;
				}
				d.put(aux, ++freq);
			}
			long answer = 0;
			for(int i = 0; i < n; i++)
			{
				int u = a[i];
				for(int j = 0; j < n; j++) {
					int sum = u + b[j];
					for(int h = 0; h < n; h++) {
						int v = sum + c[h];
						if (d.containsKey(-v)) {
							answer += d.get(-v);
						}
					}
				}
			}
			System.out.println(answer);
		}
		in.close();
		System.exit(0);
	}
}