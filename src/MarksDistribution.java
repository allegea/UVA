import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static long solve(int n, int t, int p) {
		int m =  t + 2;
		long[][] dp = new long[n + 2][m];
		for (int i = p; i <= t; i++) dp[0][i] = 1;

		for (int i = 0; i < n; i++)
			for (int j = p; j <= t; j++)
				if (dp[i][j] != 0)
				for (int h = p; h <= t && j + h < m; h++)
					dp[i + 1][j + h] +=  dp[i][j];
		return  dp[n - 1][t];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (cases-- > 0) {
			st = new StringTokenizer(in.readLine());
			sb.append(solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
		}
		System.out.print(sb);
		in.close();
		System.exit(0);

	}
}
