import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] index;
	static int N, MIN;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		index = new int[N / 2];
		MIN = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		combination(0, 0);
		System.out.println(MIN);
	}

	static void combination(int cnt, int start) {

		if (cnt == N / 2) {
			// System.out.println(Arrays.toString(index));
			teamScore(index);
			return;
		}

		for (int i = start; i < N; i++) {
			index[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

	static void teamScore(int[] list) {
		int[] other_list = new int[N / 2];

		int cnt = 0;
		for (int i = 0; i < N; i++)
			if (!(check(list, i)))
				other_list[cnt++] = i;

		int startTeam = score(list);
		int linkTeam = score(other_list);

		MIN = Math.min(Math.abs(startTeam - linkTeam), MIN);
	}

	private static int score(int[] list) {
		int sum=0;
		for(int i=0;i<list.length;i++) {
			for(int j=i+1;j<list.length;j++) {
				sum += map[list[i]][list[j]] + map[list[j]][list[i]];
			}
		}
		return sum;
	}

	private static boolean check(int[] list, int value) {
		for (int i = 0; i < list.length; i++)
			if (list[i] == value)
				return true;
		return false;
	}
}