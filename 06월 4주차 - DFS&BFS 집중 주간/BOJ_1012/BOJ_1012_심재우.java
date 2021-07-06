package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_S2_1012_유기농배추 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());	//가로
			int N = Integer.parseInt(st.nextToken());	//세로
			int K = Integer.parseInt(st.nextToken());	//배추개수
			
			int[][] map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				map[r][c]=1;
			}
			// 입력 완료
			
			int[] dr = {-1,1,0,0};	//상하좌우
			int[] dc = {0,0,-1,1};
			boolean[][] v = new boolean[N][M];
			Queue<Integer> que = new LinkedList<Integer>();
			int cnt = 2;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j]==1) {
						que.offer(i); que.offer(j);
						map[i][j]=cnt;
						v[i][j]=true;
						while(!que.isEmpty()) {
							int r = que.poll();
							int c = que.poll();
							for (int d = 0; d < 4; d++) {
								int nr = r + dr[d];
								int nc = c + dc[d];
								
								if (!(nr>=0&&nr<N&&nc>=0&&nc<M)) {
									continue;
								}
								if (map[nr][nc]==1) {
									map[nr][nc]=cnt;
									que.offer(nr); que.offer(nc);
									v[nr][nc]=true;
								}
							}
						}
						cnt++;
					}
				}
			}
			
			System.out.println(cnt-2);
		}
		
	}
}
