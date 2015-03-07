import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameShowMath {
	static int[] values;
	static int target;
	static String answer = null;
	static Boolean[][] dp;
	static final int LIMIT = 32000;
	static final int M = LIMIT * 2 + 1;

	public static boolean solve(int i, int current, String solution) {
		if (answer != null) return true;
		if (i == values.length) {
			if (current == target) answer = solution;
			return true;
		} else {
			if (dp[i][current + LIMIT] != null) return dp[i][current + LIMIT];
			boolean answer = false;
			if (current % values[i] == 0 && isInRage(current / values[i])) answer|= solve(i + 1, current / values[i], solution + "/" + values[i]);
			if (isInRage(current * values[i])) answer|= solve(i + 1, current * values[i], solution + "*" + values[i]);
			if (isInRage(current - values[i])) answer|= solve(i + 1, current - values[i], solution + "-" + values[i]);
			if (isInRage(current + values[i])) answer|= solve(i + 1, current + values[i], solution + "+" + values[i]);
			return dp[i][current + LIMIT] = answer;
		}
	}

	private static boolean isInRage(int x) {
		return x >= -LIMIT && x <= LIMIT;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (cases-- > 0) {
			answer = null;
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			values = new int[n];
			for (int i = 0; i < n; i++) values[i] = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			dp = new Boolean[n + 1][M];
			solve(1, values[0], values[0] + "");
			sb.append(answer == null ? "NO EXPRESSION" : answer + "=" + target).append("\n");
		}
		System.out.print(sb);
		in.close();
		System.exit(0);

	}
}
