package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_S1_7576_토마토 {

	static int N, M;
	static int[][] map;
	static int[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		v = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Integer> que = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					que.offer(i); que.offer(j);
					v[i][j] = 0;
				}
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int max=0;
		while (!que.isEmpty()) {
			int r = que.poll();
			int c = que.poll();

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!check(nr, nc)) {
					continue;
				}
				if (v[nr][nc]!=0) {
					continue;
				}
				if (map[nr][nc]==0) {
					map[nr][nc]=1;
					que.offer(nr); que.offer(nc);
					v[nr][nc]=v[r][c]+1;
					max = Math.max(v[nr][nc], max);
				}

			}

		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]==0) {
					System.out.println("-1");
					System.exit(0);
				}
			}
		}
		System.out.println(max);

	}

	private static boolean check(int r, int c) {

		return r >= 0 && r < M && c >= 0 && c < N;
	}

}
