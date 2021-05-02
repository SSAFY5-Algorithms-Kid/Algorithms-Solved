package Apr_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_No2589_보물섬 {
	
	static int R, C, answer = Integer.MIN_VALUE;
	static char[][] map;
	static boolean[][] chk;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'W') continue;
				Queue<point> q = new LinkedList<>();
				chk = new boolean[R][C];
				chk[i][j] = true;
				q.offer(new point(i, j));
				int dist = -1;
				while(!q.isEmpty()) {
					int size = q.size();
					for (int k = 0; k < size; k++) {
						point cur = q.poll();
						for (int l = 0; l < 4; l++) {
							int nx = cur.x + dx[l];
							int ny = cur.y + dy[l];
							if(chkvalid(nx, ny) && map[nx][ny] == 'L' && !chk[nx][ny]) {
								q.offer(new point(nx, ny));
								chk[nx][ny] = true;
							}
						}
					}
					dist++;
				}
				answer = Math.max(answer, dist);
			}
		}
		
		System.out.println(answer);

	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= R || y < 0 || y >= C) return false;
		return true;
	}
	
	static class point{
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}

}
