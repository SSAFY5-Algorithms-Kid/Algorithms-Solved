package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * dl[]로 상하
 * dr[], dc[]로 2차원에서 동서남북
 * 을 골라서 bfs 진행
 *
 */
public class Main_BOJ_6593_상범빌딩_G5 {

	static int L, R, C;
	static char[][][] map;
	static int[][][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L==0 && R==0 && C==0) {
				System.exit(0);
			}

			map = new char[L][R][C];

			int sl=0, sr=0, sc=0;
			int el=0, er=0, ec=0;

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String tmp = br.readLine();
					if (tmp.equals("")) {
						continue;
					}
					map[i][j]=tmp.toCharArray();
				}
				String tmp = br.readLine();
			}
			// 입력 완료

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					for (int k = 0; k < C; k++) {
						if (map[i][j][k]=='S') {
							sl=i; sr=j; sc=k;
						}
						if (map[i][j][k]=='E') {
							el=i; er=j; ec=k;
						}
					}
				}
			}
			v = new int[L][R][C];

			if(bfs(sl,sr,sc,el,er,ec)) {
				System.out.println("Escaped in "+(v[el][er][ec]-1)+" minute(s).");
			}else {
				System.out.println("Trapped!");
			}



		}
	}

	static int[] dl = {-1, 1};
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean bfs(int sl, int sr, int sc, int el, int er, int ec) {
		boolean flag = false;
		Queue<Integer> que = new LinkedList<>();

		que.offer(sl); que.offer(sr); que.offer(sc);
		v[sl][sr][sc]=1;

		while(!que.isEmpty()) {
			int l = que.poll();
			int r = que.poll();
			int c = que.poll();

			if (l==el && r == er && c == ec) {
//				System.out.println("Escaped in "+v[el][er][ec]+" minute(s).");
				flag = true;
			}

			for (int d = 0; d < 2; d++) {
				int nl = l + dl[d];

				int nr = r;
				int nc = c;

				if (!check(nl,nr,nc)) continue;

				if (v[nl][nr][nc]!=0) continue;

				if (map[nl][nr][nc]=='#') continue;

				que.offer(nl); que.offer(nr); que.offer(nc);
				v[nl][nr][nc]=v[l][r][c]+1;

			}

			for (int d = 0; d < 4; d++) {
				int nl = l;
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!check(nl,nr,nc)) continue;

				if (v[nl][nr][nc]!=0) continue;

				if (map[nl][nr][nc]=='#') continue;

				que.offer(nl); que.offer(nr); que.offer(nc);
				v[nl][nr][nc]=v[l][r][c]+1;

			}
		}
		return flag;
	}

	static boolean check(int l, int r, int c) {
		return l>=0&& l <L && r>=0 && r<R && c>=0 && c<C;
	}
}






















