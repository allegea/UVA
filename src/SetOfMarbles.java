
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SetOfMarbles {

	private static boolean foundSolution = false;
	private static int MAX = 0;
	private static int N = 0;
	private static String[] boxes = {" from B2 to B1", "", " from B1 to B2"};
	public static void solve(int current, int moves, boolean[] visited, int[] path) {
		if (foundSolution) return;
		if (moves == MAX) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < MAX - 1; i++) {
				int bit1 = Integer.bitCount(path[i]);
				int bit2 = Integer.bitCount(path[i + 1]);
				int number = Integer.numberOfTrailingZeros(path[i] ^ path[i + 1]) + 1;
				sb.append("Move " + number).append(boxes[bit1 - bit2 + 1]).append("\n");
			}
			System.out.println(sb);
			foundSolution = true;
		} else {
			for (int i = 0; i < N; i++) {
				int u = 1 << i;
				int v = current ^ u;
				if (!visited[v]) {
					visited[v] = true;
					path[moves] = v;
					solve(v, moves + 1, visited, path);
					visited[v] = false;
				}
			}
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[] visited;
		int[] path;
		int cases = Integer.parseInt(in.readLine());
		while (cases-- > 0) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int current = 0;
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < m; i++)
				current|= (1 << (Integer.parseInt(st.nextToken()) - 1));
			MAX = 1 << N;
			foundSolution = false;
			path = new int[MAX];
			path[0] = current;
			visited = new boolean[MAX];
			visited[current] = true;
			solve(current, 1, visited, path);
		}
		in.close();
		System.exit(0);
	}

}
