package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_No1012_유기농배추 {
	
	static int T, N, M, K, cnt;
	static int[][] map;
	static boolean[][] chk;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			chk = new boolean[N][M];
			cnt = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0 || chk[i][j]) continue;
					
					Queue<point> q = new LinkedList<>();
					q.offer(new point(i, j));
					chk[i][j] = true;
					
					while(!q.isEmpty()) {
						point cur = q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = cur.x + dx[k];
							int ny = cur.y + dy[k];
							if(chkvalid(nx, ny) && map[nx][ny] == 1 && !chk[nx][ny]) {
								q.offer(new point(nx, ny));
								chk[nx][ny] = true;
							}
						}
					}
					
					cnt++;
				}
			}
			System.out.println(cnt);
		}

	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	static class point {
		int x, y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}

}
