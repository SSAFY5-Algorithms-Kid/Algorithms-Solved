package 연습장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class test {
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int ROW, COL, ans;
	static char[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		ROW = Integer.parseInt(tokens.nextToken());
		COL = Integer.parseInt(tokens.nextToken());
		map = new char[ROW][COL];
		for (int r = 0; r < ROW; r++) {
			map[r] = input.readLine().toCharArray();
		}
//		for (char[] line : map) {
//			System.out.println(Arrays.toString(line));
//		}//입력완료
		for (int r = 0; r < ROW ; r++) {
			for (int c = 0; c < COL; c++) {
				if(map[r][c] == 'L') {
					ans=Math.max(ans, bfs(r,c));
				}
			}
		}
		System.out.println(ans);
	}
	
	private static int bfs(int r, int c) {
		visited = new boolean[ROW][COL];
		visited[r][c] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r,c));
		int cnt = 0;

		while(!q.isEmpty()) {
			int size = q.size();
			for (int p = 0; p < size; p++) {
				Point P = q.poll();
				for (int d = 0; d < deltas.length; d++) {
					int nr = P.r + deltas[d][0];
					int nc = P.c + deltas[d][1];
					if(isIn(nr,nc) && map[nr][nc]  == 'L' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new Point(nr,nc));
					}
				}
			}
			cnt++;
		}
		return cnt-1;
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && r<ROW && c>=0 && c<COL;
	}

	static String src = "7 7\r\n" + 
			"WLLLLLW\r\n" + 
			"LWLWLWW\r\n" + 
			"LLLWLWW\r\n" + 
			"LWWWLWW\r\n" + 
			"LLLLLWW\r\n" + 
			"LWWWWWW\r\n" + 
			"WWWWWWW";
}
