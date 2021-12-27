package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 210708 thu 로봇
 * 
 * bfs를 가장한 시뮬레이션에 가까운 문제이다.
 * 무지성으로 명령어만 적용하면서 bfs를 사용하면 메모리 초과가 발생한다.
 * 이때 중복되는 조건들을 가지치기 하는 과정이 필요하다.
 * 처음에는 중복되는 움직임만 고려했는데 사실 방향의 중복 또한 배제해야
 * 문제 없이 구현이 가능해진다.
 * */

public class No1726_로봇 {
	
	static int N, M, cnt = 0;
	static int goalx, goaly, goald;
	static int[][] map;
	static boolean[][] chk;
	static Queue<robot> q;
	static robot goal;
	
	static int[] dx = {0, 0, 0, 1, -1};
	static int[] dy = {0, 1, -1, 0, 0};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		chk = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		int initx = Integer.parseInt(st.nextToken()) - 1;
		int inity = Integer.parseInt(st.nextToken()) - 1;
		int initd = Integer.parseInt(st.nextToken());
		
		q.offer(new robot(initx, inity, initd, initd));
		chk[initx][inity] = true;
		
		st = new StringTokenizer(br.readLine());
		goalx = Integer.parseInt(st.nextToken()) - 1;
		goaly = Integer.parseInt(st.nextToken()) - 1;
		goald = Integer.parseInt(st.nextToken());
		
		loop: while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				robot cur = q.poll();
				if(cur.x == goalx && cur.y == goaly && cur.d == goald) {
					System.out.println(cnt);
					break loop;
				}
				
				for (int j = 1; j <= 3; j++) {
					move(cur, j);
				}
				if(cur.d != cur.pre_d) {
					if(cur.d == 1 || cur.d == 2) {
						if(cur.pre_d == 3) q.offer(new robot(cur.x, cur.y, 4, cur.d));
						else q.offer(new robot(cur.x, cur.y, 3, cur.d));
					}else {
						if(cur.pre_d == 1) q.offer(new robot(cur.x, cur.y, 2, cur.d));
						else q.offer(new robot(cur.x, cur.y, 1, cur.d));
					}
				}else {
					if(cur.d == 1 || cur.d == 2) {
						q.offer(new robot(cur.x, cur.y, 3, cur.d));
						q.offer(new robot(cur.x, cur.y, 4, cur.d));
					}else {
						q.offer(new robot(cur.x, cur.y, 1, cur.d));
						q.offer(new robot(cur.x, cur.y, 2, cur.d));
					}
				}
						
			}
			cnt++;
		}
		
	}
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	static void move(robot r, int m) {
		int nx = r.x;
		int ny = r.y;
		for (int i = 0; i < m; i++) {
			nx += dx[r.d];
			ny += dy[r.d];
			if(!chkvalid(nx, ny) || map[nx][ny] == 1) return;
		}
		if(!chk[nx][ny]) {
			q.offer(new robot(nx, ny, r.d, r.d));
			chk[nx][ny] = true;			
		}
	}

	static class robot{
		int x, y, d, pre_d;

		public robot(int x, int y, int d, int pre_d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.pre_d = pre_d;
		}
		
		
	}
}
