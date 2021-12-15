package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * bfs
 *
 */
public class Main_BOJ_13549_숨바꼭질3_G5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> que = new LinkedList<>();
		int[] v = new int[100001];

		que.offer(N);
		v[N]=1;

		while(!que.isEmpty()) {
			int now = que.poll();

			if (now == K) {
				System.out.println(v[K]-1);
				break;
			}
			// 순간이동은 값이 0 이니까 순간이동을 먼저 시켜준다
			// 반례 1 2  ;; 답 : 0
			if(now*2<=100000) {
				if (v[now*2]==0) {
					que.offer(now*2);
					v[now*2]=v[now];
				}
			}
			if (now-1>=0) {
				if (v[now-1]==0) {
					que.offer(now-1);
					v[now-1]=v[now]+1;
				}
			}

			if(now+1<=100000) {
				if (v[now+1]==0) {
					que.offer(now+1);
					v[now+1]=v[now]+1;
				}
			}

		}

	}

}
