import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int W, H, K, MIN;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] DELTA = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 기본 DELTA
	static int[][] HorseDELTA = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 },
			{ 1, -2 } }; // 여기까진 HorseDELTA

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로 (j)
		H = Integer.parseInt(st.nextToken()); // 세로 (i)
		map = new int[H][W];
		visited = new boolean[H][W][31];
		MIN = Integer.MAX_VALUE;

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		bfs();
		System.out.println(MIN != Integer.MAX_VALUE ? MIN : -1);
	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(0, 0, 0, K));

		while (!queue.isEmpty()) {
			Node temp = queue.poll();

			if (temp.x == H - 1 && temp.y == W - 1) {
				MIN = Math.min(MIN, temp.d);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int ni = temp.x + DELTA[d][0];
				int nj = temp.y + DELTA[d][1];

				if (ni < 0 || ni >= H || nj < 0 || nj >= W || map[ni][nj] == 1 || visited[ni][nj][temp.j])
					continue;

				queue.offer(new Node(ni, nj, temp.d + 1, temp.j));
				visited[ni][nj][temp.j] = true;
			}

			if (temp.j == 0)
				continue;

			for (int d = 0; d < 8; d++) {
				int ni = temp.x + HorseDELTA[d][0];
				int nj = temp.y + HorseDELTA[d][1];

				if (ni < 0 || ni >= H || nj < 0 || nj >= W || map[ni][nj] == 1 || visited[ni][nj][temp.j - 1])
					continue;

				queue.offer(new Node(ni, nj, temp.d + 1, temp.j - 1));
				visited[ni][nj][temp.j - 1] = true;
			}
		}
	}

	static class Node {
		public int x, y, d, j;

		public Node(int x, int y, int d, int j) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", d=" + d + ", j=" + j + "]";
		}
	}
}