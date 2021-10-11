package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 210712 mon 불!
 * 
 * 이 문제는 단순히 bfs를 두 번 반복하면 해결될 줄 알았다.
 * 그런데 가로, 세로의 범위가 1000인 것을 보고 생각을 고쳐먹었다.
 * 또 한가지 문제로는 움직인 지훈이가 불에 잡힐 경우 큐에 추가하면 안되는 점이었다.
 * 그래서 나는 방문을 체크하는 배열을 int로 하여 상황에 따라 위치에 해당하는 값을
 * 다르게 주어 해결할 수 있었다.
 * */

public class No4179_불1 {
	
	static int N, M, cnt = 1;
	static boolean flag;
	static char[][] map;
	static int[][] chk;
	static Queue<point> q1, q2;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		chk = new int[N][M];
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(chk[i], -1);
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'J') {
					q1.offer(new point(i, j));
					chk[i][j] = 0;
				}
				else if(map[i][j] == 'F') {
					q2.offer(new point(i, j));
					chk[i][j] = -2;
				}
			}
		}
		
		loop: while(!q1.isEmpty()) {
			int size = q1.size();
			for (int i = 0; i < size; i++) {
				point cur = q1.poll();				
				if(chk[cur.x][cur.y] == -2) continue;
				
				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					
					if(!chkvalid(nx, ny)) {
						flag = true;
						break loop;
					}else if(map[nx][ny] == '.' && chk[nx][ny] == -1) {
						q1.offer(new point(nx, ny));
						chk[nx][ny] = cnt;
					}
				}
			}
			
			size = q2.size();
			for (int i = 0; i < size; i++) {
				point cur = q2.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					if(chkvalid(nx, ny) && map[nx][ny] != '#' && chk[nx][ny] != -2) {
						q2.offer(new point(nx, ny));
						chk[nx][ny] = -2;
					}
				}
			}
			cnt++;
		}
		
		if(flag) System.out.println(cnt);
		else System.out.println("IMPOSSIBLE");
		
		

	}
	
	
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}

}
