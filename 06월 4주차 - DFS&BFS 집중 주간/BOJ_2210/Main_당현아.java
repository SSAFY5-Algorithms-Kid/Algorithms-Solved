import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N = 5;
	static int[][] map = new int[5][5];
	static StringBuffer sb;
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				dfs(i, j, 1, Integer.toString(map[i][j]));

		System.out.println(list.size());
	}

	static int[][] DELTA = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

	private static void dfs(int i, int j, int cnt, String data) {
		if (data.length() == 6) {
			if(!list.contains(data))
				list.add(data);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = i + DELTA[d][0];
			int ny = j + DELTA[d][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			dfs(nx, ny, cnt + 1, data + Integer.toString(map[nx][ny]));
		}
	}
}