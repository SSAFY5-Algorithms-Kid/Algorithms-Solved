package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2644_촌수계산 {
	
	static int N, M, start, end, ans = -1;
	static int[][] map;
	static boolean[] chk;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		chk = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			
			map[v][u] = 1;
			map[u][v] = 1;
		}
		
		dfs(start, 0);
		
		System.out.println(ans);

	}
	
	static void dfs(int v, int cnt) {
		if(v == end) {
			ans = cnt;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(map[v][i] == 1 && !chk[i]) {
				chk[i] = true;
				dfs(i, cnt+1);
			}
		}
	}

}
