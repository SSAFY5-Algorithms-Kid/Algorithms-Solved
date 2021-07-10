import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N;
	static final int MAX = 100;
	static int[][] map;
	static boolean[] visited;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input/supplement/FindLoad.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[MAX][MAX];
			visited = new boolean[MAX];
			flag = false;

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = 1;
			}

			visited[0] = true;
			dfs(0);

			System.out.println("#" + tc + " " + (flag ? 1 : 0));
		}
	}

	private static void dfs(int idx) {
		if (idx == 99) {
			flag = true;
			return;
		}
		
		for(int i=0;i<MAX;i++) {
			if(!visited[i] && map[idx][i] == 1) {
				visited[i] = true;
				dfs(i);
				visited[i] = false;
			}
		}
		
	}

}