package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author JAEWOO SHIM
 * @date  
 *
 *	<문제>
 *	적록 색약인 사람과 적록 색약이 아닌 사람이 봤을 때의 
 *	RGB로 나누어진 영역의 개수를 구하라
 *
 *	<제약사항>
 *	1 <= N <= 100
 *
 *	<풀이>
 *	dfs로 같은 문자인 경우 같은 영역으로 표시해 준다.
 *	color와 nocolor 배열에 영역을 표시해준다 
 *	dfs 들어갈 때마다 cnt++ 을 해줘서 영역을 구분
 *	
 *	처음엔 dfs 한번으로 풀려고 했는데 오류가 쩔어서
 *	dfs를 색약/색약x 두가지로 나누어서 두번 돌렸다..
 *
 *	dfs 한번으로 풀 수 있을까요?
 */
public class BOJ_10026_심재우 {

	static int N;
	static char[][] map;
	static boolean[][] v;
	static boolean[][] nv;
	static int[][] color;
	static int[][] nocolor;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];		// 입력받는 RGB 배열
		color = new int[N][N];		// 색약 없는 사람
		nocolor = new int[N][N];	// 색약 있는 사람
		v = new boolean[N][N];		// 색약 없는 사람의 visited
		nv = new boolean[N][N]; 	// 색약 있는 사람의 visited
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 입력 완료
		
		// 색약 없는 사람
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j]) {
					continue;
				}
				cnt++;	// ++을 먼저 해주면 출력시에 -1 안해도 된다
				area(i, j, cnt);
			}
		}
		
		// 색약 있는 사람
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (nv[i][j]) {
					continue;
				}
				cnt2++;
				area2(i, j, cnt2);
			}
		}
		
		//출력
		System.out.println(cnt+" "+cnt2);
		
		
//		int cnt2 = 0 ;
//		int[] checkcnt = new int[10001];
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (checkcnt[nocolor[i][j]]==0) {
//					checkcnt[nocolor[i][j]]++;
//				}
//			}
//		}
//		for (int i = 0; i < 10001; i++) {
//				if (checkcnt[i]!=0) {
//					cnt2++;
//				}
//			
//		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(nocolor[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	// 색약 x dfs
	static void area(int r, int c, int cnt) {
		char currcolor = map[r][c];
		color[r][c]=cnt;
//		nocolor[r][c]=cnt;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (!check(nr,nc)) {
				continue;
			}
			if (v[nr][nc]) {
				continue;
			}
			if (map[nr][nc]==currcolor) {
//				if (currcolor=='B') {
//					nocolor[nr][nc]=cnt;
//				}
				color[nr][nc]=cnt;
				v[nr][nc]=true;
				area(nr,nc,cnt);
			}
//			if (nocolor[nr][nc]==0 &&(currcolor=='R' || currcolor=='G')&&(map[nr][nc]=='R' || map[nr][nc]=='G')) {
//				nocolor[nr][nc]=cnt;
//			}
		}
	}
	
	// 색약 o dfs
	static void area2(int r, int c, int cnt) {
		char currcolor = map[r][c];
//		color[r][c]=cnt;
		nocolor[r][c]=cnt;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (!check(nr,nc)) {
				continue;
			}
			if (nv[nr][nc]) {
				continue;
			}
			if (map[nr][nc]==currcolor && currcolor=='B') {
				nocolor[nr][nc]=cnt;
				nv[nr][nc]=true;
				area2(nr,nc,cnt);
			}
			if (nocolor[nr][nc]==0 &&(currcolor=='R' || currcolor=='G')&&(map[nr][nc]=='R' || map[nr][nc]=='G')) {
				nocolor[nr][nc]=cnt;
				nv[nr][nc]=true;
				area2(nr,nc,cnt);
			}
		}
	}
	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}


/*
 * 반례
2
RG
BR

*/
