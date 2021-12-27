import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer = -1;
	static int[][] map;
	static boolean[][] chk;
	static Queue<node> q;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		chk = new boolean[N][M];
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					chk[i][j] = true;
					q.offer(new node(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				node cur = q.poll();
				for (int k = 0; k < 4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					if(chkvalid(nx, ny) && map[nx][ny] == 0 && !chk[nx][ny]) {
						q.offer(new node(nx, ny));
						map[nx][ny] = 1;
						chk[nx][ny] = true;
					}
				}
			}
			answer++;
		}
		
		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					answer = -1;
					break loop;
				}
			}
		}
		System.out.println(answer);

	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	static class node{
		int x;
		int y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}

}
