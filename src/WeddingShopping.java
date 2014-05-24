/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */

public class WeddingShopping {
	static ArrayList<Integer>[] prices;
	static int N;
	static int M;
        static int[][] memo;
        static int answer;
	public static void backtracking(int money, int pos)
	{
		if(money > M)return;
		if(pos == N){
			answer = Math.max(answer, money);
                        return;
                }
		for(int x:prices[pos])
                {
                    backtracking(money+x, pos+1);
                }
	}
        public static int DP(int money, int pos)
	{
		if(money > M)return -10;
		if(pos == N){
                        return money;
                }
                if(memo[money][pos] != -1)
                    return memo[money][pos];
                
                int answer = -10;
		for(int x:prices[pos])
                    answer = Math.max(answer, DP(money+x, pos+1));
                memo[money][pos] = answer;
               // System.out.println(money+" - "+pos+" - "+answer);
                    return answer;

	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		while(cases-->0)
		{
		
			String[] read = in.readLine().split("[ ]+");
			M = Integer.parseInt(read[0]);
			N = Integer.parseInt(read[1]);
                        memo = new int[M+1][N+1];
                        answer = -1;
                        for(int i=0;i<=M;i++)
                            Arrays.fill(memo[i], -1);
                        
			prices = new ArrayList[N];
			for(int i=0;i<N;i++)
			{
				prices[i] = new ArrayList<Integer>();
				read = in.readLine().split("[ ]+");
				for(int j=1;j<read.length;j++)
					prices[i].add(Integer.parseInt(read[j]));
			}
			
                        int solution = DP(0, 0);
                        //backtracking(0, 0);
			System.out.println( solution < 0?"no solution":solution);
                        //System.out.println( answer < 0?"no solution":answer);
		}
		in.close();
		System.exit(0);
	}
}