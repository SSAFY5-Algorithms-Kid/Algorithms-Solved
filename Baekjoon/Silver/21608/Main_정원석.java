package May_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_No21608_상어초등학교 {
	
	static int N, fCnt, eCnt, px, py, answer = 0;
	static int[][] map, students;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		students = new int[N*N+1][5];
		
		for (int i = 1; i <= N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				students[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int n = 1; n <= N*N; n++) {
			fCnt = 0; eCnt = 0; px = -1; py = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != 0) continue;
					if(px == -1) {
						px = i;
						py = j;
					}
					int tmpF = cntF(i, j, n);
//					System.out.println(students[n][0] + " " + tmpF);
					if(tmpF > fCnt) {
						px = i;
						py = j;
						fCnt = tmpF;
						eCnt = cntE(i, j);
					}else if(tmpF == fCnt) {						
						int tmpE = cntE(i, j);
						if(tmpE > eCnt) {
							px = i;
							py = j;
							eCnt = tmpE;
						}else if(eCnt == tmpE) {							
							if(px > i) {
//								System.out.println(px + " " + py);
								px = i;
								py = j;
							}else if(px == i && py > j) {
								px = i;
								py = j;
							}
						}
					}
				}
			}
//			System.out.println(students[n][0] + " " + px + " " + py);
			map[px][py] = n;
//			printMap();
		}
		chkSatisfy();
		System.out.println(answer);
	}
	
	static void printMap() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	static void chkSatisfy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = cntF(i, j, map[i][j]);
				if(cnt != 0) answer += Math.pow(10, cnt-1);
			}
		}
	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	
	static int cntE(int x, int y) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(chkvalid(nx, ny) && map[nx][ny] == 0) result++;
		}
		return result;
	}
	
	static int cntF(int x, int y, int ind) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(chkvalid(nx, ny) && map[nx][ny] != 0) {
				for (int j = 1; j < 5; j++) {
					if(students[ind][j] == students[map[nx][ny]][0]) result++;
				}
			}
		}
		return result;
	}

}
