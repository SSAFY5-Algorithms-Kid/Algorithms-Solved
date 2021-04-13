package study_0401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * <수빈이의 움직임>
 * 1. 걷기 : 걸으면 X-1, X+1 이동
 * 2. 순간이동 : 2*X 이동
 * 
 * <동생의 움직임>
 * 1. n초 후 다음 위치 : K + 1 + ... + n
 * 
 * 가장 빠른 시간 찾기
 * 찾을 수 없거나 500000을 넘으면 -1
 */

// 1 : 완전탐색 - 테스트 케이스 2번 반례 생김 >> Fail
// 2 : 검색 후 코드 분석


public class HideAndSeek5_17071 {
	
	static final int MAX = 500000;
	static final int ODD = 1;
	static final int EVEN = 0;
	
	static Queue<Integer> queue;
	static boolean[][] visited;
	static int subin, brother;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		queue = new LinkedList<Integer>();
		visited = new boolean[2][MAX + 1];
		// 방문체크 - 내 코드와 달라진 점 : 나는 한번에 모든 방문을, 여기선 홀/짝수를 별개로 방문 체크를 하였다.
		// Why? 각 짝/홀은 자기 자신으로 올 수 있다.  
		// 1번 좌표 (+1;1번) > 2번 좌표(-1;2번) > 1번 좌표(-;3번) 
		// 위와 같은 움직임, 즉 n일때 n+2일때 자기 자신으로 돌아올 수 있다. 따라서 별개로 체크하는 것이다. 

		subin = Integer.parseInt(st.nextToken());
		brother = Integer.parseInt(st.nextToken());

		if (subin == brother) {
			// 첫 입력이 같다면 바로 출력 후 종료
			System.out.println(0);
			return;
		}

		// 가장 첫 좌표를 넣으면서 bfs 진행
		queue.offer(subin);

		System.out.println(bfs());
	}

	private static int bfs() {
		int layer = 0; // 짝/홀수 구별
		int time = 0; // 시행 횟수
		int young = brother; // 동생의 좌표 값

		while (!queue.isEmpty()) {
			int size = queue.size(); // 나와 다른 부분 : 현재의 작업을 진행하고자 하는 크기를 확인한다.

			layer = time % 2 == 0 ? EVEN : ODD; // 짝/홀수 계산

			for (int i = 0; i < size; ++i) {
				int old = queue.poll(); // 현재 수빈이의 값

				if (old == young) // 현재 값이 동생과 같으면 지금까지의 횟수를 반환함
					return time;

				if (old * 2 <= MAX) { // 범위 확인
					if (!visited[layer][old * 2]) { // 방문하지 않은 곳일 때만
						visited[layer][old * 2] = true; // 방문 체크 후
						queue.offer(old * 2); // bfs 추가
					}
				}
				
				// 이후 동일
				if (old + 1 <= MAX) {
					if (!visited[layer][old + 1]) {
						visited[layer][old + 1] = true;
						queue.offer(old + 1);
					}
				}
				if (old - 1 >= 0) {
					if (!visited[layer][old - 1]) {
						visited[layer][old - 1] = true;
						queue.offer(old - 1);
					}
				}
			}

			young += ++time; // 시행 횟수를 늘린 후 동생의 이동 거리를 늘려 줌
			if (young > MAX) // 시행 횟수가 500000회사 넘어가면 종료
				return -1;
			if (visited[layer][young]) // 동생의 위치가 true면 이후 과정에서 확인하지 않아도 만난다는 것
				return time;
		}

		return -1; // 찾지 못하면 -1
	}
}

/*
// 첫 코드
public class HideAndSeek5_17071 {
	static int N, K, RESULT; // 수빈이 위치, 동생의 위치, 결과
	static int MIN = 0, MAX = 500000; // 범위
	static boolean[] visited = new boolean[MAX + 1]; // 방문 체크

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		RESULT = -1; // 결과 초기값 

		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(N, K, 0));
		visited[0] = true; // 방문 체크

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			// System.out.println(point);

			if (point.isCorrect()) { // 수빈이와 동생의 위치가 동일하면
				RESULT = point.count; // 현재 길이 저장 후
				break; // 종료
			}

			if (point.count > 500000) // 50만회 이상으로 가면
				continue; // 이후를 진행하지 않고 다음으로

			// 다음이 적절한 범위에서의 진행인지 확인 후 offer
			if (point.subin + 1 >= MIN && point.subin + 1 <= MAX && !visited[point.subin + 1]) {
				queue.offer(new Point(point.subin + 1, point.sister + point.count + 1, point.count + 1));
				visited[point.subin + 1] = true;
			}

			if (point.subin - 1 >= MIN && point.subin - 1 <= MAX && !visited[point.subin - 1]) {
				queue.offer(new Point(point.subin - 1, point.sister + point.count + 1, point.count + 1));
				visited[point.subin - 1] = true;
			}

			if (point.subin * 2 >= MIN && point.subin * 2 <= MAX && !visited[point.subin * 2]) {
				queue.offer(new Point(point.subin * 2, point.sister + point.count + 1, point.count + 1));
				visited[point.subin * 2] = true;
			}
		}

		// 결과값 출력
		System.out.println(RESULT);
	}

	static class Point {
		public int subin;
		public int sister;
		public int count;

		public Point(int subin, int sister, int count) {
			this.subin = subin;
			this.sister = sister;
			this.count = count;
		}

		public boolean isCorrect() {
			return subin == sister;
		}

		@Override
		public String toString() {
			return "Point [subin=" + subin + ", sister=" + sister + ", count=" + count + "]";
		}

	}
}*/
