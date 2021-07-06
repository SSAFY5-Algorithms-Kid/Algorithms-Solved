package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_S2_2644_촌수계산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int m = sc.nextInt();
		
		int[][] map = new int[n+1][n+1];
		
		for (int i = 0; i < m; i++) {
			
			int p = sc.nextInt();
			int c = sc.nextInt();
			
			map[p][c]=map[c][p]=1;
		}
		
//		boolean[] v = new boolean[n+1];
		int[] v = new int[n+1];
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(a);
		v[a]=0;
		while(!que.isEmpty()) {
			int curr = que.poll();
//			int cnt = que.poll();
			if (curr == b) {
				System.out.println(v[b]);
				System.exit(0);
			}
			for (int i = 1; i <= n; i++) {
				if (v[i]!=0) {
					continue;
				}
				if (map[curr][i]==1) {
					que.offer(i);
					v[i]=v[curr]+1;
				}
			}
		}
		System.out.println(-1);
	}
}
