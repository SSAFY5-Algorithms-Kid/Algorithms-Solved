package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_S2_3187_양치기꿍 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			map[i]=s.toCharArray();
		}
		// 입력 완료
		
		Queue<Integer> que = new LinkedList<>();
		boolean[][] v = new boolean[R][C];
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int ans1 = 0; int ans2 = 0;
		
		for (int i = 1; i < R-1; i++) {
			for (int j = 1; j < C-1; j++) {
				if (map[i][j]!='#' && !v[i][j]) {
					que.offer(i); que.offer(j);
					v[i][j]=true;
					int sheep = 0; int wolf = 0;
					if (map[i][j]=='v') {
						wolf++;
					}
					if (map[i][j]=='k') {
						sheep++;
					}
					while(!que.isEmpty()) {
						int r = que.poll(); 
						int c = que.poll();
						
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if (!(nr>=0&&nr<R&&nc>=0&&nc<C)) continue;
							if (v[nr][nc]) continue;
							if (map[nr][nc]=='#') continue;
							
							if (map[nr][nc]=='k') {
								sheep++;
								que.offer(nr); que.offer(nc);
								v[nr][nc]=true;
							}
							if (map[nr][nc]=='v') {
								wolf++;
								que.offer(nr); que.offer(nc);
								v[nr][nc]=true;
							}
							if (map[nr][nc]=='.') {
								que.offer(nr); que.offer(nc);
								v[nr][nc]=true;
							}
						}
					}
					if (sheep>wolf) {
						ans1+=sheep;
					}else {
						ans2+=wolf;
					}
					
				}
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}

}
