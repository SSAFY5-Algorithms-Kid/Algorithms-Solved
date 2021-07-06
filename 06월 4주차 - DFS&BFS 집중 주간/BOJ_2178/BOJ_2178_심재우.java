package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_S1_2178_미로탐색 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		// 0,0 -> N-1,M-1
		
		for (int i = 0; i < N; i++) {
			map[i]=br.readLine().toCharArray();
		}
		// 입력 완료
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int[][] v = new int[N][M];
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(0); que.offer(0);
		v[0][0]=1;
		
		while(!que.isEmpty()) {
			int r = que.poll();
			int c = que.poll();
			
			if (r==N-1 && c==M-1) {
				System.out.println(v[r][c]);
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (!(nr>=0 && nr<N && nc >=0 && nc<M)) {
					continue;
				}
				if (v[nr][nc]!=0) {
					continue;
				}
				if (map[nr][nc]=='1') {
					que.offer(nr); que.offer(nc);
					v[nr][nc]=v[r][c]+1;
				}
			}
		}
		
	}

}
