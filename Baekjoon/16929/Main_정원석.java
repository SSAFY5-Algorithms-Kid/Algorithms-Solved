package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16929_TwoDots {
	
	static int N, M;
	static String answer = "No";
	static char[][] map;
	static boolean[][] chk;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		chk = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(chk[i][j]) continue;
				if(dfs(-1, -1, i, j)) answer = "Yes";
			}
		}
		
		System.out.println(answer);
		
	}
	static boolean dfs(int prevx, int prevy, int curx, int cury) {		
		if(chk[curx][cury]) return true;		
		chk[curx][cury] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = curx + dx[i];
			int ny = cury + dy[i];
			if(chkvalid(nx, ny) && map[nx][ny] == map[curx][cury] && (prevx != nx || prevy != ny)) {
				if(dfs(curx, cury, nx, ny)) return true;
			}
		}
		return false;
		
	}	
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}

}
