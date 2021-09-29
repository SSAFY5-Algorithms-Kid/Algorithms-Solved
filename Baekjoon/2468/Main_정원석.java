package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2468_안전영역 {
	
	static int N, answer = 0, maxHeight = Integer.MIN_VALUE;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}

		for (int i = 1; i <= maxHeight; i++) {
			bfs(i);
		}
		System.out.println(answer);
	}
	static void bfs(int height) {
		
		boolean[][] chk = new boolean[N][N];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] <= height || chk[i][j]) continue;
				
				Queue<point> q = new LinkedList<>();
				q.offer(new point(i, j));
				chk[i][j] = true;
				
				
				while(!q.isEmpty()) {
					point cur = q.poll();
					for (int k = 0; k < 4; k++) {
						int nx = cur.x + dx[k];
						int ny = cur.y + dy[k];
						if(chkvalid(nx, ny) && map[nx][ny] > height && !chk[nx][ny]) {
							q.offer(new point(nx, ny));
							chk[nx][ny] = true;
						}
					}
				}
				cnt++;
			}			
		}
		answer = Math.max(answer, cnt);
	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
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
