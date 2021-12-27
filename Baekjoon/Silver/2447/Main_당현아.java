package study_0203;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RecursiveStar_2447 {
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		// map 공백 세팅
		for(int i=0;i<N;i++) 
			for(int j=0;j<N;j++)
				map[i][j] = ' ';
		
		// 재귀 - * 세팅
		drawStar(0, 0, N);

		// 출력 세팅
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(map[i][j]);
			sb.append("\n");
		}

		// 결과 출력
		System.out.println(sb);
	}

	public static void drawStar(int x, int y, int N) {
		if (N == 1) {
			map[x][y] = '*';
			return;
		}

		int step = N / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue;
				drawStar(x + (i * step), y + (j * step), step);

			}
		}

	}
}
