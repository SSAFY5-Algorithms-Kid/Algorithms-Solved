import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = 5;
	static int[][] BINGO = new int[N][N];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("inputfile/BINGO.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 빙고 판 초기화
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				BINGO[i][j] = Integer.parseInt(st.nextToken());
		}

		// 사회자의 호명
		int cnt = 0;
		boolean done = false;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (!done) { // 빙고가 끝나지 않았을 때만 계산
					++cnt; // 현재 숫자 증가
					bingoCheck(num); // 불린 숫자 지우기
					if (gameDoenCheck() >= 3) // 3개 이상이면
						done = true; // 빙고 완성
				}
			}
		}

		// 결과 출력
		System.out.println(cnt);
	}

	private static int gameDoenCheck() {
		int total = 0;
		total += rowCheck();
		total += colCheck();
		total += crossCheck();
		return total;
	}

	private static int crossCheck() {
		int cnt = 0;
		// 우하 방향
		int sum = 0;
		for (int n = 0; n < N; n++)
			sum += BINGO[n][n];

		if (sum == 0)
			cnt++;

		sum = 0;
		int i = 0, j = N - 1;
		for (int n = 0; n < N; n++)
			sum += BINGO[i++][j--];

		if (sum == 0)
			cnt++;

		return cnt;
	}

	private static int colCheck() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++)
				sum += BINGO[j][i];
			if (sum == 0)
				cnt++;
		}
		return cnt;
	}

	private static int rowCheck() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;

			for (int j = 0; j < N; j++)
				sum += BINGO[i][j];

			if (sum == 0)
				cnt++;
		}
		return cnt;
	}

	private static void bingoCheck(int value) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (BINGO[i][j] == value)
					BINGO[i][j] = 0;
	}
}