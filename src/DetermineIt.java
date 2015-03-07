import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DetermineIt {
	static int n;
	static Long[][] dp;

	public static long solve(int i, int j) {
		if (dp[i][j] != null) return dp[i][j];
		long answer = 0;
		if (i < j) {
			for (int k = i; k < j; k++)
				answer = Math.max(answer, solve(i, k) + solve(k + 1, j));
		} else {
			long x = 0;
			if (i != n) {
				for (int k = i + 1; k <= n; k++)
					x = Math.max(x, solve(k, 1) + solve(k, j));
			}
			long y = 0;
			if (j != 0) {
				for (int k = 1; k < j; k++)
					y = Math.max(y, solve(i, k) + solve(n, k));
			}
			answer = x + y;
		}
		return dp[i][j] = answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String line = "";
		while ((line = in.readLine()) != null && !line.isEmpty()) {
			st = new StringTokenizer(line);

			n = Integer.parseInt(st.nextToken());
			long ai = Integer.parseInt(st.nextToken());
			dp = new Long[n + 1][n + 1];
			dp[n][1] = ai;
			sb.append(solve(1, n)).append("\n");
			//System.out.println(solve(1, n));
		}
		in.close();
		System.out.print(sb);
		System.exit(0);
	}
}
