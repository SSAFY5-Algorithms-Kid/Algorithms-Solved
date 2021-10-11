package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 210712 mon 미로만들기
 * 
 * 이 문제는 시작부터 끝 방까지 가는 데 조건이 필요하다.
 *  1. 검은 방은 최소로 지나칠 것
 *  2. 그 중에서 최단 경로 일것
 * 최단 경로이므로 당연히 bfs를 이용하였다.
 * 일반적으로 큐를 이용하게 되면 검은 방 개수가 최소로 나오지 않는다.
 * 따라서 우선순위 큐를 이용해서 지나친 검은 방의 개수가 적은 것부터
 * 뽑아내서 탐색하면 해결이 가능하다.
 * */

public class No2665_미로만들기 {
	
	static int N, ans = Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][] chk;
	static PriorityQueue<point> pq;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		chk = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		pq = new PriorityQueue<>();
		pq.offer(new point(0, 0, 0));
		chk[0][0] = true;
		
		while(!pq.isEmpty()) {
			point cur = pq.poll();
			
			if(cur.x == N - 1 && cur.y == N - 1) ans = Math.min(ans, cur.cnt);
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(chkvalid(nx, ny) && !chk[nx][ny]) {
					if(map[nx][ny] == '1') pq.offer(new point(nx, ny, cur.cnt));
					else pq.offer(new point(nx, ny, cur.cnt + 1));
					chk[nx][ny] = true;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	
	static class point implements Comparable<point>{
		int x, y, cnt;

		public point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(point o) {
			return this.cnt - o.cnt;
		}		
	}
}
