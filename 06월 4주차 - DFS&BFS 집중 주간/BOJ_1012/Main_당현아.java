import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int TOTAL;
	static int T, M, N, K;
	static int[][] map;
	static boolean[][] check;
	static ArrayList<Point> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			TOTAL = 0;
			map = new int[M][N];
			check = new boolean[M][N];
			list = new ArrayList<Point>();

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = 1;
				list.add(new Point(x, y));
			}

			for (Point p : list) {
				if (check[p.x][p.y])
					continue;

				TOTAL++;
				check[p.x][p.y] = true;
				dfs(p.x, p.y);
			}

			sb.append(TOTAL);
			if (t < T)
				sb.append("\n");

		}
		System.out.println(sb.toString());
	}

	static int[][] DELTA = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + DELTA[d][0];
			int ny = y + DELTA[d][1];

			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				continue;

			if (map[nx][ny] == 0 || check[nx][ny])
				continue;

			check[nx][ny] = true;
			dfs(nx, ny);
		}
	}

	static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}