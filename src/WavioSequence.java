/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

need to use nlogn
/**
 *
 * @author Alejandro E. Garces
 */
public class WavioSequence {

        static int LISlog(long[] vect, int l) {
        //System.out.println("dddddddddddddd");
        int N = vect.length;
        ArrayList< Integer> M = new ArrayList< Integer>();
        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        M.add(0);
        int[] states = new int[N];
        int max = -1;
        int answer = -1;
        for (int i = 1; i < N; ++i) {
            long x = vect[i];
            int m = M.size() - 1;
            if (x > vect[M.get(m)]) {
                parent[i] = M.get(m);
                states[i] = states[M.get(m)]+1;
                max = Math.max(max, states[i]);
                M.add(i);
                int min = Math.min(states[i], LDS(vect, i));
                answer = Math.max(2*min-1,answer);
                continue;
            }
            int lo = l;
            int hi = m;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (vect[M.get(mid)] <= x) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            int j = lo;
            if (x < vect[M.get(j)]) {
                if (j > 0) {
                    parent[i] = M.get(j - 1);
                }
                states[i] = states[M.get(j-1)]+1;
                max = Math.max(max, states[i]);
                int min = Math.min(states[i], LDS(vect, i));
                answer = Math.max(2*min-1,answer);
                M.set(j, i);
            }
        }
        System.out.println(Arrays.toString(states));

        return answer;
    }
        
    static int LDS(long[] x, int l)
    {
        int n = x.length;
        int[] states = new int[n];
	int posMaxD = -1;
	int maxGD = -1;
	for(int i=l;i<n;i++)
	{
            int max = 0;
            for(int j=l;j<i;j++)
		if(x[j] > x[i])
		max = Math.max(max, states[j]);
	
            states[i] = max + 1;
            if(states[i] > maxGD)
            {
		maxGD = states[i];
		posMaxD = i;
		}
	}
        return maxGD;
        
    }
	 public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		String line = "";
		long[] numbers;
		while((line = in.readLine()) != null && line.length() > 0)
		{
			int n = Integer.parseInt(line);
			numbers = new long[n];
			String[] read = in.readLine().split("[ ]+");
			for(int i=0;i<read.length;i++)
				numbers[i] = (Long.parseLong(read[i]));
			//System.out.println("ggggg");
			/*int[] states = new int[n];
			int posMax = -1;
			int maxG = -1;
                        int answer = -1;
			for(int i=0;i<n;i++)
			{
				int max = 0;
				for(int j=0;j<i;j++)
					if(numbers[j]<numbers[i])
						max = Math.max(max, states[j]);
				
				states[i] = max + 1;
				if(states[i] > maxG)
				{
					maxG = states[i];
					posMax = i;
				}
                                int min = Math.min(states[i], LDS(numbers, i));
                                answer = Math.max(2*min-1,answer);
			}
			

			//int min = Math.min(maxGD, maxG);*/
			System.out.println(LISlog(numbers, 0));
		}
		in.close();
		System.exit(0);
	}
}

/*
 10
1 2 3 4 5 4 3 2 1 10
19
1 2 3 2 1 2 3 4 3 2 1 5 4 1 2 3 2 2 1
5
1 2 3 4 5
19
1 2 3 7 8 2 3 4 3 2 1 5 4 1 2 3 2 2 1
1
1
1
5
22
1 2 3 2 8 9 10 2 3 4 3 2 1 5 4 1 2 3 6 2 2 1
7
1 4 2 3 2 4 1
4
1 3 6 5
20
13 7 5 7 6 7 2 7 3 20 9 9 15 20 9 10 12 12 4 13
20
9 18 16 12 6 16 1 13 15 20 4 8 6 20 6 4 19 7 2 1
20
18 2 1 12 14 2 13 5 13 16 17 14 6 12 5 3 19 17 15 6
20
17 18 13 14 10 10 17 8 9 10 20 18 12 20 2 5 1 14 1 6
20
10 9 19 7 13 15 9 11 12 3 16 8 12 20 1 1 10 10 8 10
20
19 7 7 2 19 8 18 11 2 18 16 3 7 6 1 19 1 9 1 4
20
3 17 11 14 16 3 15 17 4 14 18 3 13 5 16 11 4 14 13 17
20
11 9 11 9 6 11 19 18 11 20 1 13 8 3 7 3 18 1 12 1
20
6 1 15 18 5 11 20 1 4 13 17 6 13 20 7 18 2 5 8 13
20
4 8 5 3 3 11 18 20 3 9 20 1 9 15 18 6 17 18 18 12
20
2 6 17 14 5 15 3 7 20 10 19 15 10 15 18 12 6 15 3 20
20
15 14 20 15 8 10 20 16 7 17 7 8 15 4 13 19 18 15 17 9
20
17 15 16 6 10 13 9 7 19 3 6 13 16 18 7 16 7 19 11 5
20
7 18 4 1 13 16 12 2 2 8 11 18 15 6 15 4 10 15 2 8
20
17 19 12 13 16 10 8 14 20 10 18 7 7 1 19 19 8 10 13 10
20
10 3 7 4 20 2 19 9 8 20 8 5 10 11 9 18 20 8 11 20
20
17 1 18 4 1 8 14 1 10 6 10 19 20 8 14 11 1 12 11 9
20
3 18 13 4 8 1 1 20 8 12 11 4 4 20 19 4 7 5 4 8
20
2 5 6 14 13 11 4 13 14 15 1 8 4 5 12 4 5 12 3 4
20
15 5 8 18 4 18 14 2 14 9 10 16 14 7 1 18 18 4 10 3
* 
* 
9
9
1
9
1
1
11
5
3
7
9
9
7
7
7
9
7
7
7
9
7
7
9
7
7
9
9
9
9
 */