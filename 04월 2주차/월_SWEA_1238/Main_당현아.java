import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{

	// 10개 제한 테스트 케이스
	// N 길이, S 시작
	static int T = 10, N, S;
	static int[][] adjMatrix; // 인접행렬

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			adjMatrix = new int[N + 1][N + 1]; // 입력되는 숫자가 1~100으로 0 dummy를 만들어준다.

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = 1;
			}

			System.out.println("#" + t + " " + bfs());
		}

	}

	private static int bfs() {
		int maxNum = 0;
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[S] = true;
		queue.offer(S);

		while (!queue.isEmpty()) {
			int size = queue.size(); // 하나씩 확인하는 것이 아닌 지금 단계의 모든 내용을 확인
			maxNum = 0;

			for (int s = 0; s < size; s++) {
				int now = queue.poll();

				maxNum = Math.max(maxNum, now); // 현재 단계의 최대 번호 찾기

				for (int i = 1; i < N + 1; i++) {
					if (!visited[i] && adjMatrix[now][i] == 1) {
						// 방문하지 않고, 연결되어있으면 다음 단계에 추가
						visited[i] = true;
						queue.offer(i);
					}
				}
			}

		}

		return maxNum; // 가장 마지막 단계의 최대 번호 반환
	}
}