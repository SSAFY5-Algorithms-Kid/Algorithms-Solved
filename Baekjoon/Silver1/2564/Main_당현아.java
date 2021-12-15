import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int W, H, N, TOTAL, SUM; // 가로, 세로, 상점의 개수
	static int[][] map;
	static int[][] DELTA = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } }; // 시계방향 델타 (좌상우하)
	static int r,c;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("inputfile/Guard.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		SUM = 0;

		map = new int[H+1][W + 1];

		// 상가 정보 세팅
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			if (dir == 1) map[0][len] = n; // 북쪽
			else if (dir == 2) map[H][len] = n; // 남쪽
			else if (dir == 3) map[len][0] = n; // 서쪽
			else if (dir == 4) map[len][W] = n; // 동쪽
		}

		// 동근이의 위치 세팅
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		
		int i = 0, j = 0;
		r=i;c=j;
		if (dir == 1) {i = 0; j = len; dir = 2;} // 북쪽
		else if (dir == 2) {i = H; j = len; dir = 0;} // 남쪽
		else if (dir == 3) {i = len; j = 0; dir = 1;} // 서쪽
		else if (dir == 4) {i = len; j = W; dir = 3;} // 동쪽
		
		for (int n = 1; n <= N; n++) {
			TOTAL = 0;
			leftTurn(i, j, 0, dir, n);
			int rightTurn = (H + W) * 2 - TOTAL;
			SUM += Math.min(TOTAL, rightTurn);
		}
		
		System.out.println(SUM);
	}

	private static void leftTurn(int i, int j, int cnt, int dir, int num) {
		if (cnt >= 0 && map[i][j] == num) {
			TOTAL = cnt;
			return;
		}

		int ni = i + DELTA[dir][0];
		int nj = j + DELTA[dir][1];

		if (ni < 0 || ni > H || nj < 0 || nj > W)
			leftTurn(i, j, cnt, (dir+1) % 4, num);	
		else
			leftTurn(ni, nj, cnt + 1, dir, num);	
	}
}