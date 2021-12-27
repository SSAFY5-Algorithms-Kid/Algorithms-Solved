package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1260_DFS와BFS {
	
	static int N, M, V;
	static int[][] adjMatrix;
	static boolean[] chk;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];
		chk = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			
			adjMatrix[v][u] = 1;
			adjMatrix[u][v] = 1;
		}
		
		dfs(V);
		System.out.println();
		
		chk = new boolean[N+1];
		bfs(V);

	}
	
	static void dfs(int v) {
		
		chk[v] = true;
		System.out.print(v + " ");
		
		for (int i = 1; i <= N; i++) {
			if(adjMatrix[v][i] == 1 && !chk[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		chk[v] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			
			for (int i = 1; i <= N; i++) {
				if(adjMatrix[cur][i] == 1 && !chk[i]) {
					q.offer(i);
					chk[i] = true;					
				}
			}
		}
		
	}

}
