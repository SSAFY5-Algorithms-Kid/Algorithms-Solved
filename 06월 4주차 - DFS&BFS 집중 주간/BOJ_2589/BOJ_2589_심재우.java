package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *	<문제>
 *	보물은 서로간에 최단 거리가 가장 긴 두 곳에 있다
 *	-> 시작점, 종점 두곳에 보물이 있다.
 *	그 거리를 출력하라
 *
 *	<제약 사항>
 *	L은 육지 W는 바다이고 육지만 이동가능
 *	n * m 배열
 *  가로세로는 50이하
 *  
 *  <풀이>
 *  육지인 지점마다 bfs를 이용해서 깊이를 측정한다.
 *  그 깊이가 가장 깊게 들어가는 지점에서의 시작점과 종점이 보물의 위치이다.
 *  각 지점마다 새롭게 bfs를 돌리고 가장 큰 깊이와 비교하며 시작점과 종점을 바꿔준다.
 *  
 */
public class Main_BOJ_G5_2589_보물섬 {

	static int n;
	static int m;
	static char[][] map;
	static int[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Queue<Integer> que;
	static int sr, sc, er, ec;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		v = new int[n][m];
		for (int i = 0; i < n; i++) {
			map[i]=br.readLine().toCharArray();
		}
		// 입력 완료
		que = new LinkedList<>();
		max = Integer.MIN_VALUE;	// depth 최대 깊이
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				v = new int[n][m];	// 매번 depth를 새로 체크해야한다.
				if (map[i][j]=='L') {	// L 일때마다 한번씩 다 간다
					que.clear();	// 혹시몰라 que 초기화
					que.offer(i); que.offer(j);
					bfs(i, j);
				}
			}
		}
		System.out.println(max);
		
	}
	private static void bfs(int r, int c) {
		while(!que.isEmpty()) {
			int cr = que.poll();
			int cc = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc+ dc[d];
				
				if (!check(nr,nc)) {
					continue;
				}
				if (v[nr][nc]!=0) {
					continue;
				}
				if (map[nr][nc]=='W') {
					continue;
				}
				que.offer(nr);
				que.offer(nc);
				v[nr][nc]=v[cr][cc]+1;	// 얘가 depth
				if (max<=v[nr][nc]) {	// 최대 depth가 갱신될 때
					max = Math.max(max, v[nr][nc]); 
					sr = r;		// 시작점 r
					sc = c;		// 시작점 c
					er = nr;	// 종점 r
					ec = nc;	// 종점 c
				}
				
			}
			
		}
	}
	static boolean check(int r, int c) {
		return r>=0 && r<n && c>=0 && c<m;
	}

}
