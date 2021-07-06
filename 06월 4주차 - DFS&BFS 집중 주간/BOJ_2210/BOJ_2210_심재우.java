package BOJ;

import java.util.*;

public class Main_BOJ_S2_2210_숫자판점프 {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map;
	static int cnt;
	static ArrayList<String> list;
	static int ans;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		map = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i,j,1,map[i][j]+"");
			}
		}
		System.out.println(list.size());
	}
	static void dfs(int r, int c, int cnt, String s) {
		if (cnt==6) {
			if (!list.contains(s)) {
				list.add(s);
			}
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (!check(nr,nc)) {
				continue;
			}
			
			dfs(nr,nc,cnt+1,s+map[nr][nc]);
			
		}
	}
	
	static boolean check(int r, int c) {
		return r>=0 && r<5 && c>=0 && c<5;
	}
}
