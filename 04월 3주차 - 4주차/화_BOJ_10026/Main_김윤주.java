import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 적록색약_bj_10026 {
	
	static int N, normal, abnormal;
	static char[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 정상
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				dfs(i, j, map[i][j]);
				normal++;
			}
		}
		
		// 적록색약 카운트를 위해 visited 배열 초기화
		for(int i=0; i<N; i++) {
			Arrays.fill(visited[i], false);
		}
		
		// 적록색약 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				dfs(i, j, map[i][j]);
				abnormal++;
			}
		}
		
		System.out.println(normal + " " + abnormal);
	}
	
	static void dfs(int y, int x, char c) {
		
		// 적록색약 카운트를 위해 현재 탐색하는 color가 G일 때 R로 바꿔줌
		if(c == 'G') map[y][x] = 'R';
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if( ny<0 || nx<0 || ny>=N || nx>= N || visited[ny][nx] || map[ny][nx] != c ) continue;
			
			dfs(ny, nx, c);
		}
	}

}
