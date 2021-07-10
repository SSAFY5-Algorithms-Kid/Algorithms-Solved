import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] wheel;
	static int[] check;
	static int N, NUM = 4, TIP = 8;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		wheel = new int[NUM][TIP]; // 2 : 우측, 6 : 좌측

		for (int i = 0; i < NUM; i++) {
			String temp = br.readLine();
			for (int j = 0; j < TIP; j++)
				wheel[i][j] = temp.charAt(j) - '0';
			// 각 0열은 12시 방향, 0 : N극, 1 : S극
		}

		N = Integer.parseInt(br.readLine());

		// for (int i = 0; i < NUM; i++)
		// System.out.println(Arrays.toString(wheel[i]));
		// System.out.println("===============================");

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			check = new int[NUM];
			int num = Integer.parseInt(st.nextToken()) - 1; // 회전시킨 wheel 번호
			int dir = Integer.parseInt(st.nextToken()); // 방향, 1 : 시계, -1 : 반시계

			check[num] = dir;
			int tmpdir = dir;

			// 왼쪽으로 확인
			for (int n = num; n > 0; n--) {
				if (wheel[n][6] != wheel[n - 1][2]) {
					tmpdir *= -1;
					check[n - 1] = tmpdir;
				} else
					break; // 맞물리는 곳이 같으면 체크 X
			}

			tmpdir = dir;

			// 오른쪽으로 확인
			for (int n = num; n < NUM - 1; n++) {
				if (wheel[n][2] != wheel[n + 1][6]) {
					tmpdir *= -1;
					check[n + 1] = tmpdir;
				} else
					break; // 맞물리는 곳이 같으면 체크 X
			}

			// System.out.println(Arrays.toString(check));

			// 전부 확인하면서 회전하기
			for (int n = 0; n < NUM; n++) {
				if (check[n] == 1)
					roll(wheel[n]);
				else if (check[n] == -1)
					rollReverse(wheel[n]);
			}

			//for (int n = 0; n < NUM; n++)
			//	System.out.println(Arrays.toString(wheel[n]));
			//System.out.println("===============================");
		}

		int sum = 0;
		for (int i = 0; i < NUM; i++) {
			if (wheel[i][0] == 1)
				sum += (int) Math.pow(2, i);
		}

		System.out.println(sum);
	}

	private static void roll(int[] data) {
		int temp = data[data.length - 1];
		for (int i = data.length - 1; i > 0; i--) {
			data[i] = data[i - 1];
		}
		data[0] = temp;
	}

	private static void rollReverse(int[] data) {
		int temp = data[0];
		for (int i = 0; i < data.length - 1; i++) {
			data[i] = data[i + 1];
		}
		data[data.length - 1] = temp;
	}
}