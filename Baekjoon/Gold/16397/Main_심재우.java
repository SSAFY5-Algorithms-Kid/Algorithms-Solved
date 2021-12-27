package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * A버튼을 누를때와 B버튼을 누를때를 que에 넣어서
 * bfs를 진행했다.
 *
 *
 */
public class Main_BOJ_16397_탈출_G4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int T = sc.nextInt();
		int G = sc.nextInt();

		boolean[] v = new boolean[100000];

		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(N);
		que.offer(0);
		v[N]=true;

		while(!que.isEmpty()){
			int now = que.poll();
			int cnt = que.poll();

			if (cnt>T) {
				break;
			}

			if (now==G && cnt<=T) {
				System.out.println(cnt);
				System.exit(0);
			}

			int A = now+1;
			int B = calcB(now*2);

			if (A<=99999 && !v[A]) {
				que.offer(A);
				que.offer(cnt+1);
				v[A]=true;
			}

			if ((now*2)<=99999 && !v[B]) {
				que.offer(B);
				que.offer(cnt+1);
				v[B]=true;
			}
		}

		System.out.println("ANG");

	}
	static int calcB(int x) {
		int B = 0;

		if (0<x && x<10) {	//4
			B = x-1;
		}else if (10<=x && x<100) {	//55
			B = x-10;
		}else if (100<=x && x<1000) {
			B = x-100;
		}else if (1000<=x && x<10000) {
			B = x-1000;
		}else if (10000<=x && x<100000) {
			B = x-10000;
		}

		return B;
	}

}
