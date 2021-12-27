package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No6593_상범빌딩 {
	
	static int L, R, C, ans;
	static char[][][] map;
	static boolean[][][] chk;
	static boolean flag;
	
	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
						
			if(L == 0 && R == 0 && C == 0) break;
			
			map = new char[L][R][C];
			chk = new boolean[L][R][C];
			
			Queue<point> q = new LinkedList<>();
			
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String tmp = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = tmp.charAt(k);
						if(map[i][j][k] == 'S') {
							q.offer(new point(j, k, i));
							chk[i][j][k] = true;
						}
					}					
				}
				br.readLine();
			}
			
			ans = 0;
			flag = false;
			
			loop: while(!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					point cur = q.poll();
					if(map[cur.z][cur.x][cur.y] == 'E') {
						flag = true;
						break loop;
					}
					
					for (int j = 0; j < 6; j++) {
						int nx = cur.x + dx[j];
						int ny = cur.y + dy[j];
						int nz = cur.z + dz[j];
						
						if(chkvalid(nx, ny, nz) && map[nz][nx][ny] != '#' && !chk[nz][nx][ny]) {
							q.offer(new point(nx, ny, nz));
							chk[nz][nx][ny] = true;
						}
					}
				}
				ans++;
			}
			if(flag) System.out.println("Escaped in " + ans + " minute(s).");
			else System.out.println("Trapped!");
			
		}

	}
	
	static boolean chkvalid(int x, int y, int z) {
		if(x < 0 || x >= R || y < 0 || y >= C || z < 0 || z >= L) return false;
		return true;
	}
	
	static class point{
		int x, y, z;

		public point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}		
	}

}
