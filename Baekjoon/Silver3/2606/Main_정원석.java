package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2606_바이러스 {
	
	static int N, M, cnt;
	static int[][] map;
	static boolean[] chk;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		chk = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			
			map[v][u] = 1;
			map[u][v] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		chk[1] = true;

		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if(map[cur][i] == 1 && !chk[i]) {
					q.offer(i);
					chk[i] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);

	}

}
