import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N, cnt;
	static int[][] map;
	static boolean[][] chk;
	static ArrayList<Integer> list;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		chk = new boolean[N][N];
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 || chk[i][j]) continue;
				
				Queue<point> q = new LinkedList<>();
				q.offer(new point(i, j));
				chk[i][j] = true;
				cnt = 1;
				
				while(!q.isEmpty()) {
					point cur = q.poll();
					for (int k = 0; k < 4; k++) {
						int nx = cur.x + dx[k];
						int ny = cur.y + dy[k];
						if(chkvalid(nx, ny) && map[nx][ny] == 1 && !chk[nx][ny]) {
							q.offer(new point(nx, ny));
							chk[nx][ny] = true;
							cnt++;
						}
					}
				}
				list.add(cnt);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	
	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}

}
