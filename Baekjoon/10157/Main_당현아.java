import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int RESULT_I, RESULT_J;
	static int C, R, N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken()) + 1;
		R = Integer.parseInt(st.nextToken()) + 1;
		N = Integer.parseInt(br.readLine());

		map = new int[C][R];

		if (C * R < N)
			System.out.println(0);
		else {
			int n = 1, i = 1, j = 0, sw = 1, len_r = R, len_c = C - 1;

			while (n < R * C) {
				if (len_c >= 1) {
					for (int r = 1; r < len_r; r++) {
						j = j + sw;
						map[i][j] = n++;
						if (n - 1 == N) {
							RESULT_I = i;
							RESULT_J = j;
						}
					}

					if (RESULT_I != 0) {
						break;
					}

					len_r = len_r - 1;
				} else {
					break;
				}

				if (len_r >= 1) {
					for (int c = 1; c < len_c; c++) {
						i = i + sw;
						map[i][j] = n++;
						if (n - 1 == N) {
							RESULT_I = i;
							RESULT_J = j;
						}
					}

					if (RESULT_I != 0) {
						break;
					}

					len_c = len_c - 1;
					sw = sw * -1;
				} else {
					break;
				}
			}

			System.out.println(RESULT_I + " " + RESULT_J);
		}
	}
}