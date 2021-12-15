import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] check;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		check = new boolean[N + 1];
		map = new boolean[N + 1][N + 1];

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = true;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		check[1] = true;
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i=1;i<=N;i++) {
				if(map[now][i] && ! check[i]) {
					queue.add(i);
					check[i] = true;
				}
			}
		}
		
		int cnt=0;
		for(int i=2;i<=N;i++)
			if(check[i])
				cnt++;
		System.out.println(cnt);
	}
}
