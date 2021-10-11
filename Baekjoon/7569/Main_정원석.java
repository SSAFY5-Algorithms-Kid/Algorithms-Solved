package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7569_토마토 {
	
	static int N, M, H, tmtCnt = 0, answer = 0;
	static int[][][] map;
	static boolean[][][] chk;
	static Queue<point> q;
	
	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[N][M][H];
		chk = new boolean[N][M][H];
		
		q = new LinkedList<>();
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) {
						q.offer(new point(i, j, k));
						chk[i][j][k] = true;
					}else if(map[i][j][k] == 0) tmtCnt++;
				}
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				point cur = q.poll();
				for (int j = 0; j < 6; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					int nz = cur.z + dz[j];
					
					if(chkvalid(nx, ny, nz) && map[nx][ny][nz] == 0 && !chk[nx][ny][nz]) {
						q.offer(new point(nx, ny, nz));
						chk[nx][ny][nz] = true;
						tmtCnt--;
					}
				}
			}
			answer++;
		}
		
		if(tmtCnt == 0) System.out.println(answer - 1);
		else System.out.println(-1);
	}
	static boolean chkvalid(int x, int y, int z) {
		if(x < 0 || x >= N || y < 0 || y >= M || z < 0 || z >= H) return false;
		return true;
	}
	
	static class point {
		int x, y, z;

		public point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}		
		
	}

}
