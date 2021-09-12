import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static int[] parents;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input/d4/서로소집합.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			sb = new StringBuilder("");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			set();

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int option = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				switch (option) {
				case 0:
					union(a, b);
					break;
				case 1:
					sb.append(find(a) == find(b) ? 1 : 0);
					break;
				}
			}
			
			System.out.println("#"+t+" "+sb.toString());
		}
	}

	private static void set() {
		for (int i = 1; i < N+1; i++)
			parents[i] = i;
	}

	private static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		if (aRoot > bRoot)
			parents[bRoot] = aRoot;
		else
			parents[aRoot] = bRoot;

		return true;
	}

}