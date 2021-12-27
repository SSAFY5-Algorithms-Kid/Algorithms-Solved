import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// try 1 : X - 현재 편의점이 순서대로 들어온다는 보장이 없음 > 모든 편의점에 갈수있는 경우

public class Main {

	static int T, N;
	static boolean flag;
	static Point[] points;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			points = new Point[N + 2];
			visited = new boolean[N + 2];
			flag = false;

			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			bfs(0);

			System.out.println(flag ? "happy" : "sad");
		}
	}

	private static void bfs(int idx) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(points[idx]);
		visited[idx] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			if (now == points[N + 1]) {
				flag = true;
				return;
			}

			for (int i = 0; i < N + 2; i++) {
				if (!visited[i] && getDistance(now, points[i]) <= 50 * 20) { // 50미터 * 20병
					visited[i] = true;
					queue.offer(points[i]);
				}
			}
		}
	}

	private static int getDistance(Point p1, Point p2) { // 맨헤튼 거리
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
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