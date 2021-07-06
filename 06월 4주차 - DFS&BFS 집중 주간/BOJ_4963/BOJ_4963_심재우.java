package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_S2_4963_섬의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			String tmp = br.readLine();
			if (tmp.equals("0 0")) {
				break;
			}
			st = new StringTokenizer(tmp);
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int[] dr = {-1,-1,0,1,1,1,0,-1};
			int[] dc = {0,1,1,1,0,-1,-1,-1};
			
			boolean[][] v = new boolean[h][w];
			Queue<Integer> que = new LinkedList<>();
			int ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j]==1 && !v[i][j]) {
						que.offer(i); que.offer(j);
						v[i][j]=true;
						while(!que.isEmpty()) {
							int r = que.poll();
							int c = que.poll();
							
							for (int d = 0; d < 8; d++) {
								int nr = r + dr[d];
								int nc = c + dc[d];
								
								if (!(nr>=0&&nr<h&&nc>=0&&nc<w)) {
									continue;
								}
								if (v[nr][nc]) {
									continue;
								}
								if (map[nr][nc]==0) {
									continue;
								}
								
								que.offer(nr); que.offer(nc);
								v[nr][nc]=true;
							}
						}
						ans++;
					}
				}
			}
			System.out.println(ans);
			
		}
	}

}

/*
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0

*/