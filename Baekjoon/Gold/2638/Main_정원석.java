package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 210709 fri 치즈
 * 
 * 이 문제의 키포인트는 공기의 내외부를 판단할 수 있는지이다.
 * 처음 접근했을 때는 이 부분을 간과해서 틀렸고
 * 두 번째로는 내부 공기를 판단하여 녹는 치즈칸을 판단했는데
 * 내부 공기를 판단하는 로직이 틀렸었다. 실제로 정확히 내부 공기를 판별하는 것은
 * 거의 불가능할 정도로 까다로웠다. 해답은 외부 공기를 판별하는 것이다.
 * bfs를 이용하면 외부 공기를 간단하게 판별이 가능했다.
 * */

public class No2638_치즈 {

	static int N, M, cheezeSize = 0, ans = 0;
	static int[][] map;
	static boolean[][] chk;
	static ArrayList<point> hole;
	static Queue<point> cheeze, melt;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cheeze = new LinkedList<>();
		melt = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheeze.offer(new point(i, j));
					cheezeSize++;
				}
			}
		}
		
		while(cheezeSize > 0) {
			
			makeExternal();
			
			int size = cheeze.size();
			for (int i = 0; i < size; i++) {
				point cur = cheeze.poll();
				int cnt = 0;
				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					
					if(chkvalid(nx, ny) && map[nx][ny] == 2) cnt++;
				}
				if(cnt >= 2) melt.offer(cur);
				else cheeze.offer(cur);
			}
			
			cheezeSize -= melt.size();
			
			while(!melt.isEmpty()) {
				point tmp = melt.poll();
				map[tmp.x][tmp.y] = 0;
			}
			ans++;
		}
		
		System.out.println(ans);

	}
	static void makeExternal() {
		Queue<point> q = new LinkedList<>();
		chk = new boolean[N][M];
		q.offer(new point(0, 0));
		chk[0][0] = true;
		
		while(!q.isEmpty()) {
			point cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				if(chkvalid(nx, ny) && map[nx][ny] != 1 && !chk[nx][ny]) {
					q.offer(new point(nx, ny));
					map[nx][ny] = 2;
					chk[nx][ny] = true;
				}
			}
		}
	}	
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
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
