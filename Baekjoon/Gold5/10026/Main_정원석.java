package Apr_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_No10026_적록색약 {
	
	static int N, norm = 0, abnorm = 0;
	static char[][] map;
	static boolean[][] chk;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		chk = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(chk[i][j]) continue;
				Queue<point> q = new LinkedList<>();
				q.offer(new point(i, j));
				chk[i][j] = true;
				
				while(!q.isEmpty()) {
					point cur = q.poll();
					for (int k = 0; k < 4; k++) {
						int nx = cur.x + dx[k];
						int ny = cur.y + dy[k];
						if(chkvalid(nx, ny) && map[nx][ny] == map[i][j] && !chk[nx][ny]) {
							q.offer(new point(nx, ny));
							chk[nx][ny] = true;
						}
					}
				}
				
				norm++;
			}
		}
		
		changeMap();
		chk = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(chk[i][j]) continue;
				Queue<point> q = new LinkedList<>();
				q.offer(new point(i, j));
				chk[i][j] = true;
				
				while(!q.isEmpty()) {
					point cur = q.poll();
					for (int k = 0; k < 4; k++) {
						int nx = cur.x + dx[k];
						int ny = cur.y + dy[k];
						if(chkvalid(nx, ny) && map[nx][ny] == map[i][j] && !chk[nx][ny]) {
							q.offer(new point(nx, ny));
							chk[nx][ny] = true;
						}
					}
				}
				
				abnorm++;
			}
		}
		
		
		System.out.println(norm + " " + abnorm);
		
	}
	
	static void changeMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R';
			}
		}
	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	
	static class point{
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
