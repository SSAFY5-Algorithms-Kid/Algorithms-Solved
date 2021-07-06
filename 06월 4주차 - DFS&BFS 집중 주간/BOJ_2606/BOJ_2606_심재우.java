package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_S3_2606_바이러스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int link = sc.nextInt();
		
		int[][] node = new int[n+1][n+1];
		boolean[] v = new boolean[n+1];
		
		for (int i = 0; i < link; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			node[x][y]=node[y][x]=1;
		}
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(1);
		v[1]=true;
		int cnt = 0;
		while(!que.isEmpty()) {
			int curr = que.poll();
			for (int i = 1; i <= n; i++) {
				if (v[i]) {
					continue;
				}
				if (node[curr][i]==1) {
					que.offer(i);
					v[i]=true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}

/*
4
3
1 2
2 4
3 4

*/