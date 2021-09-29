package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 210709 fri 성곽
 * 
 * 이 문제는 두 가지의 키포인트가 있는데
 *  1. 4방에 대해서 벽의 유무 판단
 *  2. 벽을 부숴서 인접한 방의 크기의 합을 구함
 * 이다.
 * 1번은 누가봐도 비트마스킹을 이용하는 조건이다.
 * 다만 나는  사방탐색을 위한 배열의 순서와 벽의 방향의 순서를 맞춰서 구현함으로 해결했다.
 * 2번의 조건에서 막혔는데, 방의 번호와 크기를 key-value쌍의 특징을 갖는 map을 이용해서
 * 저장한 후에 다시 탐색하면서 인접한 방의 크기의 합의 최대값을 구함으로 해결하였다.
 * */

public class No2234_성곽 {
	
	static int N, M, mark = 1;
	static int rSize = 0, adjSize = 0;
	static int[][] map, markMap;
	static boolean[][] chk;
	static HashMap<Integer, Integer> room;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		markMap = new int[N][M];
		chk = new boolean[N][M];
		room = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(chk[i][j]) continue;
				
				Queue<point> q = new LinkedList<>();
				q.offer(new point(i, j));
				chk[i][j] = true;
				markMap[i][j] = mark;
				int cnt = 1;
				
				while(!q.isEmpty()) {
					point cur = q.poll();
					int val = map[cur.x][cur.y];
					
					for (int k = 3; k >= 0; k--) {
						int wall = (int)(Math.pow(2, k));
						if(val >= wall) {
							val -= wall;
							continue;
						}
						int nx = cur.x + dx[k];
						int ny = cur.y + dy[k];
						
						if(chkvalid(nx, ny) && !chk[nx][ny]) {
							q.offer(new point(nx, ny));
							chk[nx][ny] = true;
							markMap[nx][ny] = mark;
							cnt++;
						}
						
					}
				}
				room.put(mark, cnt);
				
				mark++;
				rSize = Math.max(rSize, cnt);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(chkvalid(nx, ny) && markMap[i][j] != markMap[nx][ny]) {
						adjSize = Math.max(adjSize, room.get(markMap[i][j]) + room.get(markMap[nx][ny]));
					}
				}
			}
		}
		System.out.println(mark-1);
		System.out.println(rSize);
		System.out.println(adjSize);

	}
	static class point{
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}

}
