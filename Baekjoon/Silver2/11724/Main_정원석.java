package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_No11724_연결요소의개수 {
	
	static int N, M, cnt;
	static boolean[] chk;
	static int[][] adjMatrix;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		adjMatrix = new int[N+1][N+1];
		chk = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			
			adjMatrix[v][u] = 1;
			adjMatrix[u][v] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			if(chk[i]) continue;
			
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				for (int j = 1; j <= N; j++) {
					if(adjMatrix[cur][j] == 1 && !chk[j]) {
						q.offer(j);
						chk[j] = true;
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt);

	}

}
