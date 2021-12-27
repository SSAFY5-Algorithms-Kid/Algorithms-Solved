package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_S2_7562_나이트의이동 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[] dr = {-2,-1,1,2,2,1,-1,-2};
		int[] dc = {1,2,2,1,-1,-2,-2,-1};
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n][n];
			
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			// 입력완료
			
			Queue<Integer> que = new LinkedList<>();
			int[][] v = new int[n][n];
			
			que.offer(sr); que.offer(sc);
			v[sr][sc]=0;
			
			while(!que.isEmpty()) {
				int cr = que.poll();
				int cc = que.poll();
				
				if (cr==er && cc==ec) {
					break;
				}
				
				for (int d = 0; d < 8; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					
					if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
						continue;
					}
					if (v[nr][nc]!=0) {
						continue;
					}
					que.offer(nr); que.offer(nc);
					v[nr][nc]=v[cr][cc]+1;
					
				}
			}
			System.out.println(v[er][ec]);
		}
	}
}
