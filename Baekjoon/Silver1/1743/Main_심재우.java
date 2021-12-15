package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_S1_1743_음식물피하기 {

	static int N,M,K;
	static int[][] map;
	static int[][] v;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[101][101];
		v = new int[101][101];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			map[n][m]=1;
		}
		ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j]==1 && v[i][j]==0) {
					bfs(i,j);
				}
			}
		}
		System.out.println(ans);
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static void bfs(int i, int j) {
		int cnt = 1;
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(i); que.offer(j);
		v[i][j]=1;
		while(!que.isEmpty()) {
			int r = que.poll();
			int c = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (!(nr>=1 && nr < 101 && nc >=1 && nc < 101)) {
					continue;
				}
				if (v[nr][nc]!=0) {
					continue;
				}
				if (map[nr][nc]==1) {
					que.offer(nr); que.offer(nc);
					v[nr][nc]=1;
					cnt++;
					ans = Math.max(cnt, ans);
				}
			}
		}
	}

}
