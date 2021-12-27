package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2210_숫자판점프 {
	
	static String[][] map = new String[5][5];
	static ArrayList<String> list = new ArrayList<>();
	static boolean[][] chk;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = st.nextToken();
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				chk = new boolean[5][5];
				chk[i][j] = true;
				dfs(map[i][j], i, j);
				
			}
		}
		
		System.out.println(list.size());

	}
	
	static void addList(String str) {
		for (int i = 0, size = list.size(); i < size; i++) {
			if(list.get(i).equals(str)) return;
		}
		list.add(str);
	}
	
	static void dfs(String str, int x, int y) {
		if(str.length() == 6) {
			addList(str);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(chkvalid(nx, ny)) {
				dfs(str + map[nx][ny], nx, ny);
			}
		}
		
	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= 5 || y < 0 || y >= 5) return false;
		return true;
	}

}
