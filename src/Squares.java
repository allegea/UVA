import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;




public class Squares {
	static int n;
	static int MAX = 10000;
	static Integer[] dp = new Integer[MAX + 1];

	public static int solve(int value) {
		if (value == 0) return dp[value] = 0;
		if (dp[value] != null) return dp[value];
		int solution = Integer.MAX_VALUE;
		for (int i = 1; i * i <= value; i++) solution = Math.min(solution, solve(value - i * i) + 1);
		return dp[value] = solution;
	}

	public static void solveBU() {
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		for (int i = 0; i <= MAX; i++)
			for (int j = 1; j * j <= i; j++) {
				int index = i - j * j;
				if (index >= 0)
					dp[i] = Math.min(dp[i], dp[index] + 1);
			}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		solveBU();
		int cases = Integer.parseInt(in.readLine());
		while (cases-- > 0) {
			n = Integer.parseInt(in.readLine());
			sb.append(dp[n]).append("\n");
		}
		in.close();
		System.out.print(sb);
		System.exit(0);
	}
}
