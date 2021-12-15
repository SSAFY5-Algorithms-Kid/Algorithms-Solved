import java.util.*;

public class Main_적록 {
	static char[][] map;
	static char[][] map2;
	static boolean[][] area1;
	static boolean[][] area2;
	static int N;
	static int[] xdir = { 1, -1, 0, 0 };
	static int[] ydir = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new char[N][N]; //눈이 정상인 사람이 보는 맵 
		area1 = new boolean[N][N]; //정상인 사람의 방문체크 
		map2 = new char[N][N]; //적록색약의 맵 
		area2 = new boolean[N][N]; //적록색약의 방문체크 

		for (int i = 0; i < N; i++) {
			char[] temp = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j];
				if(temp[j]=='G'||temp[j]=='R') { //입력 단계에서, 바로 적색 또는 녹색일때, 같은 G값으로 넣어줌  
					map2[i][j] = 'G';
				}
				else {
					map2[i][j] = temp[j];
				}
			}
		}
		//입력끝 !
		
		int cnt = 0; //정상영역 개수 
		int gcnt = 0;//적록 영역 개수 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!area1[i][j]) {
					bfs(j, i); //방문되지 않은 시작점이 있으면, 그곳에서 BFS 돈다. 영역 개수 추가해준다.
					cnt++;
				}
				if(!area2[i][j]) {
					grbfs(j,i);
					gcnt++;
				}
			}
		}
		System.out.print(cnt+" ");
		System.out.print(gcnt);
		//정답 출력 
	}

	private static void grbfs(int x, int y) { //적록색약 영역에서 도는 BFS 함수 
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		while (!q.isEmpty()) {
			Node t = q.poll();
			char color = map2[t.y][t.x];
			for (int k = 0; k < 4; k++) {
				int dx = t.x + xdir[k];
				int dy = t.y + ydir[k];
				if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
					if (!area2[dy][dx] && map2[dy][dx] == map2[y][x]) { // 0일때만 BFS동작
						area2[dy][dx] = true;
						q.add(new Node(dx, dy));
					}
				}
			}
		}
	}

	private static void bfs(int x, int y) { //정상영역에서 도는 BFS 함수 
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		while (!q.isEmpty()) {
			Node t = q.poll();
			char color = map[t.y][t.x];
			for (int k = 0; k < 4; k++) {
				int dx = t.x + xdir[k];
				int dy = t.y + ydir[k];
				if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
					if (!area1[dy][dx] && map[dy][dx] == map[y][x]) { // 0일때만 BFS동작
						area1[dy][dx] = true;
						q.add(new Node(dx, dy));
					}
				}
			}
		}
	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
