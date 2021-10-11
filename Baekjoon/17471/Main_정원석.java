import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, ans = 1;
	static char[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {			
			map[i] = br.readLine().toCharArray();
		}
		
		loop: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != 'W') continue;
				
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(chkvalid(nx, ny)) {
						if(map[nx][ny] == 'S') {
							ans = 0;
							break loop;						
						}else if(map[nx][ny] == '.') map[nx][ny] = 'D';
						
					}
				}
				
			}
		}
		
		System.out.println(ans);
		if(ans == 1) printMap();
		
	}
	
	static void printMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static boolean chkvalid(int x, int y) {
		if(x < 0 || x >= R || y < 0 || y >= C) return false;
		return true;
	}

}
