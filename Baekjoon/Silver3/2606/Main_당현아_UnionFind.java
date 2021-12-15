import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			union(n, m);
		}

		int cnt = 0;
		for (int i = 2; i <= N; i++)
			if (find(i) == find(1))
				cnt++;

		System.out.println(cnt);
	}

	private static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);

		if (xRoot < yRoot)
			parent[yRoot] = xRoot;
		if (xRoot > yRoot)
			parent[xRoot] = yRoot;
	}
}