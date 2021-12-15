import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, MIN;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		MIN = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = str.charAt(j) - '0';
		}

		bfs();
		System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
	}

	static int D = 4;
	static int[][] DELTA = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0, 1, 1));
		visited[0][0][1] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.x == N - 1 && p.y == M - 1) {
				MIN = Math.min(MIN, p.len);
				continue;
			}

			for (int d = 0; d < D; d++) {
				int nx = p.x + DELTA[d][0];
				int ny = p.y + DELTA[d][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny][p.chance])
					continue;

				if (map[nx][ny] == 1) {
					if (p.chance == 1) {
						queue.offer(new Point(nx, ny, p.len + 1, p.chance - 1));
					}
				} else {
					queue.offer(new Point(nx, ny, p.len + 1, p.chance));
				}
				visited[nx][ny][p.chance] = true;
			}

		}

	}

	static class Point {
		public int x;
		public int y;
		public int len;
		public int chance;

		public Point(int x, int y, int len, int chance) {
			this.x = x;
			this.y = y;
			this.len = len;
			this.chance = chance;
		}
	}

}