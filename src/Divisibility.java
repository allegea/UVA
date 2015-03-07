import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Divisibility {

	public static String solve(int[] numbers, int k) {
		int n = numbers.length;
		boolean[][] dp = new boolean[n + 1][k];
		dp[1][Math.abs(numbers[0] % k)] = true;
		for (int i = 1; i < n; i++)
			for (int j = 0; j < k; j++)
				if (dp[i][j]) {
					dp[i + 1][Math.abs((j + numbers[i]) % k)] = true;
					dp[i + 1][Math.abs((j - numbers[i]) % k)] = true;
				}
		return dp[n][0] ? "Divisible" : "Not divisible";

	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cases = Integer.parseInt(in.readLine());
		while (cases-- > 0) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			int[] numbers = new int[n];
			for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());
			sb.append(solve(numbers, k) + "\n");
		}
		System.out.print(sb);
		in.close();
		System.exit(0);
	}
}

