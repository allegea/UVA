import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class JuegoEscalera {
	private static final int MAX = 1000001;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		boolean[] calendar = new boolean[MAX];
		while (true) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0) break;
			Arrays.fill(calendar, false);
			boolean answer = false;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Math.min(Integer.parseInt(st.nextToken()), MAX);
				for (int j = a; j < b && !answer; j++)
				{
					answer|=calendar[j];
					calendar[j] = true;
				}
				//answer|= (calendar[a] && calendar[a - 1]) || (calendar[b] && calendar[a - 1])
				//calendar[a] = calendar[b] = true;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int j = 0;
				while (!answer) {
				 if(a > 1000000 && b >= 1000000) break;
					for (j = a; j < b && !answer; j++)
					{
						answer|=calendar[j];
						calendar[j] = true;
					}
					a += c;
					b += c;
					b = Math.min(b, MAX);
					//System.out.println(a + " - " + b);
				}
			}

			sb.append(answer?"CONFLICT\n": "NO CONFLICT\n");
		}
		System.out.print(sb);
		in.close();
		System.exit(0);
	}
}
