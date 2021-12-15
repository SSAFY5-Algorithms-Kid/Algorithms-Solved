import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, answer = Integer.MAX_VALUE;
	static boolean flag;
	static int[][] map;
	static boolean[][][] chk;
	static Queue<point> q;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		chk = new boolean[2][N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp.substring(j, j+1));
			}
		}	

		q = new LinkedList<>();
		q.offer(new point(0, 0, 1, false));
		
		while(!q.isEmpty()) {
			point cur = q.poll();
			if(cur.x == N-1 && cur.y == M-1) {
				answer = Math.min(answer, cur.dist);
				flag = true;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(chkvalid(nx, ny)) {
					if(!cur.boom) {
						if(map[nx][ny] == 0 && !chk[0][nx][ny]) {
							q.offer(new point(nx, ny, cur.dist+1, false));
							chk[0][nx][ny] = true;
						}else if(map[nx][ny] == 1 && !chk[1][nx][ny]) {
							q.offer(new point(nx, ny, cur.dist+1, true));
							chk[1][nx][ny] = true;
						}
					}else {
						if(map[nx][ny] == 0 && !chk[1][nx][ny]) {
							q.offer(new point(nx, ny, cur.dist+1, true));
							chk[1][nx][ny] = true;
						}
					}
				}
			}
		}
		
		if(flag) System.out.println(answer);
		else System.out.println(-1);
		
	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	static class point{
		int x;
		int y;
		int dist;
		boolean boom;
		public point(int x, int y, int dist, boolean boom) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.boom = boom;
		}
		
		
	}

}
