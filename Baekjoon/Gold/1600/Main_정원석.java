import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K, W, H;
	static int[][] grid;
	static boolean[][][] chk;
	static int answer = Integer.MAX_VALUE;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] hxMove = {-2, -2, 2, 2, -1, -1, 1, 1};
	static int[] hyMove = {1, -1, 1, -1, 2, -2, 2, -2};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		grid = new int[H][W];
		chk = new boolean[K+1][H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<monkey> q = new LinkedList<>();
		q.offer(new monkey(0, 0, 0, 0));
		chk[0][0][0] = true;
		
		while(!q.isEmpty()) {
			monkey cur = q.poll();
			if(cur.x == H-1 && cur.y == W-1) {
				answer = Math.min(answer, cur.d);
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(chkvalid(nx, ny) && grid[nx][ny] != 1 && !chk[cur.k][nx][ny]) {
					q.offer(new monkey(nx, ny, cur.k, cur.d+1));
					chk[cur.k][nx][ny] = true;
				}
			}
			if(K - cur.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = cur.x + hxMove[i];
					int ny = cur.y + hyMove[i];
					if(chkvalid(nx, ny) && grid[nx][ny] != 1 && !chk[cur.k+1][nx][ny]) {
						q.offer(new monkey(nx, ny, cur.k+1, cur.d+1));
						chk[cur.k+1][nx][ny] = true;
					}
				}
			}
		}
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);

	}
	
	static class monkey{
		int x;
		int y;
		int k;
		int d;
		public monkey(int x, int y, int k, int d) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.d = d;
		}
		
	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= H || y < 0 || y >= W) return false;
		return true;
	}
}
