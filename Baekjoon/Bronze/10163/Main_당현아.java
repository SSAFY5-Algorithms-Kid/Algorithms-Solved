import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 101;
	static int[][] map = new int[MAX][MAX];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("inputfile/ColoredPaper_10163.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int heigth = Integer.parseInt(st.nextToken());

			for (int i = row; i < row + width; i++) {
				for (int j = col; j < col + heigth; j++) {
					map[i][j] = n;
				}
			}
		}

		for (int n = 1; n <= N; n++) {
			int cnt = 0;

			for (int i = 0; i < MAX; i++)
				for (int j = 0; j < MAX; j++)
					if (map[i][j] == n)
						cnt++;

			System.out.println(cnt);
		}
	}

}