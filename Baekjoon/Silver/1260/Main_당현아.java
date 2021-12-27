import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static int[][] map;
	static boolean[] visited;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");

		visited = new boolean[N + 1];
		bfs(V);

		System.out.println(sb.toString());
	}

	private static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[idx] = true;
		queue.add(idx);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			
			for (int i = 1; i < N + 1; i++) {
				if (i == now || visited[i])
					continue;
				
				if (map[now][i] == 1) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

	private static void dfs(int idx) {
		if (visited[idx])
			return;

		visited[idx] = true;
		sb.append(idx).append(" ");

		for (int i = 1; i < N + 1; i++) {
			if (i == idx || visited[i])
				continue;
			
			if (map[idx][i] == 1)
				dfs(i);
		}
	}
}