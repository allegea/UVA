import java.io.IOException;
import java.util.Scanner;




public class ChestOfDrawers {
	static int n, k;
	static long[][][] dp;

	/*public static long solve(int i, int ks, int previous) {

		if (ks > k) return dp[i][ks][previous] = 0L;
		if (i == n) {
			return dp[i][ks][previous] = (ks == k ? 1L : 0L);
		} else {
			if (dp[i][ks][previous] != null) return dp[i][ks][previous];
			long sum = 0;
			if (previous == 1) sum+= solve(i + 1, ks, 0);
			else sum+= solve(i + 1, ks + 1, 0);
			sum+= solve(i + 1, ks, 1);
			return dp[i][ks][previous] = sum;
		}
	}*/

	public static long solveIt() {
		dp[n][k][0] = dp[n][k][1] = 1L;
		for (int i = n - 1; i >= 0; i--)
			for (int j = k; j >= 0; j--) {
				dp[i][j][1] = dp[i + 1][j][0] + dp[i + 1][j][1];
				dp[i][j][0] = dp[i + 1][j + 1][0] + dp[i + 1][j][1];
			}
		return dp[1][1][0] + dp[1][0][1];
	}


	public static void main(String[] args) throws IOException {
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			n = Integer.parseInt(in.next());
			k = Integer.parseInt(in.next());
			if (n < 0 && k < 0) break;
			dp = new long[n + 3][k + 3][2];
			sb.append(solveIt()).append("\n");
		}
		in.close();
		System.out.print(sb);
		System.exit(0);
	}
}
