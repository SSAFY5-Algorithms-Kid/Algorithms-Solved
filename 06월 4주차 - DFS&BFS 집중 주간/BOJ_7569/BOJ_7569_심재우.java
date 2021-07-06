package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  21.04.14
 * 
 *  int[] dr = {-1,1,0,0,0,0};
	int[] dc = {0,0,-1,1,0,0};
	int[] dh = {0,0,0,0,1,-1};
 *
 */
public class Main_BOJ_S1_7569_토마토 {

	static int N, M, H;
	static int[][][] map;
	static int[][][] v;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[M][N][H];
		v = new int[M][N][H];
		Queue<Integer> que = new LinkedList<Integer>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j][h] = Integer.parseInt(st.nextToken());
					if (map[i][j][h]==1) {
						que.offer(i); que.offer(j); que.offer(h);
						v[i][j][h]=0;
					}
				}
			}
		}
		// 입력 완료
		int[] dr = {-1,1,0,0,0,0};
		int[] dc = {0,0,-1,1,0,0};
		int[] dh = {0,0,0,0,1,-1};
		int ans = 0;
		while(!que.isEmpty()) {
			int r = que.poll();
			int c = que.poll();
			int h = que.poll();
			
			for (int d = 0; d < 6; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int nh = h + dh[d];
				if (!check(nr,nc,nh)) {
					continue;
				}
				if (v[nr][nc][nh]!=0) {
					continue;
				}
				if (map[nr][nc][nh]==0) {
					map[nr][nc][nh]=1;
					que.offer(nr); que.offer(nc); que.offer(nh);
					v[nr][nc][nh]=v[r][c][h]+1;
					ans = Math.max(v[nr][nc][nh], ans);
				}
			}
			
		}
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j][h]==0) {
						System.out.println("-1");
						System.exit(0);
					}
				}
			}
		}
		System.out.println(ans);
	}
	private static boolean check(int r, int c, int h) {

		return r >= 0 && r < M && c >= 0 && c < N && h>=0 && h<H;
	}
	
}
