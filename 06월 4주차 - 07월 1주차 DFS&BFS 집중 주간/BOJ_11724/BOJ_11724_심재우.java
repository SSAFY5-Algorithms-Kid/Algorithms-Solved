package BOJ;

import java.util.Scanner;

public class Main_BOJ_S2_11724_연결요소의개수 {

	static int N, M;
	static int[][] node;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		node = new int[N+1][N+1];
		
		v = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			node[a][b]=node[b][a]=1;
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (!v[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
		
	}

	static void dfs(int num) {
		v[num]=true;
		
		for (int i = 1; i <= N; i++) {
			if (node[num][i]==1 && !v[i]) {
				dfs(i);
			}
		}
	}

}
