import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K, answer = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] chk;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		chk = new boolean[N][M][K + 1];
		
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}
		
		Queue<point> q = new LinkedList<>();
		q.offer(new point(0, 0, K));
		chk[0][0][K] = true;
		
		int ans = 1;
		loop: while(!q.isEmpty()) {
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				point cur = q.poll();
				
				if(cur.x == N-1 && cur.y == M-1) {
					answer = Math.min(answer, ans);
					break loop;
				}
				
				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					
					if(chkvalid(nx, ny)) {
						if(map[nx][ny] == 0 && !chk[nx][ny][cur.k]) {
							q.offer(new point(nx, ny, cur.k));
							chk[nx][ny][cur.k] = true;
						}else if(cur.k - 1 >= 0 && map[nx][ny] == 1 && !chk[nx][ny][cur.k - 1]) {
							q.offer(new point(nx, ny, cur.k - 1));
							chk[nx][ny][cur.k - 1] = true;
						}
					}
				}
			}
			ans++;			
		}
		
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);

	}
	
	static void printMap() {
		for (int i = 0; i < N; i++) {
			
		}
	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	static class point {
		int x, y, k;

		public point(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}		
	}

}
