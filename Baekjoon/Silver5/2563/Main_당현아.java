import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, N = 100;
	static int[][] PAPER = new int[N][N];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		int count = 0;

		for (int t = 0; t < T; t++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");

			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			for (int i = W; i < W + 10; i++)
				for (int j = H; j < H + 10; j++) {
					if (PAPER[i][j] == 0)
						count++;
					PAPER[i][j] = 1;
				}
		}

		System.out.println(count);

	}
}