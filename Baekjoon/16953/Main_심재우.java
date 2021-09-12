package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *	<문제>
 *	A -> B
 *	1. A에 2를 곱한다.
 *	2. 10A + 1 을 한다.
 *	<제약사항>
 *	1 <= A < B <= 10^9 이라서 long 형으로 선언해준다.
 *	출력은 최소값+1 을 해준다.
 *	<풀이>
 *	1번과 2번 계산을 bfs를 이용해 최소값을 찾는다.
 */
public class Main_BOJ_S1_16953_AtoB {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		Queue<long[]> que = new LinkedList<>();
		que.offer(new long[] {A, 0});
		while(!que.isEmpty()) {
			long[] curr = que.poll();
			long ca = curr[0];
			long cnt = curr[1];
			if (ca == B) {
				System.out.println(cnt+1);
				return;
			}
			long a2 = ca * 2;
			if (a2<=B) {
				que.offer(new long[] { a2, cnt+1});
			}
			
			long a1 = ca*10 + 1;
			if (a1<=B) {
				que.offer(new long[] { a1, cnt+1});
			}
		}
		System.out.println("-1");

	}

}
