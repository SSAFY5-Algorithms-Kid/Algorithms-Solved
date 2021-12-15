import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] grid;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int cheeze, time, answer = 0;
	static boolean[][] chk;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		chk = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == 1) {
					chk[i][j] = true;
					cheeze++;
				}
			}
		}
		grid[0][0] = 2;
		while(cheeze > 0) {
			answer = cheeze;
			makeAir();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(grid[i][j] != 1) continue;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(grid[nx][ny] == 2) {
							grid[i][j] = -1;
							break;
						}
					}
				}
			}
			meltCheeze();
			time++;			
		}
		System.out.println(time);
		System.out.println(answer);
	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	static void makeAir() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(grid[i][j] != 2 || chk[i][j]) continue;
				Queue<point> q = new LinkedList<>();
				grid[i][j] = 2;
				q.offer(new point(i, j));
				chk[i][j] = true;
				while(!q.isEmpty()) {
					point cur = q.poll();
					for (int k = 0; k < 4; k++) {
						int nx = cur.x + dx[k];
						int ny = cur.y + dy[k];
						if(chkvalid(nx, ny) && grid[nx][ny] == 0) {
							q.offer(new point(nx, ny));
							chk[nx][ny] = true;
							grid[nx][ny] = 2;
						}
					}
				}
			}
		}
	}
	
	static void meltCheeze() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(grid[i][j] == -1) {
					grid[i][j] = 2;
					cheeze--;
					chk[i][j] = false;
				}
			}
		}
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
