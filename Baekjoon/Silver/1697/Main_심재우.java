package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_S2_1697_숨바꼭질 {

	static int subin, bro;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		subin = sc.nextInt();
		bro = sc.nextInt();
		
		boolean[] v = new boolean[100001];
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(subin);
		v[subin]=true;
		que.offer(0);
		while(!que.isEmpty()) {
			int curr = que.poll();
			int cnt = que.poll();
			
			if (curr == bro) {
				System.out.println(cnt);
				break;
			}
			
			// 범위를 먼저...
			if (curr-1>=0) {
				if (!v[curr-1]) {
					que.offer(curr-1); que.offer(cnt+1);
					v[curr-1]=true;
				}
			}
			
			if (curr+1<100001) {
				if (!v[curr+1]) {
					que.offer(curr+1); que.offer(cnt+1);
					v[curr+1]=true;
				}
			}
			
			if (2*curr<100001) {
				if (!v[curr*2]) {
					que.offer(curr*2); que.offer(cnt+1);
					v[curr*2]=true;
				}
			}
		}
		
		
	}
	

}
