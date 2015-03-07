import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class SimpleMindedHashing {
	static int max = (27 * 26) / 2;
	static int n = 27;
	static int sum = max;
	static Integer[][][] dp;

	public static int solve(int current, int index, int j) {
		if (current < 0 || index < 0 || j > 27) return 0;
		//if (index == n && current != sum) return 0;
		if (current == 0 && index == 0) return dp[current][index][j] = 1;
		if (dp[current][index][j] != null) return dp[current][index][j];
		int sum = 0;
		for (int i = j; i <= 26; i++)
			sum+=solve(current - i, index - 1, i + 1);
		return dp[current][index][j] = sum;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int cases = 1;
		dp = new Integer[sum + 1][n + 1][28];
		//solve(max, 0, 1);
		while (true) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			sum = Integer.parseInt(st.nextToken());
			if (n == 0 && sum == 0) break;
			//dp = new Integer[sum + 1][n + 1][28];
			int answer = sum > max || n > 27? 0: solve(sum, n, 1);
			sb.append("Case " + (cases++) + ": " + answer).append("\n");
		}
		in.close();
		System.out.print(sb);
		System.exit(0);
	}
}
