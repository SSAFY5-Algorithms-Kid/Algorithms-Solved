import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, MAX;
	static int[][] TABLE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		TABLE = new int[N][2]; // Table 생성 (0 : 기간, 1 : 금액)
		MAX = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			TABLE[i][0] = Integer.parseInt(st.nextToken());
			TABLE[i][1] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		System.out.println(MAX);
	}

	private static void dfs(int i, int sum) {
		if (i >= N) {
			MAX = Math.max(MAX, sum);
			return;
		}

		if (i + TABLE[i][0] <= N) dfs(i + TABLE[i][0], sum + TABLE[i][1]);
		else dfs(i + TABLE[i][0], sum);

		dfs(i + 1, sum);
	}
}