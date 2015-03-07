import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BarCodes {
	static int n, k, m;
	static Long[][] dp;

	public static long solve(int i, int ks, int mm) {

		if (ks > k) return 0;
		if (i == n) {
			return dp[i][ks] = (ks == k ? 1L : 0L);
		} else {
			if (dp[i][ks] != null) return dp[i][ks];
			long sum = 0;
			for (int j = 1; j + i <= n && j <= mm; j++)
			sum+= solve(i + j, ks + 1, m);
			return dp[i][ks] = sum;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		while ((line = in.readLine()) != null && !line.isEmpty()) {
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			dp = new Long[n + 1][k + 1];
			sb.append(solve(1, 0, m - 1) + solve(1, 1, m)).append("\n");
		}
		System.out.print(sb);
		in.close();
		System.exit(0);

	}
}
