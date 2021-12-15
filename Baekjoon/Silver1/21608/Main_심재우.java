package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *	<풀이>
 *	처음엔 그냥 queue를 이용해서 들어갈 수 있는 자리를 모두 담아서
 *	좋아하는 학생수, 빈자리 를 비교해주면서 queue에서 지우는 방식으로 구현했는데
 *	시간초과가 나서 아예 처음부터 비교하면서 queue에 넣을 수 있게
 *	pq를 이용하니 pass함
 */
public class Main_BOJ_S1_21608_상어초등학교 {

	static class seat implements Comparable<seat>{
		int r;
		int c;
		int emp;
		int like;
		public seat(int r, int c, int emp, int like) {
			super();
			this.r = r;
			this.c = c;
			this.emp = emp;
			this.like = like;
		}
		@Override
		public String toString() {
			return "[" + r + ", " + c + ", " + emp + ", " + like + "]";
		}
		@Override
		public int compareTo(seat o) {
			if (o.like==this.like) {
				if (o.emp==this.emp) {
					if (o.r==this.r) {
						return o.c-this.c;
					}
					return o.r-this.r;
				}
				return o.emp-this.emp;
			}
			return o.like-this.like;
		}
		
	}
	static int n;
	static int[][] map;
	static int[][] likea;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		likea = new int[n*n][4];
		int[] stidx = new int[n*n];
		for (int i = 0; i < n*n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken())-1;
			stidx[i]=idx+1;
			for (int j = 0; j < 4; j++) {
				likea[idx][j]=Integer.parseInt(st.nextToken());
			}
		}
		// like[1][n] 중에서 map에 있냐?
		// -> 빈칸의 4방을 탐색하는데 빈칸이 몇개인지, 좋아하는 애가 몇명인지 각 칸별로 탐색
		// 좋아하는 애의 수가 제일 많은 칸이 여러개이면 그중에서 빈칸이 많은 칸을 선택
		// 그중 빈칸이 많은 칸도 여러개이면 가장 빠른 곳으로 들어간다
		ans = 0;
//		map[1][1]=stidx[0];
		for (int i = 0; i < n*n; i++) {
			select(stidx[i]);
		}
		
		// 각 칸별로 조사
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				likecheck(i,j,map[i][j]);
			}
		}
		System.out.println(ans);
				
	}
	// 답 계산
	static void likecheck(int r, int c, int stno) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr,nc)) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				if (map[nr][nc]==likea[stno-1][i]) {
					cnt++;
				}
			}
		}
		if (cnt==1) {
			ans+=1;
		}
		if (cnt==2) {
			ans+=10;
		}
		if (cnt==3) {
			ans+=100;
		}
		if (cnt==4) {
			ans+=1000;
		}
	}
	// 자리를 고른다
	static void select(int stno) {
		PriorityQueue<seat> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j]==0) {
					int empty = 0;
					int likest = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						if (!check(nr,nc)) {
							continue;
						}
						if (map[nr][nc]==0) {
							empty++;
						}else {
							for (int k = 0; k < 4; k++) {
								if (map[nr][nc]==likea[stno-1][k]) {
									likest++;
								}
							}
						}
					}
					pq.offer(new seat(i, j, empty, likest));
				}
			}
		}
		// 제일 앞에 있는 애가 들어갈 자리
		seat selec = pq.poll();
		map[selec.r][selec.c]=stno;
	}
	static boolean check(int r, int c) {
		return r>=0 && r<n && c>=0 && c<n;
	}
}

