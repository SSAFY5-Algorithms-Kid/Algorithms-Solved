package BOJ;

import java.util.*;
/**
 * @author JAEWOO SHIM
 * @date
 *
 * PriorityQueue를 이용해서 풀었다.
 *
 */
public class Main_BOJ_2891_카약과강풍_S5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();	// 팀의 수
		int S = sc.nextInt();	// 카약이 손상된 팀의 수
		int R = sc.nextInt();	// 카약을 하나 더 가져온 팀의 수
		ArrayList<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> broken = new PriorityQueue<>();
		PriorityQueue<Integer> one_more = new PriorityQueue<>();
		Queue<Integer> que = new LinkedList<>();

		for (int i = 0; i < S; i++) {
			int broke = sc.nextInt();
			list.add(broke);
		}
		a : for (int i = 0; i < R; i++) {
			int more = sc.nextInt();
			for (int j = 0; j < list.size(); j++) {
				if (more == list.get(j)) {
					list.remove(j);
					continue a;
				}
			}
			one_more.offer(more);
		}
		for (int i = 0; i < list.size(); i++) {
			broken.offer(list.get(i));
		}
		for (int i = 1; i <= N; i++) {
			if (!broken.isEmpty() && broken.peek()==i) {
				if (i-1>=1 && !one_more.isEmpty() && one_more.peek()==i-1) {
					broken.poll();
					one_more.poll();
					continue;
				}
				if (i+1<=N && !one_more.isEmpty() && one_more.peek()==i+1) {
					broken.poll();
					one_more.poll();
					continue;
				}
				que.offer(i);
				broken.poll();
			}
			if (!one_more.isEmpty() && one_more.peek()<i-1) {
				one_more.poll();
			}
		}
		System.out.println(que.size());

	}
}
