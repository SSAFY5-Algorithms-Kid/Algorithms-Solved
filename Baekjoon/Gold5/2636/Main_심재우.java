package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * (0,0)은 항상 공기이므로 (0,0)에서 출발해서
 * 공기인 경우에 bfs 진행
 * 치즈가 사라지면 break;
 *
 */
public class Main_BOJ_2636_치즈_G5 {

	static int N,M;
	static int[][] map;
	static int tot;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		tot = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if (map[i][j]==1) {
					tot++;
				}
			}
		}
		// 입력 완료

		// 0,0 은 항상 공기 이므로 0,0 에서 출발해서 공기인 경우에 계속 진행하는 식으로 간다.
		int cnt = 0;
		int ans2 = tot;
		while(true) {

			if (tot==0) {
				System.out.println(cnt);
				System.out.println(ans2);
				break;
			}

			bfs(0,0);
			ans2 = tot;
			melted();
			cnt++;

		}

	}

	static int[] dr = { -1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1};
	static void bfs(int r, int c) {
		Queue<Integer> que = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		que.offer(r); que.offer(c);
		v[r][c]=true;

		while(!que.isEmpty()) {
			int curR = que.poll();
			int curC = que.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];

				if(!check(nr,nc)) continue;

				if(v[nr][nc]) continue;

				if(map[nr][nc]==0) {
					que.offer(nr);que.offer(nc);
					v[nr][nc]=true;
					melt(nr,nc);
				}

			}
		}

	}

	static void melt(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (!check(nr,nc)) continue;
			if (map[nr][nc]==1) {
				map[nr][nc]=2;
			}
		}
	}

	static void melted() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]==2) {
					map[i][j]=0;
					tot--;
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}










