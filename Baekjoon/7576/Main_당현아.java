import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, TOTAL, CNT;
	static int[][] map;
	static Queue<Point> list = new LinkedList<Point>();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		TOTAL = CNT = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;

				if (num == 1) // 익은 토마토 위치 확인
					list.offer(new Point(i, j));
				else if (num == 0) // 익혀야하는 토마토 수 확인
					TOTAL++;
			}
		}

		if (TOTAL == 0)
			System.out.println(0);
		else {
			bfs();
			System.out.println(checkTomato());
		}
	}

	private static int checkTomato() {
		if (TOTAL > 0)
			return -1;
		return CNT - 1;
	}

	static int D = 4;
	static int[][] DELTA = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void bfs() {
		while (!list.isEmpty()) {
			int size = list.size();

			for (int s = 0; s < size; s++) {
				Point p = list.poll();

				for (int d = 0; d < D; d++) {
					int nx = p.x + DELTA[d][0];
					int ny = p.y + DELTA[d][1];

					if (!isVaildate(nx, ny) || Math.abs(map[nx][ny]) == 1)
						continue;

					map[nx][ny] = 1;
					list.offer(new Point(nx, ny));
					TOTAL--;
				}
			}
			CNT++;
		}
	}

	private static boolean isVaildate(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;
		return true;
	}

	static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}