import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, MIN;
	static int[] person;
	static boolean[] checked;
	static ArrayList<ArrayList<Integer>> DATA;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 총 Node 수 입력
		N = Integer.parseInt(br.readLine());

		// 초기화
		person = new int[N + 1];
		checked = new boolean[N + 1];
		DATA = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			DATA.add(new ArrayList<>());
		MIN = Integer.MAX_VALUE;

		// 인구 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++)
			person[n] = Integer.parseInt(st.nextToken());

		// 각 Node마다의 정보 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			for (int d = 0; d < D; d++)
				DATA.get(i).add(Integer.parseInt(st.nextToken()));
		}

		subset(1, 0);

		System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
	}

	private static void subset(int idx, int cnt) {
		if (cnt == N) {
			int trueSum = 0, falseSum = 0;
			int trueCnt = 0, falseCnt = 0;
			for (int i = 1; i <= N; i++) {
				if (checked[i]) {
					trueCnt++;
					trueSum += person[i];
				} else {
					falseCnt++;
					falseSum += person[i];
				}
			}

			// 두 구간으로 나누어 졌을 때,
			if (trueCnt > 0 && falseCnt > 0) {
				// 두 구간이 서로 연결되었을 때,
				if (connectCkeck(true) && connectCkeck(false)) {
					MIN = Math.min(MIN, Math.abs(trueSum - falseSum));
				}
			}

			return;
		}

		checked[idx] = false;
		subset(idx + 1, cnt + 1);
		checked[idx] = true;
		subset(idx + 1, cnt + 1);
	}

	private static boolean connectCkeck(boolean check) {
		boolean[] use = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++)
			if (checked[i] == check) {
				queue.offer(i);
				use[i] = true;
				break;
			}

		while (!queue.isEmpty()) {
			int now = queue.poll();
			// System.out.println(now);

			ArrayList<Integer> temp = DATA.get(now);

			for (Integer i : temp) {
				if (checked[i] == check && !use[i]) {
					queue.offer(i);
					use[i] = true;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (checked[i] == check && !use[i])
				return false;
		}
		return true;
	}
}