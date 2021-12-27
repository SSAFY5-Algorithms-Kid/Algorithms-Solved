import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("BOJ.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[101][101];

		for (int s = 0; s < 4; s++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++)
				for (int j = y1; j < y2; j++)
					map[j][i] = 1;
		}

		System.out.println(oneCnt());
	}

	private static int oneCnt() {
		int cnt = 0;
		for (int i = 1; i < 101; i++)
			for (int j = 1; j < 101; j++)
				if (map[i][j] == 1)
					cnt++;
		return cnt;
	}
}