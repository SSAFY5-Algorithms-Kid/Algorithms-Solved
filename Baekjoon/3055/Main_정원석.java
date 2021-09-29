package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3055_탈출 {
	
	static int R, C, cnt = 0;
	static char[][] map;
	static boolean[][] chk;
	static Queue<point> q1, q2;
	static boolean flag;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		chk = new boolean[R][C];
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '*') q1.offer(new point(i, j));
				if(map[i][j] == 'S') {
					q2.offer(new point(i, j));
					chk[i][j] = true;
				}
			}
		}
		while(!q2.isEmpty()) {
			spreadWater();
			go();
			cnt++;
			if(flag) break;
			
		}
		
		if(flag) System.out.println(cnt);
		else System.out.println("KAKTUS");

	}
	
	static void go() {
		int size = q2.size();
		for (int i = 0; i < size; i++) {
			point cur = q2.poll();
			if(map[cur.x][cur.y] == 'D') flag = true;
			for (int j = 0; j < 4; j++) {
				int nx = cur.x + dx[j];
				int ny = cur.y + dy[j];
				if(chkvalid(nx, ny)) {
					if(map[nx][ny] == 'D') {
						flag = true;
						return;
					}
					else if(map[nx][ny] == '.' && !chk[nx][ny]) {
						q2.offer(new point(nx, ny));
						chk[nx][ny] = true;
					}										
				}
			}
		}
	}
	
	static void spreadWater() {
		int size = q1.size();
		for (int i = 0; i < size; i++) {
			point cur = q1.poll();
			for (int j = 0; j < 4; j++) {
				int nx = cur.x + dx[j];
				int ny = cur.y + dy[j];
				if(chkvalid(nx, ny) && map[nx][ny] == '.') {
					map[nx][ny] = '*';
					q1.offer(new point(nx, ny));
				}
			}
		}
	}
	
	static void printMap() {
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("----------------");
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
